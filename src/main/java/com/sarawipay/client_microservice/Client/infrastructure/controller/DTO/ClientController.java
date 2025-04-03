package com.sarawipay.client_microservice.Client.infrastructure.controller.DTO;

import com.sarawipay.client_microservice.Client.application.port.ClientAddUseCase;
import com.sarawipay.client_microservice.Client.application.port.ClientGetUseCase;
import com.sarawipay.client_microservice.Client.domain.Client;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.input.ClientInputDTO;
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

    @PostMapping("/create")
    public Client addClient(@Valid @RequestBody ClientInputDTO clientInputDTO) {
        return clientAddUseCase.addClient(clientInputDTO);
    }

    @GetMapping("/getByName/{name}")
    public List<ClientOutputDTO> getByName(@PathVariable String name) {
        return clientGetUseCase.getByName(name);
    }

}