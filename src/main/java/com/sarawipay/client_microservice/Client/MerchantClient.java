package com.sarawipay.client_microservice.Client;

import com.sarawipay.client_microservice.Client.application.MerchantGenericModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "merchant-microservice", url = "${sarawipay.merchant.url}")
public interface MerchantClient {

    //MerchantGenericModel getById(String id);
    @GetMapping("/api/getById/{id}")
    MerchantGenericModel getById(@PathVariable("id") String id);

}
