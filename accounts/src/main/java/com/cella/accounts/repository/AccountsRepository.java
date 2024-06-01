package com.cella.accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.cella.accounts.entity.Accounts;

import jakarta.transaction.Transactional;

import java.util.Optional;


@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long>{

    Optional<Accounts> findByCustomerId(long customerId);

    @Transactional
    @Modifying
    void deleteByCustomerId(Long customerId);
    
}
