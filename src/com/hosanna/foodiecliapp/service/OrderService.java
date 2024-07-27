package com.hosanna.foodiecliapp.service;

import com.hosanna.foodiecliapp.exceptions.OrderExistException;
import com.hosanna.foodiecliapp.exceptions.OrderNotFoundException;
import com.hosanna.foodiecliapp.model.Order;

import java.util.List;

public interface OrderService {
    public List<Order> getOrderList();
    public Order getOrderById(String id) throws OrderNotFoundException;
    public Order save(Order order) throws OrderExistException;
}
