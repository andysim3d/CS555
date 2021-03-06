/* Name: Input2Node.java
 * Author: Gao Xing
 * Date: 24/02/2014
 * 
 * Function:Singlton Patten: getInstance than use getIndNode
 */
package edu.stevens.cs555.factory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Hashtable;

import edu.stevens.cs555.entities.Family;
import edu.stevens.cs555.entities.Individual;

public class Input2Node {
	private static Input2Node instance = null;

	private Input2Node() {

	}

	public static Input2Node getInstance(String path) throws Exception {
		if (instance == null) {
			instance = new Input2Node();
			instance.convertNode(path);
		}
		return instance;
	}

	private Hashtable<String, Individual> indNode = new Hashtable<String, Individual>();
	private Hashtable<String, Family> fmNode = new Hashtable<String, Family>();

	Individual indi;
	Family fm;

	// Fill in two hashtable
	public void convertNode(String path) throws Exception {

		// absolute path for testing file
		BufferedReader br = null;
		String IorF = null;
		try {
			br = new BufferedReader(new FileReader(path));
			String line = br.readLine();
			while (line != null) {

				if (line.startsWith("0")) {
					//System.out.println(line);
					if (line.endsWith("TRLR")) {
						if (IorF != null && IorF.equals("I")) {
							indNode.put(indi.getId(), indi);
						} else if (IorF != null && IorF.equals("F")) {
							fmNode.put(fm.getId(), fm);
							//System.out.println(fm.getId());
						}
						br.close();
						return;
					} else if (line.endsWith("INDI")) {
						String id = line.substring(line.indexOf("@") + 1,
								line.lastIndexOf("@"));
						if (IorF == "I") {
							indNode.put(indi.getId(), indi);

						} else if (IorF == "F") {
							fmNode.put(fm.getId(), fm);
						}
						IorF = "I";
						indi = new Individual();
						indi.setId(id);

					} else if (line.endsWith("FAM")) {

						String id = line.substring(line.indexOf("@") + 1,
								line.lastIndexOf("@"));

						if (IorF != null && IorF.equals("I")) {
							indNode.put(indi.getId(), indi);
						} else if (IorF != null && IorF.equals("F")) {
							fmNode.put(fm.getId(), fm);
						}
						IorF = "F";
						fm = new Family();
						fm.setId(id);
					} else {
						if (IorF != null && IorF.equals("I")) {
							indNode.put(indi.getId(), indi);
						} else if (IorF != null && IorF.equals("F")) {
							fmNode.put(fm.getId(), fm);
							//System.out.println(fm.getId());
						}
						IorF = null;

					}
				} else {

					String[] output;

					if (line.length() == 0) {
						line = br.readLine();

					}
					output = line.split(" ");
					if (output[1].equals("NAME")) {
						indi.setName(output[2]);
					} else if (output[1].equals("SEX")) {
						indi.setSex(output[2]);
					} else if (output[1].equals("BIRT")) {

						line = br.readLine();
						output = line.split(" ");
						SimpleDateFormat formatter = new SimpleDateFormat(
								"MMM dd yyyy");
						indi.setBirthday((formatter.parse(output[3] + " "
								+ output[2] + " " + output[4])));
					} else if (output[1].equals("DEAT")) {

						line = br.readLine();
						output = line.split(" ");
						SimpleDateFormat formatter = new SimpleDateFormat(
								"MMM dd yyyy");
						indi.setDeathday((formatter.parse(output[3] + " "
								+ output[2] + " " + output[4])));
					} else if (output[1].equals("FAMC")) {
						indi.setFamc(output[2].substring(
								output[2].indexOf("@") + 1,
								output[2].lastIndexOf("@")));

					} else if (output[1].equals("FAMS")) {
						indi.setFams(output[2].substring(
								output[2].indexOf("@") + 1,
								output[2].lastIndexOf("@")));
						//System.out.println(line);

					} else if (output[1].equals("MARR")) {
						fm.setMarr(true);
						// read addtional line for Node level 2
						line = br.readLine();
						output = line.split(" ");
						SimpleDateFormat formatter = new SimpleDateFormat(
								"MMM dd yyyy");
						fm.setMarr_date((formatter.parse(output[3] + " "
								+ output[2] + " " + output[4])));

					} else if (output[1].equals("HUSB")) {
						fm.setHusb(output[2].substring(
								output[2].indexOf("@") + 1,
								output[2].lastIndexOf("@")));
					} else if (output[1].equals("WIFE")) {
						fm.setWife(output[2].substring(
								output[2].indexOf("@") + 1,
								output[2].lastIndexOf("@")));

					} else if (output[1].equals("CHIL")) {
						fm.setChil(output[2].substring(
								output[2].indexOf("@") + 1,
								output[2].lastIndexOf("@")));

					} else if (output[1].equals("DIV")) {
						fm.setDiv(true);
						// read addtional line for Node level 2
						line = br.readLine();
						output = line.split(" ");
						SimpleDateFormat formatter = new SimpleDateFormat(
								"MMM dd yyyy");
						fm.setDiv_date((formatter.parse(output[3] + " "
								+ output[2] + " " + output[4])));
					}

				}
				line = br.readLine();
			}

		} finally {
			br.close();
		}
	}

	public Hashtable<String, Individual> getIndNode() {
		return this.indNode;
	}

	public Hashtable<String, Family> getFmNode() {
		return this.fmNode;
	}

}
