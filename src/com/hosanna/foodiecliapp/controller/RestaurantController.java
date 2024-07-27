package com.hosanna.foodiecliapp.controller;

import com.hosanna.foodiecliapp.exceptions.RestaurantExistsException;
import com.hosanna.foodiecliapp.exceptions.RestaurantNotFoundException;
import com.hosanna.foodiecliapp.model.Restaurant;
import com.hosanna.foodiecliapp.service.RestaurantServiceImpl;

import java.util.List;

public class RestaurantController {

    private final RestaurantServiceImpl restaurantService;

    public RestaurantController(RestaurantServiceImpl restaurantService) {
        this.restaurantService = restaurantService;
    }

    public Restaurant saveRestaurant(Restaurant restaurant) throws RestaurantExistsException, RestaurantNotFoundException {
        return this.restaurantService.save(restaurant);

    }

    public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantNotFoundException{
        return this.restaurantService.updateRestaurant(restaurant);
    }
   public Restaurant getRestaurantById(String id) throws RestaurantNotFoundException{
        return this.restaurantService.getRestaurantById(id);
   }
    public List<Restaurant> getRestaurantList(){
        return this.restaurantService.getRestaurantList();
    }

    public void deleteRestaurant(String id) throws RestaurantNotFoundException{
        this.restaurantService.deleteRestaurant(id);
    }
}
