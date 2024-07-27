package com.hosanna.foodiecliapp.exceptions;

public class CustomerExistException extends  Exception{
    public CustomerExistException(String message){
        super(message);
    }
}
