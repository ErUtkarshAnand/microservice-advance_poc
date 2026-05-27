package com.utkarshPractise.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utkarshPractise.dto.InventoryDto;
import com.utkarshPractise.entity.Inventory;
import com.utkarshPractise.repository.InventoryRepository;
import com.utkarshPractise.service.InventoryService;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class InventoryServiceImpl
        implements InventoryService {

    @Autowired
    private InventoryRepository repository;

    @Override
    public InventoryDto addStock(InventoryDto dto) {

        Inventory inventory = new Inventory();

        inventory.setProductId(dto.getProductId());
        inventory.setStock(dto.getStock());

        Inventory saved = repository.save(inventory);

        dto.setProductId(saved.getProductId());
        dto.setStock(saved.getStock());

        return dto;
    }

    @Override
    public void reduceStock(Long productId, Integer qty) {

        log.info("Reducing stock for product: {}",
                productId);

        Inventory inventory =
                repository.findByIdForUpdate(productId);

        if (inventory == null) {
            throw new RuntimeException(
                    "Product not found in inventory");
        }

        if (inventory.getStock() < qty) {

            throw new RuntimeException(
                    "Out of stock");
        }

        inventory.setStock(
                inventory.getStock() - qty);

        repository.save(inventory);

        log.info("Stock reduced successfully");
    }

    @Override
    public boolean isAvailable(Long productId,
                               Integer qty) {

        Inventory inventory =
                repository.findById(productId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Product not found"));

        return inventory.getStock() >= qty;
    }

    @Override
    public InventoryDto getInventory(Long productId) {

        Inventory inventory =
                repository.findById(productId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Inventory not found"));

        InventoryDto dto = new InventoryDto();

        dto.setProductId(inventory.getProductId());
        dto.setStock(inventory.getStock());

        return dto;
    }
}