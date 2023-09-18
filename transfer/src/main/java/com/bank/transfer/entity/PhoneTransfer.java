package com.bank.transfer.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema ="transfer", name ="phone_transfer")
public class PhoneTransfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    Long id;

    @Column(name="phone_number", nullable = false)
    Long phoneNumber;

    @Column(name="amount", nullable = false)
    Double amount;

    @Column(name="purpose")
    String purpose;

    @Column(name="account_details_id", nullable = false)
    Long accountDetailsId;

}
