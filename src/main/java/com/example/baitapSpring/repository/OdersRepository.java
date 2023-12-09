package com.example.baitapSpring.repository;

import com.example.baitapSpring.entity.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OdersRepository extends JpaRepository<OrdersEntity,Integer> {
    List<OrdersEntity> findByCustomerId(int customerId);
}
