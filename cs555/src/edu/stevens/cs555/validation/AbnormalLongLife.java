package edu.stevens.cs555.validation;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;

import edu.stevens.cs555.entities.ErrorOut;
import edu.stevens.cs555.entities.Individual;

public class AbnormalLongLife {
	private static final int MILLIS_IN_SECOND = 1000;
	private static final int SECONDS_IN_MINUTE = 60;
	private static final int MINUTES_IN_HOUR = 60;
	private static final int HOURS_IN_DAY = 24;
	private static final int DAYS_IN_YEAR = 365;
	private static final long MILLISECONDS_IN_YEAR = (long) MILLIS_IN_SECOND
			* SECONDS_IN_MINUTE * MINUTES_IN_HOUR * HOURS_IN_DAY * DAYS_IN_YEAR;

	public static ArrayList<ErrorOut> checkIndi(Hashtable<String, Individual> indiNodes) {
		ArrayList<ErrorOut> errors = new ArrayList<ErrorOut>();
		for (String key : indiNodes.keySet()) {
			if (indiNodes.get(key).isDead() || (!indiNodes.get(key).isBorn())) {

			} else {
				long dateDiff = Calendar.getInstance().getTime().getTime()
						- indiNodes.get(key).getBirthday().getTime();
				if (dateDiff / MILLISECONDS_IN_YEAR > 120) {
					errors.add(new ErrorOut("11", true, "Indvidual "
							+ indiNodes.get(key).getId()
							+ "'s age is greater than 120"));
				}
			}
		}
		return errors;
	}
}
