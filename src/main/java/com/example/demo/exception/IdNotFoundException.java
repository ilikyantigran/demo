package com.example.demo.exception;

public class IdNotFoundException extends Exception{
    public IdNotFoundException (String errorMessage){
        super(errorMessage);
    }
}
