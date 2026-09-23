package com.example.ecomerce.product.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HttpBodyResponse<T> {

    private int status;
    private String message;
    private T data;

    public static <T> HttpBodyResponse <T> succeed(T data) {
        return HttpBodyResponse.<T>builder()
                .status(200)
                .message("Success")
                .data(data)
                .build();

    }
    public static <T> HttpBodyResponse<T> created(T data){
        return HttpBodyResponse.<T>builder()
                .status(201)
                .message("Created Successfully")
                .data(data)
                .build();
    }
}
