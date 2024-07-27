package com.hosanna.foodiecliapp.exceptions;

public class OrderExistException extends Exception{
    public OrderExistException(String message){
        super(message);
    }
}
