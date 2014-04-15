/* Name: SiblingBirthCheck.java
 * Author: Pengfei Zhang
 * Date: 18/03/2014
 * 
 * Function: Check if sibling's birthday is gap longer than 10 mouth
 */
package edu.stevens.cs555.validation;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;

import edu.stevens.cs555.entities.ErrorOut;
import edu.stevens.cs555.entities.Family;
import edu.stevens.cs555.entities.Individual;

public class SiblingBirthCheck {
	
	public static ArrayList<ErrorOut> SBCheck(Hashtable<String, Family> fmNode,Hashtable<String, Individual> indNode){
		ArrayList<ErrorOut> errors = new ArrayList<ErrorOut>();

		for (String keys : fmNode.keySet()) {
			ArrayList<String> Siblings = fmNode.get(keys).getChil();
			if(Siblings.size() <=1){
				continue;
			}
			
			for (int i = 0; i < Siblings.size()-1; i++) {
				for (int j = i+1; j < Siblings.size(); j++) {
					if ( DateCheck(indNode.get(Siblings.get(i)), indNode.get(Siblings.get(j)) )) {
						errors.add(new ErrorOut("13", true, 
								Siblings.get(i).toString() + " and " +Siblings.get(j).toString()+
								" are have a abnormal birth date"));
					}
				}
			}
			
		}
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
