package com.cards.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cards.dto.ResponseDto;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE} )
public class CardsController {
    
    @PostMapping()
    public ResponseEntity<ResponseDto> createCard() {

        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(null, 0));
        
    }
}
