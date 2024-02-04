package com.cella_store_api.accounts.dto;

import com.cella_store_api.accounts.constants.ValidationMessages;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * CustomerDto
 */
@Data
@Schema(name = "Customer", description = "Schema to hold customer and account information")
public class CustomerDto {

    @Schema(description = "Name of the account holder", example = "Abdulsalam Al-jamal")
    @NotEmpty(message = ValidationMessages.NOT_EMPTY)
    @Size(min = 3, max = 30, message = "Name value length should be in 3 to 30 in length")
    private String name;

    @Schema(description = "Email of the account holder", example = "example@domain.com")
    @NotEmpty(message = ValidationMessages.NOT_EMPTY)
    @Email(message = "Email address should be a valid value")
    private String email;

    @Schema(description = "Mobile number of the account holder", example = "078XXXXXXX")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @Schema(description = "Accounts details of the customer")
    private AccountsDto accountsDto;

}