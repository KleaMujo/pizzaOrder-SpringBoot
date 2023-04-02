
package com.example.pizzaOrder.service;
import com.example.pizzaOrder.model.Order;
import com.example.pizzaOrder.model.OrderItem;
import com.example.pizzaOrder.repository.OrderItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MenuService {
    private OrderItemRepository orderItemRepository;


//Shfaqja e menuse me emer dhe cmim
    public Map<String,String> showMenu(){
        List<OrderItem> orderItems= orderItemRepository.findAll();
        Map<String,String> response=new HashMap<>();
        orderItems.stream()
                .forEach(orderItem -> response.put(orderItem.getProductName(),String.valueOf(orderItem.getProductPrice())));
        return response;
    }

}