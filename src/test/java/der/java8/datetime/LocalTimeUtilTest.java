package der.java8.datetime;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalTime;

/**
* @FileName:LocalTimeUtilTest
* @Description:
* @Author: Derrick Ye
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LocalTimeUtilTest {

    @Test
    public void localTimeTest(){
        int hour=15;
        int minus=10;
        int second=55;

        LocalTime time1=LocalTimeUtil.getLocalTimeFactoryOfMethod(hour,minus,second);
        assertThat(time1,notNullValue());
        System.out.println("time1 is :"+time1);

        String strTime="12:30:11";
        LocalTime time2=LocalTimeUtil.getLocalTimeParseMethod(strTime);
        assertThat(time2,notNullValue());
        System.out.println("After parsing,time2 is :"+time2);

        LocalTime time3=LocalTimeUtil.getLocalTimeFromClock();
        assertThat(time3,notNullValue());
        System.out.println("time3 is :"+time3);

        LocalTime time4=LocalTimeUtil.addAnHour(time3);
        assertThat(time4,notNullValue());
        System.out.println("After adding one hour, time4 is :"+time4);



    }
}
