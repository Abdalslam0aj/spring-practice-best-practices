package com.cards.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cards.entity.Card;

@Repository
public interface CardRepository extends JpaRepository<Card,Long> {
    
    Optional<Card> findByMobileNumber(String mobileNumber);
}
