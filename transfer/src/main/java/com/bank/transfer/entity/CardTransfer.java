package com.bank.transfer.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema ="transfer", name = "card_transfer")
public class CardTransfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    Long Id;

    @Column(name = "card_number", unique = true)
    Long cardNumber;

    @Column(name="amount", nullable = false)
    Double amount;

    @Column(name="purpose")
    String purpose;

    @Column(name = "account_details_id", nullable = false)
    Long accountDetailsId;

}
