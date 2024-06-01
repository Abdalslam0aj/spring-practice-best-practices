package com.cella.accounts.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.cella.accounts.constants.AccountsConstants;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ErrorResponse
 */
@Schema(
    name = "ErrorResponse",
    description = "Schema to hold error response information"
)
@Data @AllArgsConstructor
public class ErrorResponseDto {

    @Schema(
        description = "Api path called by client"
    )
    private String apiPath;

    @Schema(
        description = "HTTP Error code",
        example = AccountsConstants.STATUS_500
    )
    private HttpStatus errorCode;

    @Schema(
        description = "System error message",
        example = AccountsConstants.MESSAGE_500
    )
    private String errorMassage;

    @Schema(
        description = "The server time when the error ocurred"
    )
    private LocalDateTime errorTime;
    
}