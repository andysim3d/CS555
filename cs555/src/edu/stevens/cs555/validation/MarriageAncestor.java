package edu.stevens.cs555.validation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

import edu.stevens.cs555.entities.ErrorOut;
import edu.stevens.cs555.entities.Family;
import edu.stevens.cs555.entities.Individual;

public class MarriageAncestor {

	public static ArrayList<ErrorOut> checkIndi(
			Hashtable<String, Family> fmNodes,
			Hashtable<String, Individual> indiNodes) {
		ArrayList<ErrorOut> errors = new ArrayList<ErrorOut>();
		Set<String> ancesName = new HashSet<String>();
		for (String key : indiNodes.keySet()) {
			for (int i = 0; i < indiNodes.get(key).getFamc().size(); i++) {
				// ances.add(indiNodes.get(key).getFamc().get(i));
				for (String key1 : fmNodes.keySet()) {
					if (fmNodes.get(key1).getId()
							.equals(indiNodes.get(key).getFamc().get(i))) {
						if (!fmNodes.get(key1).getHusb()
								.equals(fmNodes.get(key1).getWife())) {
							ancesName.add(fmNodes.get(key1).getHusb());
							ancesName.add(fmNodes.get(key1).getWife());
						}
					}

				}
				for (int i1 = 0; i1 < indiNodes.get(key).getFams().size(); i1++) {
					for (String key2 : fmNodes.keySet()) {
						if (fmNodes.get(key2).getId()
								.equals(indiNodes.get(key).getFams().get(i))) {
							if (indiNodes.get(key).getSex().equals("M")) {
								if (!ancesName.add(fmNodes.get(key2).getWife())) {
									errors.add(new ErrorOut("12", true,
											"Individual (" + key + ")"
													+ " marry with parent"));

								}
								;
							} else {
								if (!ancesName.add(fmNodes.get(key2).getHusb())) {
									errors.add(new ErrorOut("12", true,
											"Individual (" + key + ")"
													+ " marry with parent"));
								}
								;
							}
						}
					}
				}
			}

		}
		ancesName.clear();
		return errors;
	}
}
