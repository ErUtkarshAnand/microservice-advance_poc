package com.utkarshPractise.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.utkarshPractise.dto.InventoryDto;
import com.utkarshPractise.service.InventoryService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService service;

    @PostMapping
    public InventoryDto addStock(
            @RequestBody @Valid InventoryDto dto) {

        return service.addStock(dto);
    }

    @PutMapping("/reduce")
    public String reduceStock(
            @RequestParam Long productId,
            @RequestParam Integer qty) {

        service.reduceStock(productId, qty);

        return "Stock reduced successfully";
    }

    @GetMapping("/available")
    public boolean isAvailable(
            @RequestParam Long productId,
            @RequestParam Integer qty) {

        return service.isAvailable(productId, qty);
    }

    @GetMapping("/{productId}")
    public InventoryDto getInventory(
            @PathVariable Long productId) {

        return service.getInventory(productId);
    }
}