package com.sarawipay.client_microservice.Client.infrastructure.controller;

import com.sarawipay.client_microservice.Client.application.ClientGenericModel;
import com.sarawipay.client_microservice.Client.application.port.ClientAddUseCase;
import com.sarawipay.client_microservice.Client.application.port.ClientGetUseCase;
import com.sarawipay.client_microservice.Client.application.port.ClientUpdateUseCase;
import com.sarawipay.client_microservice.Client.domain.mappers.ClientMappers;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.input.ClientInputDTO;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.input.ClientUpdateRequestDTO;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.output.ClientOutputDTO;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.output.ClientIdDTO;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.output.FullClientOutputDTO;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.output.MerchantOutputDTO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
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
    private final ClientMappers clientMappers;

    private static final String SECRET_KEY = "aFk7Tfz2dIceNqUyKQL++BUyKwaw4WEqBMX9Rj3djks=";


    @PostMapping("/create")
    @ApiOperation(value = "Crear un nuevo cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Cliente creado exitosamente", response = Map.class),
    })

    public ResponseEntity<Map<String, Object>> addClient(
            @ApiParam(value = "Datos del cliente a crear", required = true)
            @Valid @RequestBody ClientInputDTO clientInputDTO) {

        ClientGenericModel generic = clientMappers.inputToModel(clientInputDTO);

        clientAddUseCase.addClient(generic);

        // Tal como está siempre va a devolver el mismo mensaje, pero por agilizar la entrega lo dejo así
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Cliente creado exitosamente");

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @GetMapping("/getByName/{name}")
    @ApiOperation(value = "Buscar clientes por nombre")
    public List<ClientOutputDTO> getByName(
            @ApiParam(value = "Nombre del cliente a buscar", required = true)
            @PathVariable String name) {

        List<ClientGenericModel> res = clientGetUseCase.getByName(name);

        List<ClientOutputDTO> clientOutputDTOList = res.stream()
                .map(clientMappers::modelToOutput)
                .collect(Collectors.toList());

        return clientOutputDTOList;

    }


    @GetMapping("getByEmail/{email}")
    @ApiOperation(value = "Buscar clientes por email")
    public List<ClientOutputDTO> getByEmail(
            @ApiParam(value = "Email del cliente a buscar", required = true)
            @PathVariable String email) {

        List<ClientGenericModel> res = clientGetUseCase.getByEmail(email);

        // Transformación a DTO
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
    public ResponseEntity<Map<String, Object>> update(
            @ApiParam(value = "Datos del cliente a actualizar", required = true)
            @RequestBody ClientUpdateRequestDTO clientUpdate) {

        ClientGenericModel generic = clientMappers.updateToModel(clientUpdate);
        clientUpdateUseCase.update(generic);

        // Tal como está siempre va a devolver el mismo mensaje, pero por agilizar la entrega lo dejo así
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Cliente actualizado exitosamente");

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("merchantExists/{idMerchant}")
    @ApiOperation(value = "Comprobar si un comercio existe")
    public MerchantOutputDTO merchantExists(
            @ApiParam(value = "ID del comercio a comprobar", required = true)
            @PathVariable String idMerchant) {
        MerchantOutputDTO merchantOutputDTO = new MerchantOutputDTO();

        if (clientGetUseCase.merchantExists(idMerchant) != null) {
            merchantOutputDTO.setExists(true);
        }

        return merchantOutputDTO;
    }


    @PostMapping("generateToken")
    @ApiOperation(value = "Generar un token JWT")
    public String generateToken(
            @ApiParam(value = "Nombre del usuario", required = true)
            @RequestParam String name,
            @ApiParam(value = "Edad del usuario", required = true)
            @RequestParam int age) {

        Map<String, Object> claims = new HashMap<>();
        claims.put("name", name);
        claims.put("age", age);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();

    }

    @GetMapping("/getClients")
    @ApiOperation(value = "Obtener todos los clientes")
    public List<ClientOutputDTO> getAllClients() {
        List<ClientGenericModel> res = clientGetUseCase.getAllClients();

        // Transformación a DTO
        List<ClientOutputDTO> clientOutputDTOList = res.stream()
                .map(clientMappers::modelToOutput)
                .collect(Collectors.toList());

        return clientOutputDTOList;
    }

}