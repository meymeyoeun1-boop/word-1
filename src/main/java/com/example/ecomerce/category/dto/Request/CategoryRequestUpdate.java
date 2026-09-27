package com.example.ecomerce.category.dto.Request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequestUpdate {

    @NotNull(message = "name is request")
    @Size(min = 2, max = 2500)
    private String name;

    private String description;
}
