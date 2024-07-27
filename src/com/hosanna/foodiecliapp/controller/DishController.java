package com.hosanna.foodiecliapp.controller;

import com.hosanna.foodiecliapp.exceptions.DishExistException;
import com.hosanna.foodiecliapp.exceptions.DishNotFoundException;
import com.hosanna.foodiecliapp.model.Dish;
import com.hosanna.foodiecliapp.service.DishServiceImpl;

import java.util.List;

public class DishController {

    private DishServiceImpl dishService;

    public DishController(DishServiceImpl dishService) {
        this.dishService = dishService;
    }
  public Dish save(Dish dish) throws  DishExistException {
        return this.dishService.save(dish);

  }

  public Dish update(Dish dish) throws DishNotFoundException {
        return this.dishService.update(dish);
  }

  public Dish getDishById(String id) throws DishNotFoundException {
        return this.dishService.getDishById(id);
  }
  public List<Dish> getDishList() {
        return this.dishService.getDishList();
    }
  public void deleteDish(String id) throws DishNotFoundException {
        this.dishService.delete(id);
  }
       
}
