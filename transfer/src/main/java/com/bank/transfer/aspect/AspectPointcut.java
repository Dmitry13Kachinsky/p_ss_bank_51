package com.bank.transfer.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class AspectPointcut {

    @Pointcut("execution(* com.bank.transfer.service.AccountTransferServiceImpl.*(..))")
    public void accountTransferMethods(){}
    @Pointcut("execution(* com.bank.transfer.service.CardTransferServiceImpl.*(..))")
    public void cardTransferMethods() {}
    @Pointcut("execution(* com.bank.transfer.service.PhoneTransferServiceImpl.*(..))")
    public void phoneTransferMethods() {}
    @Pointcut("execution(* com.bank.transfer.service.AuditServiceImpl.*(..))")
    public void auditMethods() {}

}
