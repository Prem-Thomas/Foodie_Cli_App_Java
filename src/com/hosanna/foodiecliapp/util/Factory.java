package com.hosanna.foodiecliapp.util;

import com.hosanna.foodiecliapp.controller.CustomerController;
import com.hosanna.foodiecliapp.controller.DishController;
import com.hosanna.foodiecliapp.controller.OrderController;
import com.hosanna.foodiecliapp.controller.RestaurantController;
import com.hosanna.foodiecliapp.repository.CustomerRepository;
import com.hosanna.foodiecliapp.repository.DishRepository;
import com.hosanna.foodiecliapp.repository.OrderRepository;
import com.hosanna.foodiecliapp.repository.RestaurantRepository;
import com.hosanna.foodiecliapp.service.CustomerServiceImpl;
import com.hosanna.foodiecliapp.service.DishServiceImpl;
import com.hosanna.foodiecliapp.service.OrderServiceImpl;
import com.hosanna.foodiecliapp.service.RestaurantServiceImpl;

public class Factory {

    public static CSVReader getCsvReader(){return new CSVReader();
    }

/*
      Cusromer Related Factory Methods
 */

    public static CustomerRepository getCustomerRepository() {
        return new CustomerRepository();
    }

    public static CustomerServiceImpl getCustomerService() {
        return new CustomerServiceImpl(getCustomerRepository());
    }

    public static CustomerController getCustomerController() {
        return new CustomerController(getCustomerService());
    }
/*
      Dish Related Factory Methods
 */
    public static DishRepository getDishRepository(){return new DishRepository();
    }

    public static DishServiceImpl getDishService(){return new DishServiceImpl(getDishRepository());
    }

    public static DishController getDishController(){return new DishController(getDishService());
    }
/*
       Restaurant Related Factory Methods
 */
    public static RestaurantRepository getRestaurantReposity(){
        return new RestaurantRepository();
    }

    public static RestaurantServiceImpl getRestaurantService(){
        return new RestaurantServiceImpl(getRestaurantReposity());
    }

    public static RestaurantController getRestaurantController(){
        return new RestaurantController(getRestaurantService());
    }
/*
      Order Related Factory Methods
 */
    public static OrderRepository getOrderRepository(){
        return new OrderRepository();
    }

    public static OrderServiceImpl getOrderService(){
        return new OrderServiceImpl(getOrderRepository());
    }

    public static OrderController getOrderController(){
        return new OrderController(getOrderService());
    }


}