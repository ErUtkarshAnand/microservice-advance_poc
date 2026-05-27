package com.utkarshPractise.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import lombok.Data;

@Data
public class ProductDto {

    @NotBlank(message = "Product name is required")
    private String name;

    @Positive(message = "Price must be positive")
    private Double price;

    @Positive(message = "Stock must be positive")
    private Integer stock;
}