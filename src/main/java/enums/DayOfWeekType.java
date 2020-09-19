package enums;

import java.time.DayOfWeek;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

public enum DayOfWeekType {
    WEEKDAY,
    WEEKEND;

    public static DayOfWeekType fromDayOfWeek(final DayOfWeek dayOfWeek) {
        if (dayOfWeek.equals(SATURDAY) || dayOfWeek.equals(SUNDAY))
            return WEEKEND;
        return WEEKDAY;
    }
}
