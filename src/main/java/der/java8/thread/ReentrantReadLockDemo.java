package der.java8.thread;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
* @FileName:ReentrantReadLockDemo
* @Description: ReentrantReadWriterLock gives reentrant capabilities do ReadWriteLock
* @Author: Derrick Ye
*/
public class ReentrantReadLockDemo extends Thread{

    private ReentrantReadWriteLock rrwLock;

    public ReentrantReadLockDemo(String name, ReentrantReadWriteLock rrwLock) {
        super(name);
        this.rrwLock = rrwLock;
    }

    /**
     * Read access is granted if there's no Writer or a Writer requesting access
     */
    public void run() {
        System.out.println(Thread.currentThread().getName() + " trying to lock");
        try {
            rrwLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " lock successfully");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rrwLock.readLock().unlock();
            System.out.println(Thread.currentThread().getName() + " unlock successfully");
        }
    }

}
