package com.utkarshPractise.Payment_service.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @PostMapping("/pay")
    public String doPayment(
            @RequestParam Double amount) {

        System.out.println(
                "PAYMENT RECEIVED : " + amount);

        return "PAYMENT SUCCESS";
    }
}