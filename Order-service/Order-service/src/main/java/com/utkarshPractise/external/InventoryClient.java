package com.utkarshPractise.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "INVENTORY-SERVICE")
public interface InventoryClient {

    @PostMapping("/inventory/reduce")
    String reduceStock(
            @RequestParam("productId") Long productId,
            @RequestParam("qty") Integer qty);
}

