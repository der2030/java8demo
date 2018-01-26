package der.java8.thread;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
* @FileName:SynchronizersDemoTest
* @Description:
* @Author: Derrick Ye
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SynchronizersDemoTest {
    @Test
    public void testSynchronizers(){
        System.out.println("Latches is testing......");
        SynchronizersDemo.doLatches();
        System.out.println("Future Task is testing......");
        SynchronizersDemo.doFutureTask();
        System.out.println("Semaphore is testing......");
        SynchronizersDemo.doSemaphore();
    }
}
