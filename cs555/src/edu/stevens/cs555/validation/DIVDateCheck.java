/* Name: DIVDateCheck.java
 * Author: Pengfei Zhang
 * Date: 18/03/2014
 * 
 * Function: Check if couples have divorce date earlier than their marry date
 */

package edu.stevens.cs555.validation;
import java.util.ArrayList;
import java.util.Hashtable;

import edu.stevens.cs555.entities.ErrorOut;
import edu.stevens.cs555.entities.Family;
public class DIVDateCheck {
	public static ArrayList<ErrorOut> DateCheck(Hashtable<String, Family> fmNode)
	{
		ArrayList<ErrorOut> errors = new ArrayList<ErrorOut>();
		
		for(String key : fmNode.keySet()){
			if((fmNode.get(key).isMarr()) &&(fmNode.get(key).isDiv()) ){
				if(fmNode.get(key).getDiv_date().before(fmNode.get(key).getMarr_date()))
				errors.add(new ErrorOut("3",true , "Family(" +key + ")" + "'marry date is after Divorce date"));
			}
		}
		return errors;
	}
	
}
