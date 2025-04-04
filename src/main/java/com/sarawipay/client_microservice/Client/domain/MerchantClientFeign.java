package com.sarawipay.client_microservice.Client.domain;

import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.output.MerchantResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "merchant-service", url = "http://localhost:8082")
public interface MerchantClientFeign {

    @GetMapping("/merchants/{id}")
    MerchantResponseDTO findById(@PathVariable("id") String id);

}

