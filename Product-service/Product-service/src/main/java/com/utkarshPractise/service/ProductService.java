package com.utkarshPractise.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.utkarshPractise.dto.ProductDto;

public interface ProductService {

    ProductDto save(ProductDto dto);

    ProductDto update(Long id, ProductDto dto);

    ProductDto getById(Long id);

    Page<ProductDto> getAll(Pageable pageable);
}