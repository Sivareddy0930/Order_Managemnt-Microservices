package com.ordermanagement.customerservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private Long customerId;
    @Column(unique = true,nullable = false)
    private String customerName;
    @Column(unique = true,nullable = false)
    private String customerEmail;
    @Column(unique = true,nullable = false)
    private String customerContact;
    @Column(unique = true,nullable = false)
    private Long productId;
}
