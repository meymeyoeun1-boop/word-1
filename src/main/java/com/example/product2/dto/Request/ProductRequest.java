package com.example.product2.dto.Request;

import lombok.Builder;

@Builder
public record ProductRequest(String name, Double price,String description) {

}



