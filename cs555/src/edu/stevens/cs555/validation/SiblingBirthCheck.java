package edu.stevens.cs555.validation;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;

import edu.stevens.cs555.entities.ErrorOut;
import edu.stevens.cs555.entities.Individual;

public class SiblingBirthCheck {
	
	public static ArrayList<ErrorOut> SBCheck(Hashtable<String, Individual> indNode){
		ArrayList<ErrorOut> errors = new ArrayList<ErrorOut>();

		return errors;
	}
	
	
	
	public static boolean DateCheck(Individual in1, Individual in2){
		if(in1.isBorn() && in2.isBorn()){
			Calendar ca = Calendar.getInstance();
			ca.setTime(in1.getBirthday());
			ca.add(Calendar.MONTH, 10);
			Date afterDate1 = ca.getTime();
			ca.setTime(in2.getBirthday());
			ca.add(Calendar.MONTH, 10);
			Date afterDate2 = ca.getTime();

			if ((in1.getBirthday().after(in2.getBirthday()))&&(in1.getBirthday().before(afterDate1))) {
				return true;
			}
			if ((in2.getBirthday().after(in1.getBirthday()))&&(in2.getBirthday().before(afterDate2))) {
				return true;
			}
			
			return false;
		}
		else{
			return false;
		}
		
	}
}
