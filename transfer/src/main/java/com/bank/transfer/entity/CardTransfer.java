package com.bank.transfer.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "card_transfer")
public class CardTransfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    @Column(name="id")
    Long Id;

    @Column(name = "card_number")
    Integer cardNumber;

    @Column(name="amount")
    Double amount;

    @Column(name="purpose")
    String purpose;

    @Column(name = "account_details_id")
    Long accDetailsId;

}
