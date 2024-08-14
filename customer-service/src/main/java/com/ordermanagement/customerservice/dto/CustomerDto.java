package com.ordermanagement.customerservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private Long id;
    private Long customerId;
    private String customerName;
    private String customerEmail;
    private String customerContact;
}
