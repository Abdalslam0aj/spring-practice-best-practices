
package com.cards.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ErrorResponseDto
 */
@Data @AllArgsConstructor
public class ErrorResponseDto {

    private String apiPath;

    private String errorMessage;

    private HttpStatus errorCode;

    private LocalDateTime errorTime;
    
}