package com.example.ecomerce.category.Repository;

import com.example.ecomerce.category.entity.Category;
import com.example.ecomerce.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRespository extends JpaRepository<Category,Long> {
    List<Product> id(Long id);
}
