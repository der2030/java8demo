package der.java8.datetime;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
* @FileName:LocalDateUtilTest
* @Description:
* @Author: Derrick Ye
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LocalDateUtilTest {

    @Test
    public void localDateTest(){
        int year=2016;
        int month=10;
        int day=22;

        LocalDate date1 =LocalDateUtil.getLocalDateFactoryOfMethod(year,month,day);
        assertThat(date1,notNullValue());
        System.out.println("date1 is :"+date1);

        String strDate="2017-10-10";
        LocalDate date2=LocalDateUtil.getLocalDateParseMethod(strDate);
        assertThat(date2,notNullValue());
        System.out.println("date2 is :"+date2);

        LocalDate date3=LocalDateUtil.getLocalDateFromClock();
        assertThat(date3,notNullValue());
        System.out.println("date3 is :"+date3);

        LocalDate nextDay=LocalDateUtil.getNextDay(date3);
        assertThat(nextDay,notNullValue());
        System.out.println("nextDay is :"+nextDay);

        LocalDate prevoiusDay=LocalDateUtil.getPreviousDay(date3);
        assertThat(prevoiusDay,notNullValue());
        System.out.println("prevoiusDay is :"+prevoiusDay);

        DayOfWeek dayOfWeek=LocalDateUtil.getDayOfWeek(date3);
        assertThat(dayOfWeek,notNullValue());
        System.out.println("dayOfWeek is :"+dayOfWeek);

    }
}
