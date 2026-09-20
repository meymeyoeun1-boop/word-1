package com.example.category.dto.Request;

import lombok.Builder;

@Builder
public record CategoryRequest(String name,String description) {
}
