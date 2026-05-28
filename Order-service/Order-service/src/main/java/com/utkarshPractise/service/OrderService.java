package com.utkarshPractise.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utkarshPractise.dto.OrderRequest;
import com.utkarshPractise.entity.Order;
import com.utkarshPractise.external.InventoryClient;
import com.utkarshPractise.external.NotificationClient;
import com.utkarshPractise.external.PaymentClient;
import com.utkarshPractise.repository.OrderRepository;
 
@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private InventoryClient inventoryClient;

    @Autowired
    private PaymentClient paymentClient;

    @Autowired
    private NotificationClient notificationClient;

    public String placeOrder(OrderRequest request) {

        // STEP 1 : Reduce Inventory
        String inventoryResponse =
                inventoryClient.reduceStock(
                        request.getProductId(),
                        request.getQuantity());

        // STEP 2 : Payment
        String paymentResponse =
                paymentClient.doPayment(
                        request.getAmount());

        // STEP 3 : Save Order
        Order order = new Order();

        order.setProductId(request.getProductId());
        order.setQuantity(request.getQuantity());
        order.setAmount(request.getAmount());
        order.setStatus("PLACED");

        Order savedOrder = repository.save(order);

        // STEP 4 : Notification
        notificationClient.sendNotification(
                "Order Placed Successfully. Order Id : "
                        + savedOrder.getId());

        return "ORDER SUCCESS";
    }
}