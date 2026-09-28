package com.example.ecomerce.suppliers.entity;

import com.example.ecomerce.product.entity.Product;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name ="suppliers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String contact_person;

    private String email;

    private Integer phone;

    @Column(name = "is_active")
    private Boolean isActive;

    private String category;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products;

}

