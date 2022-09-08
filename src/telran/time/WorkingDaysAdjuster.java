package telran.time;

import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class WorkingDaysAdjuster implements TemporalAdjuster {

	int[] daysOff;
	int nDays;

	public int[] getDaysOff() {
		return daysOff;
	}

	public void setDaysOff(int[] daysOff) {
		this.daysOff = daysOff;
	}

	public int getnDays() {
		return nDays;
	}

	public void setnDays(int nDays) {
		this.nDays = nDays;
	}

	public WorkingDaysAdjuster(int[] daysOff, int nDays) {

		this.daysOff = daysOff;
		this.nDays = nDays;
	}

	public WorkingDaysAdjuster() {
	}

	@Override
	public Temporal adjustInto(Temporal temporal) {

		int count = 0;
		if (daysOff.length < DayOfWeek.values().length) {
			while (count != nDays) {
				temporal = temporal.plus(1, ChronoUnit.DAYS);
				if (!contains(temporal.get(ChronoField.DAY_OF_WEEK))) {
					count++;
				}
			}
		}

		return temporal;
	}

	private boolean contains(int day) {
		for (int di : daysOff) {
			if (di == day) {
				return true;
			}

		}
		return false;
	}

}
