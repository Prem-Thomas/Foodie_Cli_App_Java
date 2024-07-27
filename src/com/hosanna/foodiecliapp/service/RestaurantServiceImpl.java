package com.hosanna.foodiecliapp.service;

import com.hosanna.foodiecliapp.exceptions.DishNotFoundException;
import com.hosanna.foodiecliapp.exceptions.RestaurantExistsException;
import com.hosanna.foodiecliapp.exceptions.RestaurantNotFoundException;
import com.hosanna.foodiecliapp.model.Dish;
import com.hosanna.foodiecliapp.model.Restaurant;
import com.hosanna.foodiecliapp.repository.RestaurantRepository;

import java.util.List;
import java.util.Optional;

public class RestaurantServiceImpl implements RestaurantService{

   private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }


    @Override
    public List<Restaurant> getRestaurantList() {
        return this.restaurantRepository.getRestaurantList();
    }

    @Override
    public Restaurant save(Restaurant restaurant) throws RestaurantExistsException {
        Optional<Restaurant> restaurantById = this.restaurantRepository.findRestaurantById(restaurant.getId());
        if(restaurantById.isPresent())
            throw new RestaurantExistsException("Restaurant Already Exists with this Id :" +  restaurant.getId());
        return  this.restaurantRepository.save(restaurant);

    }

    @Override
    public Restaurant getRestaurantById(String id) throws RestaurantNotFoundException {
       Optional<Restaurant> restaurantById = this.restaurantRepository.findRestaurantById(id);
       if(restaurantById.isEmpty())
           throw  new RestaurantNotFoundException("Restaurant Not Found with this Id : " + id);
        return restaurantById.get();
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantNotFoundException {
        Optional<Restaurant> restaurantById = this.restaurantRepository.findRestaurantById(restaurant.getId());
        if(restaurantById.isEmpty())
            throw new RestaurantNotFoundException("Restaurant Not Found with this Id :" + restaurant.getId());

        return this.restaurantRepository.updateRestaurant(restaurant);

    }


    @Override
    public void deleteRestaurant(String id) throws RestaurantNotFoundException {

    }

    @Override
    public List<Dish> getDishItems(String id) throws RestaurantNotFoundException, DishNotFoundException {
        return List.of();
    }
}
