package com.utkarshPractise.repository;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.utkarshPractise.entity.Inventory;

@Repository
public interface InventoryRepository
        extends JpaRepository<Inventory, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)

    @Query("select i from Inventory i where i.productId=:id")
    Inventory findByIdForUpdate(@Param("id") Long id);
}