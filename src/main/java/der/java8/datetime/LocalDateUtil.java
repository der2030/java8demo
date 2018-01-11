package der.java8.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
* @FileName:LocalDateUtil
* @Description:
* @Author: Derrick Ye
*/
public class LocalDateUtil {

   public static LocalDate getLocalDateFactoryOfMethod(int year, int month, int dayOfMonth) {
        return LocalDate.of(year, month, dayOfMonth);
    }

    public static LocalDate getLocalDateParseMethod(String strDate) {
        return LocalDate.parse(strDate);
    }

    public static  LocalDate getLocalDateFromClock() {
        LocalDate localDate = LocalDate.now();
        return localDate;
    }

    public static  LocalDate getNextDay(LocalDate localDate) {
        return localDate.plusDays(1);
    }

    public static LocalDate getPreviousDay(LocalDate localDate) {
        return localDate.minus(1, ChronoUnit.DAYS);
    }

    public static DayOfWeek getDayOfWeek(LocalDate localDate) {
        DayOfWeek day = localDate.getDayOfWeek();
        return day;
    }

    public static LocalDate getFirstDayOfMonth() {
        LocalDate firstDayOfMonth = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        return firstDayOfMonth;
    }

    public static LocalDateTime getStartOfDay(LocalDate localDate) {
        LocalDateTime startofDay = localDate.atStartOfDay();
        return startofDay;
    }

}
