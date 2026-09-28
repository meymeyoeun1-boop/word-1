package com.example.ecomerce.category.entity;

import com.example.ecomerce.Share.BaseEntity;
import com.example.ecomerce.product.entity.Product;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name="categories")
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Category extends BaseEntity {

    @Column(nullable = false)
    private String name;

    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products;

}
