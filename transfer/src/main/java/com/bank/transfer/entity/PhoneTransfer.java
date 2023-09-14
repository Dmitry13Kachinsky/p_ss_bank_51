package com.bank.transfer.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "phone_transfer")
public class PhoneTransfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    @Column(name="id")
    Long id;

    @Column(name="phone_number")
    Long phoneNumber;

    @Column(name="amount")
    Double amount;

    @Column(name="purpose")
    String purpose;

    @Column(name="account_details_id")
    Long accDetailsId;

}
