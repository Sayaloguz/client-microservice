package com.sarawipay.client_microservice.Client.infrastructure.controller;

import com.sarawipay.client_microservice.Client.application.ClientGenericModel;
import com.sarawipay.client_microservice.Client.application.MerchantGenericModel;
import com.sarawipay.client_microservice.Client.application.TokenService;
import com.sarawipay.client_microservice.Client.application.port.ClientAddUseCase;
import com.sarawipay.client_microservice.Client.application.port.ClientDeleteUseCase;
import com.sarawipay.client_microservice.Client.application.port.ClientGetUseCase;
import com.sarawipay.client_microservice.Client.application.port.ClientUpdateUseCase;
import com.sarawipay.client_microservice.Client.domain.GenericResponseEntity;
import com.sarawipay.client_microservice.Client.domain.mappers.ClientMappers;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.input.ClientInputDTO;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.input.ClientUpdateRequestDTO;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.output.ClientOutputDTO;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.output.ClientIdDTO;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.output.FullClientOutputDTO;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.output.MerchantOutputDTO;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Api(value = "API REST del microservicio de clients")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ClientController {

    private final ClientAddUseCase clientAddUseCase;
    private final ClientGetUseCase clientGetUseCase;
    private final ClientUpdateUseCase clientUpdateUseCase;
    private final ClientDeleteUseCase clientDeleteUseCase;
    private final ClientMappers clientMappers;

    private final TokenService tokenService;


    // TODO: Cambiar respuesta a JSON
    @PostMapping("/create")
    @ApiOperation(value = "Crear un nuevo cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Cliente creado exitosamente", response = Map.class),
    })

    //public ResponseEntity<Map<String, Object>> addClient(
    public GenericResponseEntity<FullClientOutputDTO> addClient(
            @ApiParam(value = "Datos del cliente a crear", required = true)
            @Valid @RequestBody ClientInputDTO clientInputDTO) {

        ClientGenericModel generic = clientMappers.inputToModel(clientInputDTO);


        FullClientOutputDTO newClient = clientMappers.modelToFullOutput(clientAddUseCase.addClient(generic));
        return new GenericResponseEntity<>(
                "Client creado con éxito.",
                String.valueOf(HttpStatus.NO_CONTENT.value()),
                newClient
        );

        // Antes lo hacía así:
        /*
        clientAddUseCase.addClient(generic);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Cliente creado exitosamente");

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
        */
    }


    @GetMapping("/getByName/{name}")
    @ApiOperation(value = "Buscar clientes por nombre")
    public List<FullClientOutputDTO> getByName(
            @ApiParam(value = "Nombre del cliente a buscar", required = true)
            @PathVariable String name) {

        List<ClientGenericModel> res = clientGetUseCase.getByName(name);

        List<FullClientOutputDTO> fullClientOutputDTOList = res.stream()
                .map(clientMappers::modelToFullOutput)
                .collect(Collectors.toList());

        return fullClientOutputDTOList;

    }


    @GetMapping("getByEmail/{email}")
    @ApiOperation(value = "Buscar clientes por email")
    public List<ClientOutputDTO> getByEmail(
            @ApiParam(value = "Email del cliente a buscar", required = true)
            @PathVariable String email) {

        List<ClientGenericModel> res = clientGetUseCase.getByEmail(email);

        List<ClientOutputDTO> clientOutputDTOList = res.stream()
                .map(clientMappers::modelToOutput)
                .collect(Collectors.toList());

        return clientOutputDTOList;
    }


    @GetMapping("getById/{id}")
    @ApiOperation(value = "Buscar cliente por ID")
    public FullClientOutputDTO getById(
            @ApiParam(value = "ID del cliente a buscar", required = true)
            @PathVariable String id) {

        return clientMappers.modelToFullOutput(clientGetUseCase.getById(id));

    }


    @GetMapping("getById/{id}/{simpleOutput}")
    @ApiOperation(value = "Buscar cliente por ID con salida simple")
    public ClientIdDTO getByIdSimple(
            @ApiParam(value = "ID del cliente a buscar", required = true)
            @PathVariable String id,
            @ApiParam(value = "Tipo de salida", required = true)
            @PathVariable String simpleOutput) {

        if (simpleOutput.equalsIgnoreCase("simpleOutput")) {
            return clientMappers.modelToIdDTO(clientGetUseCase.getById(id));
        } else {
            throw new IllegalArgumentException("Valor inválido para simpleOutput");
        }

    }

    @PutMapping("update")
    @ApiOperation(value = "Actualizar cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Cliente actualizado exitosamente", response = Map.class),
    })
    //public ResponseEntity<Map<String, Object>> update(
    public GenericResponseEntity<FullClientOutputDTO> update(
            @ApiParam(value = "Datos del cliente a actualizar", required = true)
            @Valid @RequestBody ClientUpdateRequestDTO clientUpdate) {

        ClientGenericModel updatedClient = clientMappers.updateToModel(clientUpdate);
        clientUpdateUseCase.update(updatedClient);


        return new GenericResponseEntity<>(
                "Cliente actualizado con éxito.",
                String.valueOf(HttpStatus.NO_CONTENT.value()),
                clientMappers.modelToFullOutput(updatedClient)
        );
        /*
        // TODO: Tal como está siempre va a devolver el mismo mensaje, pero por agilizar la entrega lo dejo así
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Cliente actualizado exitosamente");

        return ResponseEntity.status(HttpStatus.OK).body(response);*/
    }


    @GetMapping("merchantExists/{idMerchant}")
    @ApiOperation(value = "Comprobar si un comercio existe")
    public ResponseEntity<MerchantOutputDTO> merchantExists(
            @ApiParam(value = "ID del comercio a comprobar", required = true)
            @PathVariable String idMerchant) {

        MerchantOutputDTO merchantOutputDTO = clientMappers.modelToMerchantDto(clientGetUseCase.merchantExists(idMerchant));

        if (merchantOutputDTO != null) {
            return ResponseEntity.ok(merchantOutputDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Versión antigua
    /*
    @GetMapping("merchantExists/{idMerchant}")
    @ApiOperation(value = "Comprobar si un comercio existe")
    public MerchantOutputDTO merchantExists(
            @ApiParam(value = "ID del comercio a comprobar", required = true)
            @PathVariable String idMerchant) {
        MerchantOutputDTO merchantOutputDTO = new MerchantOutputDTO();

        if (clientGetUseCase.merchantExists(idMerchant) != null) {
            //merchantOutputDTO.setExists(true);
        }

        return merchantOutputDTO;
    }

    */


    // TODO: (Consejo Dani) Lo suyo sería que la lógica fuera en el servicio para dejar el EP lo más limpio posible
    // hecho
    @PostMapping("generateToken")
    @ApiOperation(value = "Generar un token JWT")
    public String generateToken(
            @ApiParam(value = "Nombre del usuario", required = true)
            @RequestParam String name,
            @ApiParam(value = "Edad del usuario", required = true)
            @RequestParam int age) {

        return tokenService.createToken(name, age);
    }


    @GetMapping("/getClients")
    @ApiOperation(value = "Obtener todos los clientes")
    public List<FullClientOutputDTO> getAllClients() {
        List<ClientGenericModel> res = clientGetUseCase.getAllClients();

        // Transformación a DTO
        List<FullClientOutputDTO> clientOutputDTOList = res.stream()
                .map(clientMappers::modelToFullOutput)
                .collect(Collectors.toList());

        return clientOutputDTOList;
    }

    // TODO: (Consejo Raúl) Cambiar respuesta a JSON
    // TODO: (Consejo Dani) Devolver algo de feedback, ya sea con un booleano o una excepción
    @DeleteMapping("deleteClient/{id}")
    @ApiOperation(value = "Eliminar un cliente")
    //public void deleteClient(
    public GenericResponseEntity<FullClientOutputDTO> deleteClient(
            @ApiParam(value = "ID del cliente a buscar", required = true)
            @PathVariable String id
    ) {

        FullClientOutputDTO deletedClient = clientMappers.modelToFullOutput(clientDeleteUseCase.delete(id));

        return new GenericResponseEntity<>(
                "Cliente borrado con éxito.",
                String.valueOf(HttpStatus.NO_CONTENT.value()),
                deletedClient
        );

    }


    @GetMapping("getMerchantsByClientId/{id}")
    @ApiOperation(value = "Obtener todos los merchants de un cliente")
    public List<MerchantOutputDTO> getMerchantsByClientId(
            @ApiParam(value = "ID del cliente a buscar", required = true)
            @PathVariable String id) {

        List<MerchantGenericModel> res = clientGetUseCase.getMerchantsByClientId(id);
        List<MerchantOutputDTO> resDto = res.stream()
                .map(clientMappers::modelToMerchantDto)
                .collect(Collectors.toList());


        return resDto;

    }


}