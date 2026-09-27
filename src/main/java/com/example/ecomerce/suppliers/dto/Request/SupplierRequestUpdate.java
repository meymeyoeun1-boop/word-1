package com.example.ecomerce.suppliers.dto.Request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SupplierRequestUpdate {
    @NotNull(message = "name is request")
    @Size(min = 2, max = 2500)
    private String name;

    @NotNull(message = "contact_person is required")
    private String contact_person ;

    @NotNull(message = "email not null")
    private String email;

    private Integer phone;
}
