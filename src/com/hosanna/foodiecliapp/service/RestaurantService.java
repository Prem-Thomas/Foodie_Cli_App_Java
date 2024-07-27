package com.hosanna.foodiecliapp.service;

import com.hosanna.foodiecliapp.exceptions.DishNotFoundException;
import com.hosanna.foodiecliapp.exceptions.RestaurantExistsException;
import com.hosanna.foodiecliapp.exceptions.RestaurantNotFoundException;
import com.hosanna.foodiecliapp.model.Dish;
import com.hosanna.foodiecliapp.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    public List<Restaurant> getRestaurantList();

    public Restaurant save(Restaurant restaurant)  throws RestaurantExistsException;
    public Restaurant getRestaurantById(String id) throws RestaurantNotFoundException;
    public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantNotFoundException;
    public void deleteRestaurant(String id) throws RestaurantNotFoundException;
    public List<Dish> getDishItems(String id) throws RestaurantNotFoundException, DishNotFoundException;

}
