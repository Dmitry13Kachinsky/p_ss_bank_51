package com.bank.transfer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "transfer", name = "account_transfer")
public class AccountTransfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Long Id;

    @Column(name = "account_number", unique = true)
    Long accountNumber;

    @Column(name = "amount", nullable = false)
    @Size(min = 2, max = 20)
    Double amount;

    @Column(name = "purpose")
    String purpose;

    @Column(name = "account_details_id", nullable = false)
    Long accountDetailsId;

}
