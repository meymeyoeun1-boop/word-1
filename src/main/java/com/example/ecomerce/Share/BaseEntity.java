package com.example.ecomerce.Share;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;

@Getter // We only need getters. IDs and Dates should never be changed manually!
@MappedSuperclass // Tells JPA: "Copy my fields to any class that extends me"
@EntityListeners(AuditingEntityListener.class) // Turns on the auto-date magic
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(updatable = false) // Cannot be changed after creation
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
