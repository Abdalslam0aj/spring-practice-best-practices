package com.cards.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CardDoesNotExists extends RuntimeException {

    CardDoesNotExists(String message) {
        super(message);
    }
    
}
