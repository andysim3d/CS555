package edu.stevens.cs555.validation;

import java.util.ArrayList;
import java.util.Hashtable;

import edu.stevens.cs555.entities.ErrorOut;
import edu.stevens.cs555.entities.Family;
import edu.stevens.cs555.entities.Individual;

public class CheckBigamy {

	public static ArrayList<ErrorOut> MarryCheck(
			Hashtable<String, Family> fmNode,
			Hashtable<String, Individual> indNode) {

		ArrayList<ErrorOut> errors = new ArrayList<ErrorOut>();

		for (String key : indNode.keySet()) {
			ArrayList<String> fcc = new ArrayList<String>();
			// scan all families and find whose wife or husband is key
			for (String fmk : fmNode.keySet()) {
				if ((fmNode.get(fmk).getHusb().equals(key))
						|| (fmNode.get(fmk).getWife().equals(key)))
				{
					fcc.add(fmk);
				}
			}
				// compare all marry date and div date
				if (fcc.size() > 1) {
					for (int i = 0; i < fcc.size() - 1; i++) {
						for (int j = i; j < fcc.size(); j++) {
							if (InterVal(fmNode.get(fcc.get(i)),
									fmNode.get(fcc.get(j)))) {
								errors.add(new ErrorOut("10",true ,"Individal" + key+ "is a bigamy"));
							}
						}
					}

				}
				// else, he/she must can't be bigamy.
				else {
					continue;
				}

			}

		
		return errors;
	}

	public static Boolean InterVal(Family fm1, Family fm2) {
		if (fm1.getMarr_date_aval() && fm1.getDiv_date_aval()
				&& fm2.getDiv_date_aval() && fm2.getMarr_date_aval()) {

			if ( (fm1.getMarr_date().before(fm2.getMarr_date())) && (fm1
					.getDiv_date().after(fm2.getMarr_date()))) {
				return true;
			}
			if ( (fm2.getMarr_date().before(fm1.getMarr_date())) && (fm2
					.getDiv_date().after(fm1.getMarr_date()))) {
				return true;
			}
			
			else {
				return false;
			}
		} else {
			return false;
		}
	}

}
