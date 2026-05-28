package com.utkarshPractise.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.utkarshPractise.entity.Order;


public interface OrderRepository extends JpaRepository<Order, Long> {

}