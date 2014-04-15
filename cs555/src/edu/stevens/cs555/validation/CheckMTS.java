/* Name: CheckMTS.java
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

public class CheckMTS {
	public static ArrayList<ErrorOut> mtsCheck(Hashtable<String, Family> fmNode){
		ArrayList<ErrorOut> errors = new ArrayList<ErrorOut>();
		for(String key : fmNode.keySet()){
			Family family = fmNode.get(key);
			String father = family.getHusb();
			String mother = family.getWife();
			
			if(father != null && mother != null && !father.equals(mother)){
				for(String familyKey : fmNode.keySet()){
					Family innerFamily = fmNode.get(familyKey);
					ArrayList<String> children = innerFamily.getChil();
					
					if(children.contains(father) && children.contains(mother)){
						errors.add(new ErrorOut("3", true , "Family(" +key + ")" + "'s husband and wife are siblings"));
					}
				}
			}
		}
		return errors;
	}
}
