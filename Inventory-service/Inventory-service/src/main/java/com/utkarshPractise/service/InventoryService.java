package com.utkarshPractise.service;

import com.utkarshPractise.dto.InventoryDto;

public interface InventoryService {

    InventoryDto addStock(InventoryDto dto);

    void reduceStock(Long productId, Integer qty);

    boolean isAvailable(Long productId, Integer qty);

    InventoryDto getInventory(Long productId);
}