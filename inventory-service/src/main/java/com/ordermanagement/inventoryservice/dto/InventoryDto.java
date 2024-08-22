package com.ordermanagement.inventoryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryDto {
    private Long inventoryId;
    private Long stockLevel;
    private Boolean availability;
    private Long productId;
}
