package com.example.pizzaOrder.repository;

import com.example.pizzaOrder.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
        //marim metodat e repositoryt
        }
