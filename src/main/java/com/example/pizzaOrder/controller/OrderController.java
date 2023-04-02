package com.example.pizzaOrder.controller;

import com.example.pizzaOrder.model.Order;
import com.example.pizzaOrder.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    private OrderService orderService;
    public OrderController( OrderService orderService){
        this.orderService=orderService;  //cons
    }

    @PostMapping("/po_order")
    public ResponseEntity<Void> createOrder(@RequestBody Order order){ //@RequestBody annotation can be used
        // to automatically map the incoming request body to a Java object
        orderService.saveOrder(order);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/po_order")
    public  ResponseEntity<List<Order>> findAllOrder(){

       return new ResponseEntity<>( orderService.findAllOrder(),HttpStatus.OK);

    }



/*
    //nqs duam te nxjerr nje spring kur e bejme ne google localhost:8080/order
    @GetMapping("/po_order")
    public  ResponseEntity<String> findAllOrder(){


        return new ResponseEntity<>( "order controller success",HttpStatus.OK);
    }


 */
    @GetMapping("/")
    public  ResponseEntity<String> index(){

        return new ResponseEntity<>( "welcome",HttpStatus.OK);
    }

    @DeleteMapping("/po_order/{id}")
       public ResponseEntity<Void> deleteOrder(@PathVariable Integer id){
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); //NO_CONTENT ngaqe eshte void?
    }
    @PutMapping("/po_order/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Integer id, @RequestBody Order updatedOrder) {
        return ResponseEntity.ok(orderService.updatedOrder(id,updatedOrder));
    }
    @GetMapping("/po_order/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Integer id) {
        Optional<Order> optionalOrder = orderService.findOrderById(id);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
