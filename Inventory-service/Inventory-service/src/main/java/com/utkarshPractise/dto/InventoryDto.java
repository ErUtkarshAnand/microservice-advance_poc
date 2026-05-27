package com.utkarshPractise.dto;

import javax.validation.constraints.PositiveOrZero;

import com.sun.istack.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
public class InventoryDto {

    @NotNull
    private Long productId;

    @PositiveOrZero
    private Integer stock;
}