package com.code4mao.simplezklock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

/**
 * 独占锁（排他锁）测试
 *
 * @author chenzy2
 * @version V1.0
 * @since 2020-01-31 18:50
 */
public class ExclusiveLockTest {
    @Test
    public void lock() throws Exception {
        Runnable runnable = () -> {
            try {
                DistributedLock lock = new ExclusiveLock();
                lock.lock();
                Thread.sleep(2000);
                lock.unlock();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        int poolSize = 4;
        ExecutorService executorService = Executors.newFixedThreadPool(poolSize);
        for (int i = 0; i < poolSize; i++) {
            executorService.submit(runnable);
        }

        executorService.awaitTermination(10, TimeUnit.SECONDS);
    }

    @Test
    public void tryLock() throws Exception {
        ExclusiveLock lock = new ExclusiveLock();
        Boolean locked = lock.tryLock();
        System.out.println("locked: " + locked);
    }

    @Test
    public void tryLock1() throws Exception {
        ExclusiveLock lock = new ExclusiveLock();
        Boolean locked = lock.tryLock(50000);
        System.out.println("locked: " + locked);
    }

    @Test
    public void unlock() throws Exception {
    }
}
