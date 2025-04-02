package com.sarawipay.client_microservice.Client.infrastructure.controller.DTO;

import com.sarawipay.client_microservice.Client.application.port.ClientAddUseCase;
import com.sarawipay.client_microservice.Client.domain.Client;
import com.sarawipay.client_microservice.Client.domain.mappers.ClientMappers;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.input.ClientInputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/api")

// Hace falta constructor aquí?
@RequiredArgsConstructor

public class ClientController {
    private final ClientAddUseCase clientAddUseCase;


    @PostMapping("/create")
    public Client addClient(@RequestBody ClientInputDTO clientInputDTO) {
        return clientAddUseCase.addClient(clientInputDTO);
    }
}


// Old stuff

/*
package com.sarawipay.practica.controller;

import com.sarawipay.practica.model.Client;
import com.sarawipay.practica.service.ClientService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@Getter
@Setter
public class ClientController {

    private ClientService clientService;

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
}
*/