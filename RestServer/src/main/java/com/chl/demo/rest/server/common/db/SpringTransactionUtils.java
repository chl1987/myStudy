package com.chl.demo.rest.server.common.db;

/**
 * Created by caodong on 2017-04-01.
 */
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class SpringTransactionUtils {
    private static final int DEFAULT_TRANSACTION_TIMEOUT = 60;

    public SpringTransactionUtils() {
    }

    public static TransactionStatus startTransaction(PlatformTransactionManager transactionManager, DefaultTransactionDefinition transactionDefinition) {
        TransactionStatus tx = transactionManager.getTransaction(transactionDefinition);
        return tx;
    }

    public static TransactionStatus startTransaction(PlatformTransactionManager transactionManager, int propagationBehavior) {
        DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        transactionDefinition.setPropagationBehavior(propagationBehavior);
        transactionDefinition.setTimeout(60);
        TransactionStatus tx = transactionManager.getTransaction(transactionDefinition);
        return tx;
    }

    public static void commit(PlatformTransactionManager transactionManager, TransactionStatus tx) {
        if(tx.isNewTransaction() && !tx.isCompleted()) {
            transactionManager.commit(tx);
        }

    }

    public static void rollback(PlatformTransactionManager transactionManager, TransactionStatus tx) {
        if(tx.isNewTransaction() && !tx.isCompleted()) {
            transactionManager.rollback(tx);
        }

    }
}
