/* Name: MarWithDeath.java
 * Author: Pengfei Zhang
 * Date: 18/03/2014
 * 
 * Function: Check if couples has death date earlier than they marry date
 */
package edu.stevens.cs555.validation;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

import edu.stevens.cs555.entities.ErrorOut;
import edu.stevens.cs555.entities.Family;
import edu.stevens.cs555.entities.Individual;

public class MarWithDead {
	public static ArrayList<ErrorOut> MarryCheck(Hashtable<String, Family> fmNode, Hashtable<String, Individual> indNode)
	{
		ArrayList<ErrorOut> errors = new ArrayList<ErrorOut>();
		
		for(String key : fmNode.keySet()){
			//if No marry date exist, continue
			if((fmNode.get(key).isMarr())){
				//else, save marry date
				Date marry = fmNode.get(key).getMarr_date();
				//if husband is dead, check his death date and compare
				if(indNode.get(fmNode.get(key).getHusb()).isDead()){
					if(indNode.get(fmNode.get(key).getHusb()).getDeathday().before(marry)){
						errors.add(new ErrorOut("4",true , "Inividual(" +fmNode.get(key).getWife() + ")" + "marries to a dead people("
								+ fmNode.get(key).getHusb()+")"));
					}
				}
				if(indNode.get(fmNode.get(key).getWife()).isDead()){
					if(indNode.get(fmNode.get(key).getWife()).getDeathday().before(marry)){
						errors.add(new ErrorOut("4",true , "Inividual(" +fmNode.get(key).getHusb() + ")" + "marries to a dead people("
								+ fmNode.get(key).getWife() + ")"));
					}
				}
				
				
			}
			
		}
		return errors;
	}
}
