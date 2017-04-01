package com.chl.demo.rest.server.common.lock.repository.jpa;

import com.chl.demo.rest.server.common.lock.LockManager;
import com.huawei.csb.axon.common.utils.DateUtil;
import com.huawei.csb.axon.lock.LockStatus;
import com.chl.demo.rest.server.common.lock.repository.LockEntry;
import org.axonframework.common.jpa.EntityManagerProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * lock管理器数据库操作实现
 *
 * Created by caodongdong on 2016/4/9.
 */
public class JpaLockRepository implements com.chl.demo.rest.server.common.lock.repository.LockRepository
{

    private static final Logger LOGGER = LoggerFactory.getLogger(LockManager.class);

    private final EntityManagerProvider entityManagerProvider;

    @PersistenceContext
    private EntityManager entityManager;

    public JpaLockRepository (EntityManagerProvider entityManagerProvider)
    {
        this.entityManagerProvider = entityManagerProvider;
    }

    /**
     * 尝试获取锁
     * @param lockId
     *      锁ID
     * @return
     *      取到锁则返回true，否则返回false
     */
    @Override public boolean tryToGetLock (String lockId)
    {
        LockEntry lockEntry = this.getLockEntry(lockId);

        LOGGER.info(" ======== 5 ==========!{}");
        try
        {
            Thread.sleep(2000);
        }
        catch (Exception e)
        {
            LOGGER.error("sleep with error!", e);
        }

        if (lockEntry == null || lockEntry.getStatus() == LockStatus.LOCKED)
        {
            return false;
        }


        LOGGER.info(" ======== 6 ==========!{}");

        long newVersion = lockEntry.getVersion() + 1;

        String updateTime = DateUtil.getInstance().getCurrentUTC();

        String sql = "UPDATE com.chl.demo.rest.server.common.lock.repository.LockEntry l SET l.updateTime = :updateTime, l.status = :status, l.version = :newVersion WHERE l.lockId = :lockId and l.version = :version";

        int updateCount = entityManager.createQuery(sql)
                .setParameter("updateTime", updateTime)
                .setParameter("status", LockStatus.LOCKED)
                .setParameter("newVersion", newVersion)
                .setParameter("lockId", lockId)
                .setParameter("version", lockEntry.getVersion()).executeUpdate();

        LOGGER.info("============updateCount = {}", updateCount);

//        if (LockManager.COUNT_OF_CUT_OVER_THREAD.get() >= 1)
//        {
//            throw new RuntimeException("roll back!");
//        }
        try
        {
            Thread.sleep(2000);
        }
        catch (Exception e)
        {
            LOGGER.error("sleep with error!", e);
        }

        /**
         * 乐观锁，更新成功说明获取锁成功
         */
        if (updateCount > 0)
        {
            return true;
        }

        return false;
    }

    /**
     * 释放锁

     * @param lockId
     *      锁ID
     */
    @Override public void releaseLock (String
            lockId)
    {

        String updateTime = DateUtil.getInstance().getCurrentUTC();

        String sql = "UPDATE com.chl.demo.rest.server.common.lock.repository.LockEntry l SET l.status = :status, l.updateTime = :updateTime WHERE l.lockId = :lockId";

        entityManager.createQuery(sql)
                .setParameter("status", LockStatus.UN_LOCK)
                .setParameter("updateTime", updateTime)
                .setParameter("lockId", lockId)
                .executeUpdate();
    }

    /**
     * 是否超时
     * @param lockId
     *      锁ID
     * @return
     *      超时则为true，否则为false
     */
    @Override public boolean isTimeout (String lockId)
    {
        LockEntry lockEntry = this.getLockEntry(lockId);

        if (lockEntry == null)
        {
            return false;
        }

        long timeOut = lockEntry.getTimeOut();

        String time = DateUtil.getInstance().getMinsAgoUTC(timeOut);

        String lastUpdateTime = lockEntry.getUpdateTime();

        /**
         * 超时
         */
        if (time.compareTo(lastUpdateTime) > 0)
        {
            return true;
        }

        return false;
    }

    /**
     * 获取lock信息
     * @param lockId
     *        锁ID
     * @return
     *        锁信息
     */
    private LockEntry getLockEntry (String lockId)
    {
        entityManager.getEntityManagerFactory().getCache().evictAll();

        return entityManager.find(LockEntry.class, lockId);
    }
}
