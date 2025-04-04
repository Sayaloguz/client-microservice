package com.sarawipay.client_microservice.Client.infrastructure.controller.DTO;

import com.sarawipay.client_microservice.Client.application.ClientModel;
import com.sarawipay.client_microservice.Client.application.port.ClientAddUseCase;
import com.sarawipay.client_microservice.Client.application.port.ClientGetUseCase;
import com.sarawipay.client_microservice.Client.application.port.ClientUpdateUseCase;
import com.sarawipay.client_microservice.Client.domain.Client;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.input.ClientUpdateRequestDTO;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.output.ClientOutputDTO;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.output.MerchantResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor

public class ClientController {

    private final ClientAddUseCase clientAddUseCase;

    private final ClientGetUseCase clientGetUseCase;

    private final ClientUpdateUseCase clientUpdateUseCase;



    @PostMapping("/create")
    public Client addClient(@RequestBody ClientModel clientModel) {

        //return clientAddUseCase.addClient(clientModel);
        return null;
    }


    @GetMapping("/getByName/{name}")
    public List<ClientOutputDTO> getByName(@PathVariable String name) {

        return clientGetUseCase.getByName(name);

    }


    @GetMapping("/getByEmail/{email}")
    public List<ClientOutputDTO> getByEmail(@PathVariable String email) {

        return clientGetUseCase.getByEmail(email);

    }


    @GetMapping("/getById/{id}")
    public ClientOutputDTO getById(@PathVariable String id) {

        return clientGetUseCase.getById(id);

    }


    @PutMapping("/update")
    public ClientOutputDTO update(@RequestBody ClientUpdateRequestDTO clientUpdate) {

        return clientUpdateUseCase.update(clientUpdate.getClientInputDTO(), clientUpdate.getPk(), clientUpdate.getSk());

    }


    @GetMapping("/check-merchant/{id}")
    public MerchantResponseDTO getMerchant(@PathVariable String id) {

        return clientGetUseCase.getMerchantById(id);

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