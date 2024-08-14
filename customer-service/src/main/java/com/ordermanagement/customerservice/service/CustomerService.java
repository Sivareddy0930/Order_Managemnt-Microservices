package com.ordermanagement.customerservice.service;

import com.ordermanagement.customerservice.dto.ApiResponseDto;
import com.ordermanagement.customerservice.dto.CustomerDto;

public interface CustomerService {
    CustomerDto createCustomer(CustomerDto customerDto);

    ApiResponseDto getCustomerById(Long customerId);
}
