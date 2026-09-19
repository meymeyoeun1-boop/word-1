package com.example.product2.dto.Response;

import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@Builder
public class ProductResponse {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private LocalDateTime createdAt;

}
