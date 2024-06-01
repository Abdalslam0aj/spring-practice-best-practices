package com.cella.accounts.dto;

import com.cella.accounts.constants.AccountsConstants;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(
    name = "Resposne",
    description = "Simple response to return the request "
)
@Data @AllArgsConstructor
public class ResponseDto {

    @Schema(
        description = "Returns HTTP status code",
        example = "200"
    )
    private String statusCode;

    @Schema(
        description = "Returns the status message",
        example = AccountsConstants.MESSAGE_200
    )
    private String statusMassage;
    
}
