package com.example.ecomerce.suppliers.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;



@Entity
@Table(name ="suppliers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Supplier {

    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    private String contact_person;

    private String email;

    private Integer phone;

    @Column(name = "is_active")
    private Boolean isActive;

    private String category;

}

