package com.chl.demo.rest.server.common.lock.repository;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * 定时任务锁相关信息表
 *
 * Created by caodongdong on 2016/4/9.
 */
@Entity(name = "lockentry")
public class LockEntry
{
    @Id
    private String lockId;

    @Basic
    private int status;

    @Basic
    private long version;

    @Basic
    private int timeOut;

    @Basic
    private String updateTime;

    public String getLockId ()
    {
        return lockId;
    }

    public void setLockId (String lockId)
    {
        this.lockId = lockId;
    }

    public int getStatus ()
    {
        return status;
    }

    public void setStatus (int status)
    {
        this.status = status;
    }

    public long getVersion ()
    {
        return version;
    }

    public void setVersion (long version)
    {
        this.version = version;
    }

    public int getTimeOut ()
    {
        return timeOut;
    }

    public void setTimeOut (int timeOut)
    {
        this.timeOut = timeOut;
    }

    public String getUpdateTime ()
    {
        return updateTime;
    }

    public void setUpdateTime (String updateTime)
    {
        this.updateTime = updateTime;
    }

    @Override public String toString ()
    {
        return "LockEntry{" +
                "lockId='" + lockId + '\'' +
                ", status=" + status +
                ", version=" + version +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
