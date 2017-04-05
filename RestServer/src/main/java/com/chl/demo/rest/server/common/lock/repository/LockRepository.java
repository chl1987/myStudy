package com.chl.demo.rest.server.common.lock.repository;

/**
 * Created by caodongdong on 2016/4/9.
 */
public interface LockRepository {
    /**
     * 尝试获取锁
     *
     * @param lockId 锁ID
     * @return 取到锁则返回true，否则返回false
     */
    boolean tryToGetLock(String lockId);

    /**
     * 释放锁
     *
     * @param lockId 锁ID
     */
    void releaseLock(String lockId);

    /**
     * 是否超时
     *
     * @param lockId 锁ID
     * @return 超时则为true，否则为false
     */
    boolean isTimeout(String lockId);
}
