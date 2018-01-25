package der.java8.thread;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
* @FileName:ExecutorsDemoTest
* @Description:
* @Author: Derrick Ye
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ExecutorsDemoTest {
    @Test
    public void testSingleExecutors(){

        ExecutorsDemo.doSingleThreadExecutor(3);

        ExecutorsDemo.doSingleThreadExecutor(10);
    }
    @Test
    public void testFixedPool(){
        ExecutorsDemo.doFixedThreadPool();
    }
    @Test
    public void testCachePool(){
        ExecutorsDemo.doCacheExecutorPool();
    }
    @Test
    public void testSchedulePool()throws InterruptedException{
        ExecutorsDemo.doScheduledThreadPool();
    }
}
