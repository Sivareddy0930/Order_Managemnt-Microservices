package com.ordermanagement.customerservice.service;


import com.ordermanagement.customerservice.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:9090",value = "product-service")
public interface APIClient {

    @GetMapping("/api/products/getProductById/{PID}")
    ProductDto getProductByProductId(@PathVariable("PID") Long productId);
}
