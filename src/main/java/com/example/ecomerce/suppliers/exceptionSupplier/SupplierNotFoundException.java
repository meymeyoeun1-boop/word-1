package com.example.ecomerce.suppliers.exceptionSupplier;

public class SupplierNotFoundException extends RuntimeException {

    public SupplierNotFoundException(Long id ){
        super("Product not fount with id: " +id );
    }

}


