package com.freshGoodies.userstories.exceptions;

public class CartNotFoundException extends RuntimeException{
    public CartNotFoundException(String msg){
        super(msg);
    }
}
