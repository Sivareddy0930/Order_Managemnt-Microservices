package com.ordermanagement.inventoryservice.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    private Long inventoryId;
    private Long stockLevel;
    private Boolean availability;
    private Long productId;
}
