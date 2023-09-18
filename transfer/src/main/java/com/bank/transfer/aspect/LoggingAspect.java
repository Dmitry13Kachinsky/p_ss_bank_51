package com.bank.transfer.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.bank.transfer.service.AccountTransferServiceImpl.*(..))")
    private void accountTransferMethods(){}

    @Pointcut("execution(* com.bank.transfer.service.CardTransferServiceImpl.*(..))")
    private void cardTransferMethods() {}

    @Pointcut("execution(* com.bank.transfer.service.PhoneTransferServiceImpl.*(..))")
    private void phoneTransferMethods() {}

    @Pointcut("execution(* com.bank.transfer.service.AuditServiceImpl.*(..))")
    private void auditMethods() {}



    @Before("accountTransferMethods()")
    public void beforeAccountTransfersMethodsLoggingAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Logging before method: \"" + methodSignature.getMethod() + "\", name of the executing method is: \"" +
                methodSignature.getName() + "\" .");

    }

    @After("accountTransferMethods()")
    public void afterAccountTransfersMethodsLoggingAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Logging after method: \"" + methodSignature.getMethod() + "\", name of the executing method is: \"" +
                methodSignature.getName() + "\" .");
    }

    @Before("cardTransferMethods()")
    public void beforeCardTransfersMethodsLoggingAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Logging before method: \"" + methodSignature.getMethod() + "\", name of the executing method is: \"" +
                methodSignature.getName() + "\" .");
    }

    @After("cardTransferMethods()")
    public void afterCardTransfersMethodsLoggingAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Logging after method: \"" + methodSignature.getMethod() + "\", name of the executing method is: \"" +
                methodSignature.getName() + "\" .");
    }

    @Before("phoneTransferMethods()")
    public void beforePhoneTransfersMethodsLoggingAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Logging before method: \"" + methodSignature.getMethod() + "\", name of the executing method is: \"" +
                methodSignature.getName() + "\" .");
    }

    @After("phoneTransferMethods()")
    public void afterPhoneTransfersMethodsLoggingAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Logging after method: \"" + methodSignature.getMethod() + "\", name of the executing method is: \"" +
                methodSignature.getName() + "\" .");
    }

    @Before("auditMethods()")
    public void beforeAuditMethodsLoggingAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Logging before method: \"" + methodSignature.getMethod() + "\", name of the executing method is: \"" +
                methodSignature.getName() + "\" .");
    }

    @After("auditMethods()")
    public void afterAuditMethodsLoggingAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Logging after method: \"" + methodSignature.getMethod() + "\", name of the executing method is: \"" +
                methodSignature.getName() + "\" .");
    }


}
