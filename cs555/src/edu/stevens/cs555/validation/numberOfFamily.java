package edu.stevens.cs555.validation;

import java.util.ArrayList;
import java.util.Hashtable;

import edu.stevens.cs555.entities.ErrorOut;
import edu.stevens.cs555.entities.Family;
import edu.stevens.cs555.entities.Individual;

public class numberOfFamily {
	public static int numberOutInt(Hashtable<String, Family> fmNode){
		
		for(String key : fmNode.keySet()){
			System.out.println("The family " + key + " has " + String.valueOf(fmNode.get(key).getChil().size()+2) + "members");
		return fmNode.get(key).getChil().size()+2;}
		return 0;
		
		
	}
public static void numberOfFamily(Hashtable<String, Family> fmNode){
		
		for(String key : fmNode.keySet()){
			System.out.println("The family " + key + " has " + String.valueOf(fmNode.get(key).getChil().size()+2) + "members");
		}
		
		
	}
}
