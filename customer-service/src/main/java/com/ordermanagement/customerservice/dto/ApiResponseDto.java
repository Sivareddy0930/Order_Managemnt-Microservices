package com.ordermanagement.customerservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseDto {
    private CustomerDto customer;
    private ProductDto product;
    private InventoryDto inventory;
}
