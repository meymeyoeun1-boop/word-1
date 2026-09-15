package com.example.product2.Repository;

import com.example.product2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface ProductRepository extends JpaRepository<Product,Long> {
}
