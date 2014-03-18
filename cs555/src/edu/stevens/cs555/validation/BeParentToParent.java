/* Name: BeParentToParent.java
 * Author: Pengfei Zhang
 * Date: 18/03/2014
 * 
 * Function: Check if the child is his parents' parent.
 */


package edu.stevens.cs555.validation;

import java.util.ArrayList;
import java.util.Hashtable;

import edu.stevens.cs555.entities.ErrorOut;
import edu.stevens.cs555.entities.Family;
import edu.stevens.cs555.entities.Individual;

public class BeParentToParent {
	public static ArrayList<ErrorOut> sexCheck(Hashtable<String, Family> fmNode, Hashtable<String, Individual> indNode){
		ArrayList<ErrorOut> errors = new ArrayList<ErrorOut>();
		for(String key : fmNode.keySet()){
			ArrayList<String> Child = fmNode.get(key).getChil();
			//if no descendant, find next family;
			if(Child.size() == 0){
				continue;
			}
			//if has descendants, find all grandchilds of currant couple, and compare
			//their ID with their grandchilds
			ArrayList<String> GrandChilds = new ArrayList<String>();
			
			for(int i = 0; i < Child.size(); i++){
				ArrayList<String> Fams = new ArrayList<String>();
				Fams = indNode.get(Child.get(i)).getFamc();
				
				for(int j = 0; j< Fams.size(); j++){
					GrandChilds.addAll(fmNode.get(Fams.get(j)).getChil());
				}
			}
			
			if(GrandChilds.contains(fmNode.get(key).getHusb())){
				errors.add(new ErrorOut("2",true , "Indvidual "+ key + "is his grandchild"));
			}
			if(GrandChilds.contains(fmNode.get(key).getWife())){
				errors.add(new ErrorOut("2",true , "Indvidual "+ key + "is her grandchild"));
			}
		}
		return errors;
	}
}
