package telran.time.application;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
//Application class
//Performs beeps each specified time interval
public class Reminder {
	 static final long DEFAULT_BEEPS_DURATION = 3_600_000; //in milliseconds
	static long intervalOfBeeps;
	static ChronoUnit unit;
	static long beepsDuration;
	
	public static void main(String[] args) {
		//mandatory args[0] interval value
		//mandatory args[1] ChronoUnit enum string value (case insensitive)
		//optional args[2] when ended in the given ChronoUnit (see args[1]), default in 1 hour
		//beep System.out.println("\007\007\007") - will sound only on real console
		// example of launching: java -jar reminder.jar 10 seconds 100  -
		// each 10 seconds during 100 seconds there should be beeps
		try {
			setIntervalOfBeeps(args);
			setUnit(args);
			intervalToMillis();
			setBeepsDuration(args);
			runBeeps();
		}catch(RuntimeException e) {
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void runBeeps() {
		Instant start = Instant.now();
		
		do {
			waitingFor(intervalOfBeeps);
			System.out.println("\007\007\007");
		}while(ChronoUnit.MILLIS.between(start, Instant.now()) < beepsDuration);
		
	}

	private static void waitingFor(long periodInMillis) {
		Instant start = Instant.now();
		do {
			
		}while(ChronoUnit.MILLIS.between(start, Instant.now()) < periodInMillis);
		
	}

	private static void setBeepsDuration(String[] args) throws Exception{
		if (args.length < 3) {
			beepsDuration = DEFAULT_BEEPS_DURATION; //one hour to milliseconds
		} else {
			try {
				beepsDuration = Long.parseLong(args[2]);
			} catch (NumberFormatException e) {
				throw new Exception("Beeps duration should be a number");
			}
			if (beepsDuration < 0) {
				throw new Exception("Beeps duration can't be a negative number");
			}
			beepsDuration = Duration.of(beepsDuration, unit).toMillis();
		}
		
	}

	private static void intervalToMillis() {
		intervalOfBeeps = Duration.of(intervalOfBeeps, unit).toMillis();//conversion to milliseconds from unit
		
	}

	private static void setUnit(String[] args) throws Exception {
		if (args.length < 2) {
			throw new Exception("Chrono Unit should be specified as the second argument");
		}
		try {
			unit = ChronoUnit.valueOf(args[1].toUpperCase());
			
		} catch (IllegalArgumentException e) {
			throw new Exception("Wrong Chrono Unit");
		}
		
	}

	private static void setIntervalOfBeeps(String[] args) throws Exception {
		if (args.length == 0) {
			throw new Exception("Interval between beeps should be specified as the first argument");
		}
		try {
			intervalOfBeeps = Long.parseLong(args[0]);
		}catch (NumberFormatException e) {
			throw new Exception("Interval between beeps should be a number");
		}
		if (intervalOfBeeps < 0) {
			throw new Exception("interval can't be a negative number");
		}
		
	}

}
