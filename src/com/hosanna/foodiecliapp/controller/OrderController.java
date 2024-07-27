package com.hosanna.foodiecliapp.controller;

import com.hosanna.foodiecliapp.exceptions.OrderExistException;
import com.hosanna.foodiecliapp.exceptions.OrderNotFoundException;
import com.hosanna.foodiecliapp.model.Order;
import com.hosanna.foodiecliapp.service.OrderServiceImpl;

import java.util.List;

public class OrderController {
    private OrderServiceImpl orderService;

    public OrderController (OrderServiceImpl orderService){
        this.orderService = orderService;
    }

    public List<Order> getOrdersList(){
        return this.orderService.getOrderList();
    }

    public Order getOrderById(String id) throws OrderNotFoundException{
        return this.orderService.getOrderById(id);
    }

    public Order  saveOrder(Order order) throws OrderExistException{
        return this.orderService.save(order);
    }

}
