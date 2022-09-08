package telran.time.application;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class PrintCalendar {

	public static void main(String[] args) {
		int monthYear[];
		try {
			monthYear = getMonthYear(args);
			printCalendar(monthYear[0], monthYear[1]);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

	}

	private static void printCalendar(int month, int year) {
		printTitle(month, year);
		printWeekDays();
		printDates(month, year);
		
	}

	private static void printDates(int month, int year) {
		// TODO Auto-generated method stub
		
	}

	private static void printWeekDays() {
		DayOfWeek dayWeeks[] = DayOfWeek.values();
		for(DayOfWeek weekDay: dayWeeks) {
			System.out.printf("%s ", weekDay.getDisplayName(TextStyle.SHORT, Locale.getDefault()));
		}
		System.out.println();
		
	}

	private static void printTitle(int month, int year) {
		Month monthEn = Month.of(month);
		System.out.printf("%s, %d\n", monthEn.getDisplayName(TextStyle.FULL,
				Locale.getDefault()), year);
		
	}

	private static int[] getMonthYear (String[] args) throws Exception {
		LocalDate current = LocalDate.now();
		int [] res = {current.getMonthValue(), current.getYear()};
		if (args.length > 0) {
			res[0] = getMonth(args[0]);
			if (args.length > 1) {
				res[1] = getYear(args[1]);
			}
		}
		
		return res;
	}

	private static int getYear(String yearStr) throws Exception {
		try {
			int res = Integer.parseInt(yearStr);
			if (res <= 0) {
				throw new Exception("year should be a positive number");
			}
			return res;
		} catch (NumberFormatException e) {
			throw new Exception("year should be a number");
		}
		
		
	}

	private static int getMonth(String monthStr) throws Exception{
		try {
			int res = Integer.parseInt(monthStr);
			int nMonths = Month.values().length;
			if (res < 1 || res > nMonths) {
				throw new Exception(String.format("month %d is wrong value;"
						+ " should be in the range [1, %d]", res, nMonths));
			}
			return res;
		} catch (NumberFormatException e) {
			throw new Exception("month should be a number");
		}
		
	}

}
