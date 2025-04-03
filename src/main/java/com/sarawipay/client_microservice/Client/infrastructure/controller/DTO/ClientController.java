package com.sarawipay.client_microservice.Client.infrastructure.controller.DTO;

import com.sarawipay.client_microservice.Client.application.port.ClientAddUseCase;
import com.sarawipay.client_microservice.Client.domain.Client;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.input.ClientInputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor

public class ClientController {
    private final ClientAddUseCase clientAddUseCase;

    @PostMapping("/create")
    public Client addClient(@Valid @RequestBody ClientInputDTO clientInputDTO) {
        return clientAddUseCase.addClient(clientInputDTO);
    }
}


// Old stuff
/*
    // Para comprobar que el acceso a la tabla funciona
    @GetMapping("all")
    public List<Client> getAll() {
        return clientService.findAll();
    }

    // Arreglar
    @GetMapping("id/{id}")
    public Client getById(@PathVariable String id) {
        return clientService.findById(id);
    }
*/