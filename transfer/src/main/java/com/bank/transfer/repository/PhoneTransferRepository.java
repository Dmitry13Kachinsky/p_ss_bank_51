package com.bank.transfer.repository;

import com.bank.transfer.entity.PhoneTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface PhoneTransferRepository extends JpaRepository<PhoneTransfer, Long> {
    void deleteById(Long id);
}
