package com.example.ecomerce.category.exceptionCategory;

public class CategoryNotFoundException extends RuntimeException{

    public CategoryNotFoundException(Long id ){
        super("Category not fount with id: " +id );
    }

}

