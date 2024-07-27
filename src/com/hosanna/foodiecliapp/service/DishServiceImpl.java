package com.hosanna.foodiecliapp.service;

import com.hosanna.foodiecliapp.exceptions.CustomerExistException;
import com.hosanna.foodiecliapp.exceptions.CustomerNotFoundException;
import com.hosanna.foodiecliapp.exceptions.DishExistException;
import com.hosanna.foodiecliapp.exceptions.DishNotFoundException;
import com.hosanna.foodiecliapp.model.Customer;
import com.hosanna.foodiecliapp.model.Dish;
import com.hosanna.foodiecliapp.repository.DishRepository;

import java.util.List;
import java.util.Optional;

public class DishServiceImpl implements DishService {

    private DishRepository dishRepository;

    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public List<Dish> getDishList() {
        return this.dishRepository.getDishList();
    }

    @Override
    public Dish save(Dish dish) throws DishExistException {
        Optional<Dish> customerById = this.dishRepository.getDishById(dish.getId());
        if (customerById.isPresent()) {
            throw new DishExistException("Dish already exists with this id :" + dish.getId());
        }
        return this.dishRepository.saveDish(dish);
    }

    @Override
    public Dish getDishById(String id) throws DishNotFoundException {
        Optional<Dish> dishById = this.dishRepository.getDishById(id);
        if (!dishById.isPresent()) {
            throw new DishNotFoundException("Dish not Found with id : " + id);
        }
        return dishById.get();
    }

    @Override
    public Dish update(Dish dish) throws DishNotFoundException {
       Optional<Dish> dishById = this.dishRepository.getDishById(dish.getId());
       if(dishById.isEmpty())
           throw new DishNotFoundException("Dish Not Found with This Id : " + dish.getId());
       return  this.dishRepository.updateDish(dish);
    }

    @Override
    public void delete(String id) throws DishNotFoundException {
        Optional<Dish> dishById = this.dishRepository.getDishById(id);
        if(dishById.isEmpty())
            throw new DishNotFoundException("Dish Not Found with Id " + id);
        this.dishRepository.deleteDish(dishById.get());

    }
}

