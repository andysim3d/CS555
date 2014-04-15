/* Name: CheckMBB.java
 * Author: Ruixiang Chu
 * Date: 07/04/2014
 * 
 * Function: Check if a person marry to himself
 */
package edu.stevens.cs555.validation;

import java.util.ArrayList;
import java.util.Hashtable;

import edu.stevens.cs555.entities.ErrorOut;
import edu.stevens.cs555.entities.Family;
import edu.stevens.cs555.entities.Individual;

public class CheckMBB {
	public static ArrayList<ErrorOut> mbbCheck(Hashtable<String, Family> fmNode, Hashtable<String, Individual> indNode){
		ArrayList<ErrorOut> errors = new ArrayList<ErrorOut>();
		for(String key : fmNode.keySet()){
			Family family = fmNode.get(key);
			Individual father = indNode.get(family.getHusb());
			Individual mother = indNode.get(family.getWife());
			if(father != null && mother != null){
				if(family.isMarr() && family.getMarr_date_aval() && father.isBorn() && mother.isBorn()){
					if(family.getMarr_date().before(father.getBirthday()) || family.getMarr_date().before(mother.getBirthday())){
						errors.add(new ErrorOut("3", true , "Family(" +key + ")" + "'s husband and wife are married before their birth"));
					}
				}
			}
		}
		return errors;
	}
}
