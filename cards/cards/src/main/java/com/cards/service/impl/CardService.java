package com.cards.service.impl;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.cards.dto.CardDto;
import com.cards.entity.Card;
import com.cards.exception.CardAlreadyExists;
import com.cards.repository.CardRepository;
import com.cards.service.ICardService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CardService implements ICardService {

    private CardRepository cardRepository;

    @Override
    public void createCard(String mobileNumber) {
        var cardExistsEntity = cardRepository.findByMobileNumber(mobileNumber);
        if(cardExistsEntity.isEmpty()) {
            cardRepository.save(buildCard(mobileNumber));      
        } else {
            throw new CardAlreadyExists("Card already exits under mobile number = " + mobileNumber);
        }
    }

    private Card buildCard(String mobileNumber) {
        Card card = new Card();
        Long cardId = 100000000000L + new Random().nextInt(900000000);        
        card.setCardNumber(Long.toString(cardId));
        card.setAmountUsed(0);
        card.setAvailableAmount(0);
        card.setTotalLimit(10000);
        card.setCardType("2");
        card.setMobileNumber(mobileNumber);
        return card;
    }

    @Override
    public CardDto fetchCard(String mobileNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCard'");
    }

    @Override
    public boolean updateCard(CardDto cardDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCard'");
    }

    @Override
    public boolean deleteCard(String mobileNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCard'");
    }
    
}
