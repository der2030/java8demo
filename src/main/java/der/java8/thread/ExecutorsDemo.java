package der.java8.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.*;

/**
* @FileName:ExecutorsDemo
* @Description: There are 4 types of executors: Single Thread Executor, Fix Thread Pool ,
 *                Cached Thread Pool and Scheduled Thread Pool
* @Author: Derrick Ye
*/
public class ExecutorsDemo {
    /**
     * Single Thread Executor uses a single worker to process task
     * @param seconds
     */
    public static void doSingleThreadExecutor(long seconds){

        ExecutorService singleThreadExecutor= Executors.newSingleThreadExecutor();
        singleThreadExecutor.submit(()->{
            try {
                TimeUnit.SECONDS.sleep(seconds);
                String name = Thread.currentThread().getName();
                System.out.println("task finished: " + name);
            }
            catch (InterruptedException e) {
                System.err.println("task interrupted");
            }
        });

        stop(singleThreadExecutor);

    }

    /**
     * Fixed Thread Pool is bounded thread limit  which maintains the same thread pool size
     */
    public static void doFixedThreadPool(){

        ExecutorService fixedThreadPool=Executors.newFixedThreadPool(4);
        List<Future<UUID>> uuids=new LinkedList<>();
        for(int i=0;i<30;i++){
            Future<UUID> submitUuid=fixedThreadPool.submit(()->{
                UUID uuid=UUID.randomUUID();
                System.out.println("uuid:"+uuid+" from "+Thread.currentThread().getName());
                 return uuid;
            });
            uuids.add(submitUuid);
        }
        fixedThreadPool.execute(()->uuids.forEach((uuidFuture) -> {
                System.out.println("uuidFuture:"+uuidFuture+" from "+Thread.currentThread().getName());
        }));

        stop(fixedThreadPool);
    }

    /**
     * Cached Executor Pool is unbound thread limit which is good performance for long running task
     */
    public static void doCacheExecutorPool(){
        ExecutorService cacheExePool=Executors.newCachedThreadPool();
        List<Future<UUID>> uuids=new LinkedList<>();
        for(int i=0;i<30;i++){
            Future<UUID> submitUUID=cacheExePool.submit(()->{
                UUID uuid=UUID.randomUUID();
                System.out.println("uuid:"+uuid+" from "+Thread.currentThread().getName());
                return uuid;
            });
            uuids.add(submitUUID);
        }
        cacheExePool.execute(()->uuids.forEach((uuidFuture )->{
            System.out.println("uuidFuture:"+uuidFuture+" from "+Thread.currentThread().getName());
        }));
        stop(cacheExePool);
    }

    /**
     * Schedule Thread Pool is bouned thread limit which is used for delay task
     * @throws InterruptedException
     */
    public static void doScheduledThreadPool()throws InterruptedException{
        //ExecutorService scheduledPool= Executors.newScheduledThreadPool(5);
        ScheduledThreadPoolExecutor scheduledPool=new ScheduledThreadPoolExecutor(5);

       Thread oncetask=new Thread(()->{
           System.out.println("oncetask running!");
       });

       Thread fixedtask=new Thread(()->{
           System.out.println("fixedtask running!");
       });

        scheduledPool.schedule(oncetask,3000,TimeUnit.MILLISECONDS);
        scheduledPool.scheduleWithFixedDelay(fixedtask,3000,2000,TimeUnit.MILLISECONDS);

        TimeUnit.MILLISECONDS.sleep(10000);

        stop(scheduledPool);
    }


    public static void stop(ExecutorService executor){
        try{
            System.out.println("attempt to shutdown executor!");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);

        }catch (InterruptedException e){
            System.err.println("termination interrupted!");

        }finally {
            if(!executor.isTerminated()){
                System.err.println("killing non-finished task!");
            }
            executor.shutdown();
            System.out.println("shutdown finished!");

        }
    }
}
