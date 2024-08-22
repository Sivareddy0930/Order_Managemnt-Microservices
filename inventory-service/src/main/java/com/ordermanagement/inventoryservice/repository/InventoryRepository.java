package com.ordermanagement.inventoryservice.repository;

import com.ordermanagement.inventoryservice.entity.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory,Long> {
//    Optional<Inventory> findByInventoryId(Long inventoryId);

    Optional<Inventory> findByProductId(Long ProductId);
}
