package com.example.ecomerce.product.entity;

import com.example.ecomerce.Share.BaseEntity;
import com.example.ecomerce.category.entity.Category;
import com.example.ecomerce.suppliers.entity.Supplier;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;

    private String description;

    private Integer stock;

    @Column(name = "is_active")
    private Boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
}
