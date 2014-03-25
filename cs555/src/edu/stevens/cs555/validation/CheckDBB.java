/* Name: CheckDBB.java
 * Author: Ruixiang Chu
 * Date: 18/03/2014
 * 
 * Function: Check if a person's death is before his birth
 */
package edu.stevens.cs555.validation;

import java.util.ArrayList;
import java.util.Hashtable;

import edu.stevens.cs555.entities.ErrorOut;
import edu.stevens.cs555.entities.Individual;

public class CheckDBB {
	public static ArrayList<ErrorOut> dbbCheck(Hashtable<String, Individual> indNode){
		ArrayList<ErrorOut> errors = new ArrayList<ErrorOut>();
		for(String key : indNode.keySet()){
			Individual p = indNode.get(key);

			if(p.isDead()&&p.isBorn()){
				if(p.getBirthday().after(p.getDeathday())){
					errors.add(new ErrorOut("2", true , "Individual(" +key + ")" + "'s deathday is before his birthday"));
				}
			}
		}
		return errors;
	}
}
