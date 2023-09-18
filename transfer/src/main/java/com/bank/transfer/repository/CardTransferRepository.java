package com.bank.transfer.repository;

import com.bank.transfer.entity.CardTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface CardTransferRepository extends JpaRepository<CardTransfer, Long> {
    void deleteById(Long id);
}
