package com.bank.transfer.repository;

import com.bank.transfer.entity.Audit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface AuditRepository extends JpaRepository<Audit, Long> {
    void deleteById (Long id);
}
