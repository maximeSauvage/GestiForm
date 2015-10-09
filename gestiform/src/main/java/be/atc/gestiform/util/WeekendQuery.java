package be.atc.gestiform.util;

import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;

public class WeekendQuery implements TemporalQuery<Boolean> {

    /* (non-Javadoc)
     * @see java.time.temporal.TemporalQuery#queryFrom(java.time.temporal.TemporalAccessor)
     */
    @Override
    public Boolean queryFrom(TemporalAccessor date) {

        int dayOfWeekNumber = date.get(ChronoField.DAY_OF_WEEK);
        DayOfWeek dayOfWeek = DayOfWeek.of(dayOfWeekNumber);

        if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
            return Boolean.TRUE; 
        } else {
            return Boolean.FALSE; 
        }
    }
}