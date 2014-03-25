/* Name: CheckMTO.java
 * Author: Ruixiang Chu
 * Date: 18/03/2014
 * 
 * Function: Check if a person marry to himself
 */
package edu.stevens.cs555.validation;

import java.util.ArrayList;
import java.util.Hashtable;

import edu.stevens.cs555.entities.ErrorOut;
import edu.stevens.cs555.entities.Family;
import edu.stevens.cs555.entities.Individual;

public class CheckMTO {
	public static ArrayList<ErrorOut> mtoCheck(Hashtable<String, Family> fmNode, Hashtable<String, Individual> indNode){
		ArrayList<ErrorOut> errors = new ArrayList<ErrorOut>();
		for(String key : fmNode.keySet()){
			Family family = fmNode.get(key);
			Individual father = indNode.get(family.getHusb());
			Individual mother = indNode.get(family.getWife());
				
			if(father != null && mother != null){
				if(father.getId().equals(mother.getId())){
					errors.add(new ErrorOut("3", true , "Family(" +key + ")" + "'s husband and wife are same person"));
				}
			}
		}
		return errors;
	}
}
