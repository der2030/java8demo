package der.java8.thread;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
* @FileName:SynchronizedDemoTest
* @Description:
* @Author: Derrick Ye
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SynchronizedDemoTest {

    @Test
    public void testLock() throws InterruptedException{
        SynchronizedDemo sd=new SynchronizedDemo();

        for(int i=0;i<10;i++){
            new Thread(()->sd.SynchronizedDemoClass()).start();
        }
        Thread.sleep(1000);
        for(int i=0;i<10;i++){
            new Thread(()->sd.synchronizedMethod()).start();
        }
        Thread.sleep(1000);

        for(int i=0;i<10;i++){
            new Thread(()->sd.synchronizedThis()).start();
        }
        Thread.sleep(1000);

    }
}
