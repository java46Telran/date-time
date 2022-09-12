package telran.time.application;

import java.time.temporal.ChronoUnit;
//TODO
//Application class
//Performs beeps each specified time interval
public class Reminder {

	public static void main(String[] args) {
		//mandatory args[0] interval value
		//mandatory args[1] ChronoUnit enum string value (case insensitive)
		//optional args[2] when ended in the given ChronoUnit (see args[1]), default in 1 hour
		//beep System.out.println("\007\007\007") - will sound only on real console
		// example of launching: java -jar reminder.jar 10 seconds 100  -
		// each 10 seconds during 100 seconds there should be beeps
	

	}

}
