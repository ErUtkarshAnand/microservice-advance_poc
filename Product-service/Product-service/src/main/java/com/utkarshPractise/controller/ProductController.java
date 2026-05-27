package com.utkarshPractise.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utkarshPractise.dto.ProductDto;
import com.utkarshPractise.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public ProductDto save(@RequestBody @Valid ProductDto dto) {
        return service.save(dto);
    }

    @GetMapping("/{id}")
    public ProductDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public ProductDto update(@PathVariable Long id,
                             @RequestBody ProductDto dto) {

        return service.update(id, dto);
    }

    @GetMapping
    public Page<ProductDto> getAll(
            @PageableDefault(size = 5) Pageable pageable) {

        return service.getAll(pageable);
    }
}