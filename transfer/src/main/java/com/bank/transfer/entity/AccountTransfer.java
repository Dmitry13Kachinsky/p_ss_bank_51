package com.bank.transfer.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema ="transfer", name = "account_transfer")
public class AccountTransfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    Long Id;


    @Column(name = "account_number", unique = true)
    Long accountNumber;

    @Column(name="amount", nullable = false)
    Double amount;

    @Column(name="purpose")
    String purpose;

    @Column(name = "account_details_id", nullable = false)
    Long accountDetailsId;

}
