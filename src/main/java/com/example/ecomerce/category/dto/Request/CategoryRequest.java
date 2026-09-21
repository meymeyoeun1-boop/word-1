package com.example.ecomerce.category.dto.Request;

import lombok.Builder;

@Builder

public record CategoryRequest(String name,String description) {
}
