package com.example.ecomerce.product.exception;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(Long id ){
        super("Product not fount with id: " +id );
    }
}
