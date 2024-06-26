package com.cards.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class CardDto {

	private String mobileNumber;

	private String cardNumber;

	private String cardType;

	private int totalLimit;

	private int amountUsed;

	private int availableAmount;
    
}
