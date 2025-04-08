package com.sarawipay.client_microservice.Client.infrastructure.controller.DTO;

import com.sarawipay.client_microservice.Client.application.ClientGenericModel;
import com.sarawipay.client_microservice.Client.application.port.ClientAddUseCase;
import com.sarawipay.client_microservice.Client.application.port.ClientGetUseCase;
import com.sarawipay.client_microservice.Client.application.port.ClientUpdateUseCase;
import com.sarawipay.client_microservice.Client.domain.mappers.ClientMappers;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.input.ClientInputDTO;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.input.ClientUpdateRequestDTO;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.output.ClientOutputDTO;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.output.FullClientOutputDTO;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.output.MerchantOutputDTO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    public void addClient(@Valid @RequestBody ClientInputDTO clientInputDTO) {

        ClientGenericModel generic = clientMappers.inputToModel(clientInputDTO);

        clientAddUseCase.addClient(generic);
    }


    @GetMapping("/getByName/{name}")
    public List<ClientOutputDTO> getByName(@PathVariable String name) {

        List<ClientGenericModel> res = clientGetUseCase.getByName(name);

        // Transformación a DTO
        List<ClientOutputDTO> clientOutputDTOList = res.stream()
                .map(clientMappers::modelToOutput)
                .collect(Collectors.toList());

        return clientOutputDTOList;

    }


    @GetMapping("getByEmail/{email}")
    public List<ClientOutputDTO> getByEmail(@PathVariable String email) {

        List<ClientGenericModel> res = clientGetUseCase.getByEmail(email);

        // Transformación a DTO
        List<ClientOutputDTO> clientOutputDTOList = res.stream()
                .map(clientMappers::modelToOutput)
                .collect(Collectors.toList());

        return clientOutputDTOList;
    }


    @GetMapping("getById/{id}")
    public FullClientOutputDTO getById(@PathVariable String id) {

        return clientMappers.modelToFullOutput(clientGetUseCase.getById(id));

    }


    @GetMapping("getById/{id}/{simpleOutput}")
    public ClientOutputDTO.ClientIdDTO getByIdSimple(@PathVariable String id, @PathVariable String simpleOutput) {

        if (simpleOutput.equalsIgnoreCase("simpleOutput")) {
            return clientMappers.modelToIdDTO(clientGetUseCase.getById(id));
        } else {
            throw new IllegalArgumentException("Valor inválido para simpleOutput");
        }

    }


    @PutMapping("update")
    public void update(@RequestBody ClientUpdateRequestDTO clientUpdate) {

        ClientGenericModel generic = clientMappers.updateToModel(clientUpdate);
        clientUpdateUseCase.update(generic);

    }

    @GetMapping("merchantExists/{idMerchant}")
    public MerchantOutputDTO merchantExists(@PathVariable String idMerchant) {
        MerchantOutputDTO merchantOutputDTO = new MerchantOutputDTO();

        if(clientGetUseCase.merchantExists(idMerchant) != null){
            merchantOutputDTO.setExists(true);
        }

        return merchantOutputDTO;
    }

    @PostMapping("generateToken")
    public String generateToken(@RequestParam String name, @RequestParam int age) {

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
}