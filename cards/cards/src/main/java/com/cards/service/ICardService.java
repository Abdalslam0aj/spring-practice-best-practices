package com.cards.service;

import com.cards.dto.CardDto;
import com.cards.repository.CardRepository;

public interface ICardService {

    void createCard(String mobileNumber);

    CardDto fetchCard(String mobileNumber);

    boolean updateCard(CardDto cardDto);

    boolean deleteCard(String mobileNumber);
    
}
