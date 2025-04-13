package com.cafe.aspect;

import com.cafe.entity.TransactionLog;
import com.cafe.repository.TransactionLogRepository;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Aspect
@Component
public class TransactionAspect {

    @Autowired
    private TransactionLogRepository transactionLogRepository;

    @Around("@annotation(org.springframework.transaction.annotation.Transactional)")
    public Object transactionLogger(ProceedingJoinPoint pjp) throws Throwable{
        String txnId = UUID.randomUUID().toString();
        transactionLogRepository.save(new TransactionLog(txnId, pjp.getSignature().toShortString(), "PENDING", ""));
        Object result = null;
        try{
            result = pjp.proceed();
            transactionLogRepository.save(new TransactionLog(txnId, pjp.getSignature().toShortString(), "SUCCESSFUL", ""));
        }catch(Throwable e){
            transactionLogRepository.save(new TransactionLog(txnId, pjp.getSignature().toShortString(), "ROLLBACK", ""));
        }
        return result;
    }
}
