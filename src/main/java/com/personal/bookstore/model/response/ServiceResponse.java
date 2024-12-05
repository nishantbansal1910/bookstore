package com.personal.bookstore.model.response;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@JsonView({Views.Public.class})
public class ServiceResponse<T> extends ResponseEntity<T> {
    public ServiceResponse(T data) {
        super(data, HttpStatus.OK);
    }

    public ServiceResponse(T data, HttpStatus status) {
        super(data, status);
    }
}
