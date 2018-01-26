package der.java8.thread;

import java.util.Random;
import java.util.concurrent.*;

/**
* @FileName:SynchronizersDemo
* @Description:
* @Author: Derrick Ye
*/
public class SynchronizersDemo {
    /**
     * CountDownLatch is used to delay the progress of threads
     */
    public static void doLatches(){
        CountDownLatch cdLatch = new CountDownLatch(5);
        Runnable th = () -> {
            try {
                Thread.sleep(2000);
                System.out.println("Thread in " + Thread.currentThread().getName() + " initialized.");
                cdLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        new Thread(th).start();
        new Thread(th).start();
        new Thread(th).start();
        new Thread(th).start();
        new Thread(th).start();
        try {
            cdLatch.await(2, TimeUnit.SECONDS);
            System.out.println("All threads up and running!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * FutureTask is used to compute long running tasks
     */
    public static void doFutureTask(){
        Callable<Integer> task = () -> {
            int i = 0;
            for (; i < 10; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + "_"
                            + i);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return i;
        };

        FutureTask<Integer> futuretask = new FutureTask<Integer>(task) {

            @Override
            protected void done() {
                try {
                    System.out.println("future.done():" + get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        };


        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(futuretask);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        try {
            System.out.println("Value is " +futuretask.get());
        } catch (InterruptedException | ExecutionException  e) {
            e.printStackTrace();
        }
    }

    /**
     * Semaphore controls the number of activities that can access a resource
     */
    public static void doSemaphore(){
        Semaphore semaphore = new Semaphore(5);

        Runnable runnable = () -> {
            try {
                System.out.println("Trying to acquire - " + Thread.currentThread().getName());
                if (semaphore.tryAcquire(2, TimeUnit.SECONDS)) {
                    System.out.println("Acquired - " + Thread.currentThread().getName());
                    Thread.sleep(2000);
                    System.out.println("Done - " + Thread.currentThread().getName());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        };
        for (int i = 0; i < 6; i++) {
            new Thread(runnable).start();
        }
    }
}
