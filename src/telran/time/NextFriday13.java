package telran.time;

import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class NextFriday13 implements TemporalAdjuster {

	@Override
	public Temporal adjustInto(Temporal temporal) {
		// TODO 
		// Friday is ChronoField.DAY_OF_WEEK == DayOfWeek.FRIDAY.ordinal() + 1
		// 13 day of month ChronoField.DAY_OF_MONTH == 13
		
		return null;
	}

}
