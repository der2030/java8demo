package der.java8.thread;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
* @FileName:ReentrantWriteLockDemo
* @Description: ReentrantReadWriterLock gives reentrant capabilities do ReadWriteLock
* @Author: Derrick Ye
*/
public class ReentrantWriteLockDemo extends Thread {

    private ReentrantReadWriteLock rrwLock;

    public ReentrantWriteLockDemo (String name, ReentrantReadWriteLock rrwLock) {
        super(name);
        this.rrwLock = rrwLock;
    }

    /**
     * Write access is granted if there's no Reader
     */
    public void run() {
        System.out.println(Thread.currentThread().getName() + " trying to lock");
        try {
            rrwLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + " lock successfully");
        } finally {
            rrwLock.writeLock().unlock();
            System.out.println(Thread.currentThread().getName() + " unlock successfully");
        }
    }
}
