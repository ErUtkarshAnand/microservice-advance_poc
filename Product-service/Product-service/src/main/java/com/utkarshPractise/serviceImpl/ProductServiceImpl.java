package com.utkarshPractise.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.utkarshPractise.dto.ProductDto;
import com.utkarshPractise.entity.Product;
import com.utkarshPractise.repository.ProductRepository;
import com.utkarshPractise.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public ProductDto save(ProductDto dto) {

        log.info("Saving product: {}", dto.getName());
        log.error("Saving product: {}", dto.getName());

        Product product = new Product();

        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());

        Product saved = repository.save(product);

        ProductDto response = new ProductDto();

        response.setName(saved.getName());
        response.setPrice(saved.getPrice());
        response.setStock(saved.getStock());

        return response;
    }

    @Override
    public ProductDto getById(Long id) {

        Product product = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));

        ProductDto dto = new ProductDto();

        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setStock(product.getStock());

        return dto;
    }

    @Override
    public ProductDto update(Long id, ProductDto dto) {

        Product product = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));

        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());

        Product updated = repository.save(product);

        dto.setName(updated.getName());
        dto.setPrice(updated.getPrice());
        dto.setStock(updated.getStock());

        return dto;
    }

    @Override
    public Page<ProductDto> getAll(Pageable pageable) {

        return repository.findAll(pageable)
                .map(product -> {

                    ProductDto dto = new ProductDto();

                    dto.setName(product.getName());
                    dto.setPrice(product.getPrice());
                    dto.setStock(product.getStock());

                    return dto;
                });
    }
}