package com.hosanna.foodiecliapp.service;

import com.hosanna.foodiecliapp.exceptions.DishExistException;
import com.hosanna.foodiecliapp.exceptions.DishNotFoundException;
import com.hosanna.foodiecliapp.model.Dish;

import java.util.List;

public interface DishService {
    public List<Dish> getDishList();

    public Dish save(Dish dish) throws DishExistException;

    public Dish getDishById(String id) throws DishNotFoundException;

    public Dish update(Dish dish) throws DishNotFoundException;

    public void delete(String id) throws DishNotFoundException;

}
