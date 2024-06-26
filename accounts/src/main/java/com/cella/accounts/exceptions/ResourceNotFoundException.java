package com.cella.accounts.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resourceName,String fieldName, String fieldValue) {
        super(String.format("%s cant be satisfied as the resource is not available %s = %s", resourceName, fieldName, fieldValue));
    }

    
}
