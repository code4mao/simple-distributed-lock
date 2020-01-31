package com.code4mao.simplezklock;

/**
 * 分布式锁接口定义
 *
 * @author chenzy2
 * @version V1.0
 * @since 2020-01-31 11:50
 */
public interface DistributedLock {
    void lock() throws Exception;

    Boolean tryLock() throws Exception;

    Boolean tryLock(long millisecond) throws Exception;

    void unlock() throws Exception;
}
