package edu.stevens.cs555.validation;

import java.util.ArrayList;
import java.util.Hashtable;

import edu.stevens.cs555.entities.ErrorOut;
import edu.stevens.cs555.entities.Family;
import edu.stevens.cs555.entities.Individual;

public class wrongSex {
	public static ArrayList<ErrorOut> sexCheck(Hashtable<String, Family> fmNode, Hashtable<String, Individual> indNode){
		ArrayList<ErrorOut> errors = new ArrayList<ErrorOut>();
		for(String key : fmNode.keySet()){
			if(indNode.get(fmNode.get(key).getHusb()).getSex().equals("F")){
				errors.add(new ErrorOut("1",true , "Family(" +key + ")" + "'s husband is a female"));
			}
			if(indNode.get(fmNode.get(key).getWife()).getSex().equals("M")){
				errors.add(new ErrorOut("1",true , "Family(" +key + ")" + "'s husband is a male"));
			}
		}
		return errors;
	}
}
