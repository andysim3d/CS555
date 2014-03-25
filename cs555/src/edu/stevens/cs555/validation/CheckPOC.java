/* Name: CheckPOC.java
 * Author: Ruixiang Chu
 * Date: 18/03/2014
 * 
 * Function: Check if parents has the age older than their children
 */

package edu.stevens.cs555.validation;

import java.util.ArrayList;
import java.util.Hashtable;

import edu.stevens.cs555.entities.ErrorOut;
import edu.stevens.cs555.entities.Family;
import edu.stevens.cs555.entities.Individual;

public class CheckPOC {
	public static ArrayList<ErrorOut> pocCheck(Hashtable<String, Family> fmNode, Hashtable<String, Individual> indNode){
		ArrayList<ErrorOut> errors = new ArrayList<ErrorOut>();
		for(String key : fmNode.keySet()){
			Family family = fmNode.get(key);
			Individual father = indNode.get(family.getHusb());
			Individual mother = indNode.get(family.getWife());
			ArrayList<String> children = family.getChil();
			
			for(String c : children){
				Individual child = indNode.get(c);
				
				if(father != null){
					if(father.isBorn() && child.isBorn()){
						if(father.getBirthday().after(child.getBirthday())){
							errors.add(new ErrorOut("3", true , "Family(" +key + ")" + "'s parent is younger than his child"));
						}
					}
				}
					
				if(mother != null){
					if(mother.getBirthday().after(child.getBirthday())){
						errors.add(new ErrorOut("3", true , "Family(" +key + ")" + "'s parent is yoinger than his child"));
					}
				}	
			}	
		}
		return errors;
	}
}
