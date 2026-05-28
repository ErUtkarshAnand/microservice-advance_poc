package com.utkarshPractise.Notification_service.controller;


import org.springframework.web.bind.annotation.*;

@RestController
public class NotificationController {

    @PostMapping("/notify")
    public void notifyUser(
            @RequestParam String message) {

        System.out.println(
                "NOTIFICATION SENT");

        System.out.println(message);
    }
}