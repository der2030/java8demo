package der.java8.thread;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
* @FileName:ReentrantReadWriteLockDemoTest
* @Description:
* @Author: Derrick Ye
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ReentrantReadWriteLockDemoTest {

    @Test
    public void testReadWriteLock() {
        ReentrantReadWriteLock rrwLock = new ReentrantReadWriteLock();
        ReentrantReadLockDemo rt1 = new ReentrantReadLockDemo("RRLD_1", rrwLock);
        ReentrantReadLockDemo rt2 = new ReentrantReadLockDemo("RRLD_2", rrwLock);
        ReentrantWriteLockDemo wt1 = new ReentrantWriteLockDemo("RWLD_1", rrwLock);
        rt1.start();
        rt2.start();
        wt1.start();
    }
}
