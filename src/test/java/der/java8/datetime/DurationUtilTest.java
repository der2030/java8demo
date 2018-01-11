package der.java8.datetime;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.Duration;
import java.time.LocalTime;

/**
* @FileName:DurationUtilTest
* @Description:
* @Author: Derrick Ye
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DurationUtilTest {

  @Test
    public void plusDataesTest(){
        LocalTime localTime=LocalTime.now();
        System.out.println("localtime is:"+localTime);
        assertThat(localTime,notNullValue());
        Duration duration=Duration.ofHours(10);
        assertThat(duration,notNullValue());

        LocalTime plusLocaltime=DurationUtil.plusDates(localTime,duration);
        assertThat(plusLocaltime,notNullValue());
        System.out.println("plusLocaltime is:"+plusLocaltime);

        Duration difference=DurationUtil.getDifferenceBetweenDates(plusLocaltime,localTime);
        assertThat(difference,notNullValue());
        System.out.println("difference between Dates is :"+difference);
        difference.getUnits().forEach(temporalUnit ->System.out.println(temporalUnit+": "+duration.get(temporalUnit)+" ") );
    }

    @Test
    public void minusDataesTest(){
        LocalTime localTime=LocalTime.now();
        System.out.println("localtime is:"+localTime);
        assertThat(localTime,notNullValue());
        Duration duration=Duration.ofHours(10);
        assertThat(duration,notNullValue());

        LocalTime minusLocaltime=DurationUtil.minusDates(localTime,duration);
        assertThat(minusLocaltime,notNullValue());
        System.out.println("minusLocaltime is:"+minusLocaltime);

        Duration difference=DurationUtil.getDifferenceBetweenDates(localTime,minusLocaltime);
        assertThat(difference,notNullValue());
        System.out.println("difference between Dates is :"+difference);
        difference.getUnits().forEach(temporalUnit ->System.out.println(temporalUnit+": "+duration.get(temporalUnit)+" ") );

    }

}
