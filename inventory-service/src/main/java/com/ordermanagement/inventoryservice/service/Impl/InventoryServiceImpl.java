package com.ordermanagement.inventoryservice.service.Impl;

import com.ordermanagement.inventoryservice.dto.InventoryDto;
import com.ordermanagement.inventoryservice.entity.Inventory;
import com.ordermanagement.inventoryservice.repository.InventoryRepository;
import com.ordermanagement.inventoryservice.service.InventoryService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private InventoryRepository inventoryRepository;

    private ModelMapper modelMapper;


    @Override
    public InventoryDto saveInventory(InventoryDto inventoryDto) {
        Inventory inventory = modelMapper.map(inventoryDto, Inventory.class);
        Inventory savedInventory = inventoryRepository.save(inventory);
        InventoryDto savedInventoryDto = modelMapper.map(savedInventory, InventoryDto.class);
        return savedInventoryDto;
    }

    @Override
    public InventoryDto getByProductId(Long productId) {
        Optional<Inventory> optionalInventory = inventoryRepository.findByProductId(productId);
        Inventory inventory = optionalInventory.get();
        InventoryDto inventoryDto = modelMapper.map(inventory, InventoryDto.class);
        return inventoryDto;
    }


}
