package der.java8.datetime;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
* @FileName:LocalTimeUtil
* @Description:
* @Author: Derrick Ye
*/
public class LocalTimeUtil {

  public static LocalTime getLocalTimeFactoryOfMethod(int hour, int min, int seconds) {
        return LocalTime.of(hour, min, seconds);
    }

    public static  LocalTime getLocalTimeParseMethod(String strTime) {
        return LocalTime.parse(strTime);
    }

    public static LocalTime getLocalTimeFromClock() {
        return LocalTime.now();
    }

    public static  LocalTime addAnHour(LocalTime localTime) {
        return localTime.plus(1, ChronoUnit.HOURS);
    }

    public static int getHourFromLocalTime(LocalTime localTime) {
        return localTime.getHour();
    }

    public static  LocalTime getLocalTimeWithMinuteSetToValue(LocalTime localTime, int minute) {
        return localTime.withMinute(minute);
    }
}
