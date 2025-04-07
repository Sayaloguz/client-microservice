package com.sarawipay.client_microservice.Client.infrastructure.controller.DTO;

import com.sarawipay.client_microservice.Client.application.ClientGenericModel;
import com.sarawipay.client_microservice.Client.application.port.ClientAddUseCase;
import com.sarawipay.client_microservice.Client.application.port.ClientGetUseCase;
import com.sarawipay.client_microservice.Client.application.port.ClientUpdateUseCase;
import com.sarawipay.client_microservice.Client.domain.Client;
import com.sarawipay.client_microservice.Client.domain.mappers.ClientMappers;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.input.ClientInputDTO;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.input.ClientUpdateRequestDTO;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.output.ClientOutputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor

public class ClientController {
    private final ClientAddUseCase clientAddUseCase;
    private final ClientGetUseCase clientGetUseCase;
    private final ClientUpdateUseCase clientUpdateUseCase;
    private final ClientMappers clientMappers;

    @PostMapping("/create")
    public void addClient(@Valid @RequestBody ClientInputDTO clientInputDTO) {
        ClientGenericModel generic = clientMappers.inputToModel(clientInputDTO);

        clientAddUseCase.addClient(generic);
    }

    @GetMapping("/getByName/{name}")
    public List<ClientOutputDTO> getByName(@PathVariable String name) {
        return clientGetUseCase.getByName(name);
    }

    @GetMapping("getByEmail/{email}")
    public List<ClientOutputDTO> getByEmail(@PathVariable String email) {
        return clientGetUseCase.getByEmail(email);
    }

    @GetMapping("getById/{id}")
    public ClientOutputDTO getById(@PathVariable String id) {
        return clientGetUseCase.getById(id);
    }

    @PutMapping("update")
    public ClientOutputDTO update(@RequestBody ClientUpdateRequestDTO clientUpdate) {
        return clientUpdateUseCase.update(clientUpdate.getClientInputDTO(), clientUpdate.getPk(), clientUpdate.getSk());
    }


    /*
    {
        "clientInputDTO": {
            "cifNifNie": "12345678A",
            "name": "MARCAS",
            "surname": "DÍAZ",
            "phone": "699000111",
            "email": "marcos.diaz@mail.com"
        },
        "pk": "client#d3a2265f-bf29-4034-8968-ece34bbe5ad0",
        "sk": "document#66666666U"
    }
     */

}