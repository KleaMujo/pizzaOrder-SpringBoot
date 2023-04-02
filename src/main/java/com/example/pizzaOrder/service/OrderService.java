package com.example.pizzaOrder.service;

import com.example.pizzaOrder.model.Order;
import com.example.pizzaOrder.repository.OrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    } //const

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }

    public List<Order> findAllOrder() {
        return orderRepository.findAll();
    }

    public Optional<Order> findOrderById(Integer id) { //optional-mund t jet ose ms t jet
        return orderRepository.findById(id);
    }

    /*
    In Spring, the PATCH HTTP method is used to partially update a resource.
    When a resource is updated with a PATCH request,
    only the specified fields in the request body are updated, leaving the other fields unchanged.
    If a client wants to update only the total field of a user, they can send a PATCH request
    to the service with a request body containing the total field and its new value.
     */
    public Order patchOrder(Integer id, Order order) {
        Order respons = orderRepository.findById(id).orElse(null);
        if (respons != null) {
            if (order.getTotal() != 0) respons.setTotal(order.getTotal());
        }
        return respons;
    }


    public Order updatedOrder(Integer id, Order updatedOrder) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found!"));
        order.setDateCreated(updatedOrder.getDateCreated());
        order.setItems(updatedOrder.getItems());
        order.setTotal(updatedOrder.getTotal());
        orderRepository.save(order);
        return order;
    }
}
