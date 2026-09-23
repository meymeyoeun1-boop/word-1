package com.example.ecomerce.product.common;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class BaseRestController {

    protected <T>ResponseEntity<HttpBodyResponse<T>> responseSucceed(T data){
        return ResponseEntity.ok(HttpBodyResponse.succeed(data));
    }

    protected <T> ResponseEntity<HttpBodyResponse<T>> responseCreated(T data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(HttpBodyResponse.created(data));
    }

    protected ResponseEntity<HttpBodyResponse<Void>> responseDeleted(){
        return ResponseEntity.ok(HttpBodyResponse.<Void>builder()
                .status(200)
                .message("Deleted Successfully")
                .build());
    }

}
