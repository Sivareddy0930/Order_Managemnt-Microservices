package com.ordermanagement.inventoryservice.service;

import com.ordermanagement.inventoryservice.dto.InventoryDto;

import java.util.Optional;

public interface InventoryService {
    InventoryDto saveInventory(InventoryDto inventoryDto);

    InventoryDto getByInventoryId(Long inventoryId);

}
