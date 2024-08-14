package com.ordermanagement.customerservice.controller;

import com.ordermanagement.customerservice.dto.ApiResponseDto;
import com.ordermanagement.customerservice.dto.CustomerDto;
import com.ordermanagement.customerservice.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;

    @PostMapping("/createCustomer")
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto){
        CustomerDto savedCustomer = customerService.createCustomer(customerDto);
        return new ResponseEntity<>(customerDto, HttpStatus.CREATED);
    }

    @GetMapping("/getCustomerById/{customerId}")
    public ResponseEntity<ApiResponseDto> getCustomerById(@PathVariable Long customerId){
        ApiResponseDto apiResponseDto = customerService.getCustomerById(customerId);

        return ResponseEntity.ok(apiResponseDto);
    }

}
