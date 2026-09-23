package com.example.ecomerce.product.dto.Request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest{

    @NotNull(message = "name is request")
    @Size(min = 2, max = 2500)
    private String name;

    @NotNull(message = "price is required")
    private Double price;

    @NotNull(message = "stock not null")
    private Integer stock;

    private String description;

}



