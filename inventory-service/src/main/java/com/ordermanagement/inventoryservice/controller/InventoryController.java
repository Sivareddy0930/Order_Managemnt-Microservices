package com.ordermanagement.inventoryservice.controller;

import com.ordermanagement.inventoryservice.dto.InventoryDto;
import com.ordermanagement.inventoryservice.service.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@AllArgsConstructor
public class InventoryController {

    private InventoryService inventoryService;

    @PostMapping("/createInventory")
    public ResponseEntity<InventoryDto> saveInventory(@RequestBody InventoryDto inventoryDto){
        InventoryDto savedInventoryDto = inventoryService.saveInventory(inventoryDto);
        return new ResponseEntity<>(savedInventoryDto, HttpStatus.CREATED);

    }

    @GetMapping("/getInventory/{id}")
    public ResponseEntity<InventoryDto> getInventory(@PathVariable("id") Long productId){
        InventoryDto inventoryDto = inventoryService.getByProductId(productId);
        return new ResponseEntity<>(inventoryDto, HttpStatus.OK);
    }
}
