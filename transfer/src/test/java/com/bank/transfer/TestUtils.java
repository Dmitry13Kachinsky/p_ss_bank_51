package com.bank.transfer;

import com.bank.transfer.dto.AccountTransferDto;
import com.bank.transfer.dto.AuditDto;
import com.bank.transfer.dto.CardTransferDto;
import com.bank.transfer.dto.PhoneTransferDto;
import com.bank.transfer.entity.AccountTransfer;
import com.bank.transfer.entity.Audit;
import com.bank.transfer.entity.CardTransfer;
import com.bank.transfer.entity.PhoneTransfer;
import com.bank.transfer.mapper.AccountTransferMapper;
import com.bank.transfer.mapper.AuditTransferMapper;
import com.bank.transfer.mapper.CardTransferMapper;
import com.bank.transfer.mapper.PhoneTransferMapper;

import java.sql.Timestamp;
import java.util.List;

public class TestUtils {

    public static AccountTransfer getAccountTransferWithoutId_1() {
        return AccountTransfer.builder()
                .accountNumber(1L)
                .amount(1.1)
                .purpose("aaa")
                .accountDetailsId(11L)
                .build();
    }

    public static AccountTransfer getAccountTransferWithoutId_2() {
        return AccountTransfer.builder()
                .accountNumber(2L)
                .amount(2.2)
                .purpose("bbb")
                .accountDetailsId(22L)
                .build();
    }

    public static AccountTransfer getAccountTransfer_1() {
        AccountTransfer transfer = getAccountTransferWithoutId_1();
        transfer.setId(1L);
        return transfer;
    }

    public static AccountTransfer getAccountTransfer_2() {
        AccountTransfer transfer = getAccountTransferWithoutId_2();
        transfer.setId(2L);
        return transfer;
    }

    public static AccountTransferDto getAccountTransferDto_1() {

        return AccountTransferMapper.INSTANCE.mapToAccountTransferDto(getAccountTransfer_1());
    }

    public static AccountTransferDto getAccountTransferDto_2() {
        return AccountTransferMapper.INSTANCE.mapToAccountTransferDto(getAccountTransfer_2());
    }

    public static List<AccountTransfer> getListOfAccountTransfers() {
        return List.of(getAccountTransfer_1(), getAccountTransfer_2());
    }

    public static List<AccountTransferDto> getListOfAccountTransfersDto() {
        return List.of(getAccountTransferDto_1(), getAccountTransferDto_2());
    }

    public static Audit getTransferAuditWithoutId_1() {
        return Audit.builder()
                .entityType("testEntity")
                .operationType("testOperation")
                .createdBy("testCreator")
                .modifiedBy("testModifier")
                .createdAt(new Timestamp(1L))
                .modifiedAt(new Timestamp(1L))
                .newEntityJson("testNewEntityJson")
                .entityJson("testEntityJson")
                .build();
    }

    public static Audit getTransferAuditWithoutId_2() {
        return Audit.builder()
                .entityType("testEntity2")
                .operationType("testOperation2")
                .createdBy("testCreator2")
                .modifiedBy("testModifier2")
                .createdAt(new Timestamp(2L))
                .modifiedAt(new Timestamp(2L))
                .newEntityJson("testNewEntityJson2")
                .entityJson("testEntityJson2")
                .build();
    }

    public static Audit getTransferAudit_1() {
        Audit audit = getTransferAuditWithoutId_1();
        audit.setId(1L);
        return audit;
    }

    public static Audit getTransferAudit_2() {
        Audit audit = getTransferAuditWithoutId_2();
        audit.setId(2L);
        return audit;
    }

    public static AuditDto getTransferAuditDto_1() {

        return AuditTransferMapper.INSTANCE.mapToAuditDto(getTransferAudit_1());
    }

    public static AuditDto getTransferAuditDto_2() {
        return AuditTransferMapper.INSTANCE.mapToAuditDto(getTransferAudit_2());
    }

    public static List<Audit> getListOfTransfersAudit() {
        return List.of(getTransferAudit_1(), getTransferAudit_2());
    }

    public static List<AuditDto> getListOfTransfersAuditDto() {
        return List.of(getTransferAuditDto_1(), getTransferAuditDto_2());
    }

    public static CardTransfer getCardTransferWithoutId_1() {
        return CardTransfer.builder()
                .cardNumber(1L)
                .amount(1.1)
                .purpose("aaa")
                .accountDetailsId(11L)
                .build();
    }

    public static CardTransfer getCardTransferWithoutId_2() {
        return CardTransfer.builder()
                .cardNumber(2L)
                .amount(2.2)
                .purpose("bbb")
                .accountDetailsId(22L)
                .build();
    }

    public static CardTransfer getCardTransfer_1() {
        CardTransfer transfer = getCardTransferWithoutId_1();
        transfer.setId(1L);
        return transfer;
    }

    public static CardTransfer getCardTransfer_2() {
        CardTransfer transfer = getCardTransferWithoutId_2();
        transfer.setId(2L);
        return transfer;
    }

    public static CardTransferDto getCardTransferDto_1() {

        return CardTransferMapper.INSTANCE.mapToCardTransferDto(getCardTransfer_1());
    }

    public static CardTransferDto getCardTransferDto_2() {
        return CardTransferMapper.INSTANCE.mapToCardTransferDto(getCardTransfer_2());
    }

    public static List<CardTransfer> getListOfCardTransfers() {
        return List.of(getCardTransfer_1(), getCardTransfer_2());
    }

    public static List<CardTransferDto> getListOfCardTransfersDto() {
        return List.of(getCardTransferDto_1(), getCardTransferDto_2());
    }


    public static PhoneTransfer getPhoneTransferWithoutId_1() {
        return PhoneTransfer.builder()
                .phoneNumber(1L)
                .amount(1.1)
                .purpose("aaa")
                .accountDetailsId(11L)
                .build();
    }

    public static PhoneTransfer getPhoneTransferWithoutId_2() {
        return PhoneTransfer.builder()
                .phoneNumber(2L)
                .amount(2.2)
                .purpose("bbb")
                .accountDetailsId(22L)
                .build();
    }

    public static PhoneTransfer getPhoneTransfer_1() {
        PhoneTransfer transfer = getPhoneTransferWithoutId_1();
        transfer.setId(1L);
        return transfer;
    }

    public static PhoneTransfer getPhoneTransfer_2() {
        PhoneTransfer transfer = getPhoneTransferWithoutId_2();
        transfer.setId(2L);
        return transfer;
    }

    public static PhoneTransferDto getPhoneTransferDto_1() {

        return PhoneTransferMapper.INSTANCE.mapToPhoneTransferDto(getPhoneTransfer_1());
    }

    public static PhoneTransferDto getPhoneTransferDto_2() {
        return PhoneTransferMapper.INSTANCE.mapToPhoneTransferDto(getPhoneTransfer_2());
    }

    public static List<PhoneTransfer> getListOfPhoneTransfers() {
        return List.of(getPhoneTransfer_1(), getPhoneTransfer_2());
    }

    public static List<PhoneTransferDto> getListOfPhoneTransfersDto() {
        return List.of(getPhoneTransferDto_1(), getPhoneTransferDto_2());
    }
}

