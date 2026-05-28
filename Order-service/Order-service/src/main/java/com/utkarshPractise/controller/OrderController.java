package com.utkarshPractise.controller;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utkarshPractise.dto.OrderRequest;
import com.utkarshPractise.service.OrderService;

 
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping
    public String placeOrder(
            @RequestBody OrderRequest request) {

        return service.placeOrder(request);
    }
}