package com.cella.accounts.dto;

import com.cella.accounts.constants.ValidationMessages;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * AccountsDto
 */
@Schema(
    name = "Accounts",
    description = "Schema to hold Customer Accounts"
)
@Data
public class AccountsDto {

    @Schema(description = "account number of the customer")
    @NotEmpty(message = ValidationMessages.NOT_EMPTY)
    @Pattern(regexp="(^$|[0-9]{10})",message = "AccountNumber must be 10 digits")
    private Long accountNumber;

    @Schema(description = "account type of the account", example = "Savings")
    @NotEmpty(message = ValidationMessages.NOT_EMPTY)
    private String accountType;

    @Schema(description = "Address of the account branch", example = "Amman 22 st alrahsed")
    @NotEmpty(message = ValidationMessages.NOT_EMPTY)
    private String branchAddress;
    
}