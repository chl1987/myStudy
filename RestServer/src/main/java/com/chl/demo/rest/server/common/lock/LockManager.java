package com.chl.demo.rest.server.common.lock;

import com.chl.demo.rest.server.common.db.SpringTransactionUtils;
import com.chl.demo.rest.server.common.lock.repository.LockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * LockManager
 * Created by caodongdong on 2017-04-01.
 */
public class LockManager {
    /**
     * 日志类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(LockManager.class);

    /**
     * 锁相关数据库操作
     */
    private final LockRepository lockRepository;

    /**
     * 事务管理器
     */
    private final PlatformTransactionManager transactionManager;


    public LockManager(LockRepository lockRepository,
                       PlatformTransactionManager transactionManager) {
        this.lockRepository = lockRepository;
        this.transactionManager = transactionManager;
    }

    /**
     * 尝试获取锁
     *
     * @param lockId 锁ID
     * @return 取到锁则返回true，否则返回false
     */
    public boolean tryToGetLock(String lockId) {

        boolean isGet = this.getLock(lockId);

        //成功取到锁
        if (isGet) {
            return isGet;
        }

        //取不到锁，判断是否锁超时。如果超时则先释放锁，并尝试再一次获取锁。
        if (!isGet) {
            boolean isTimeout = lockRepository.isTimeout(lockId);
            if (isTimeout) {
                //释放锁
                this.releaseLock(lockId);

                //try again
                isGet = this.getLock(lockId);
            }
        }

        return isGet;
    }

    /**
     * 释放锁
     *
     * @param lockId 锁ID
     */
    public void releaseLock(String lockId) {
        TransactionStatus tx = SpringTransactionUtils.startTransaction(transactionManager,
                DefaultTransactionDefinition.PROPAGATION_REQUIRES_NEW);
        try {
            lockRepository.releaseLock(lockId);

            SpringTransactionUtils.commit(transactionManager, tx);

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Success to release the lock:{} ", lockId);
            }
        } catch (RuntimeException ex) {
            LOGGER.error("Try and release lock {} failed! ex = ", lockId, ex);
            SpringTransactionUtils.rollback(transactionManager, tx);
        }
    }

    /**
     * 获取锁
     *
     * @param lockId 锁ID
     * @return 是否成功获取
     */
    private boolean getLock(String lockId) {
        boolean isGet = false;

        LOGGER.info(" ======== 1 ==========!");

        TransactionStatus tx = SpringTransactionUtils.startTransaction(transactionManager,
                DefaultTransactionDefinition.PROPAGATION_REQUIRES_NEW);
        LOGGER.info(" ======== 2 ==========!");


//        try
//        {
//            Thread.sleep(10000);
//        }
//        catch (Exception e)
//        {
//            LOGGER.error("sleep with error!", e);
//        }

        try {
            isGet = lockRepository.tryToGetLock(lockId);


            LOGGER.info(" ======== 3 ==========!{}", isGet);
            try {
                Thread.sleep(10000);
            } catch (Exception e) {
                LOGGER.error("sleep with error!", e);
            }

            SpringTransactionUtils.commit(transactionManager, tx);

            LOGGER.info(" ======== 4 ==========!");
        } catch (RuntimeException ex) {
            LOGGER.error("Try and get lock {} failed! ex = ", lockId, ex);
            SpringTransactionUtils.rollback(transactionManager, tx);
        }

        return isGet;
    }
}
