package der.java8.datetime;

import java.time.Duration;
import java.time.LocalTime;

/**
* @FileName:DurationUtil
* @Description:
* @Author: Derrick Ye
*/
public class DurationUtil {

    public static LocalTime plusDates(LocalTime localTime, Duration duration) {
        return localTime.plus(duration);
    }

    public static LocalTime minusDates(LocalTime localTime, Duration duration) {
        return localTime.minus(duration);
    }

    public static Duration getDifferenceBetweenDates(LocalTime localTime1, LocalTime localTime2) {
        return Duration.between(localTime1, localTime2);
    }
}
