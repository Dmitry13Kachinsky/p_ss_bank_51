package com.bank.transfer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "transfer", name = "card_transfer")
public class CardTransfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Long Id;

    @Column(name = "card_number", unique = true)
    Long cardNumber;

    @Column(name = "amount", nullable = false)
    @Size(min = 2, max = 20)
    Double amount;

    @Column(name = "purpose")
    String purpose;

    @Column(name = "account_details_id", nullable = false)
    Long accountDetailsId;

}
