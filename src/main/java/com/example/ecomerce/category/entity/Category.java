package com.example.ecomerce.category.entity;

import com.example.ecomerce.Share.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

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

}
