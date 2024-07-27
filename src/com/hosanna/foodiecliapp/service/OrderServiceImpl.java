package com.hosanna.foodiecliapp.service;


import com.hosanna.foodiecliapp.exceptions.OrderExistException;
import com.hosanna.foodiecliapp.exceptions.OrderNotFoundException;
import com.hosanna.foodiecliapp.model.Order;
import com.hosanna.foodiecliapp.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

public class OrderServiceImpl implements OrderService{
  private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order save(Order order) throws OrderExistException {
        Optional<Order> orderById = this.orderRepository.findOrderById(order.getId());
        if(orderById.isPresent())
            throw new OrderExistException("Order Already Exists with This Id : " + order.getId());
        return this.orderRepository.save(order);
    }

    @Override
    public List<Order> getOrderList() {
        return this.orderRepository.getOrderList();
    }

    @Override
    public Order getOrderById(String id) throws OrderNotFoundException {
        Optional<Order> orderById = this.orderRepository.findOrderById(id);
        if(orderById.isEmpty())
            throw new OrderNotFoundException("Order Not Found with Id : " + id);
        return orderById.get();
    }

}
