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
	public static final String[] TAG0S = new String[] { "INDI", "FAM", "TRLR",
			"NOTE" };
	public static final String[] TAG1S = new String[] { "NAME", "SEX", "BIRT",
			"DEAT", "FAMC", "FAMS", "MARR", "HUSB", "WIFE", "CHIL", "DIV" };
	public static final String[] TAG2S = new String[] { "DATE" };
	public static int InValidData;

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

	private Hashtable<String, Individual> indNode = null;
	private Hashtable<String, Family> fmNode = null;

	Individual indi;
	Family fm;

	// Fill in two hashtable
	public void convertNode(String path) throws Exception {

		// absolute path for testing file
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
			System.out.println("1");
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			boolean oneNode = true;
			boolean ind;

			while (line != null) {

				// if node 0 we need create new object
				if (line.contains("INDI")) {
					String id = line.substring(line.indexOf("@"),
							line.lastIndexOf("@"));
					indi = new Individual();
					indi.setId(id);
					System.out.println(line);
					while (!line.startsWith("0")) {
						System.out.println(line);
						// indNode.put(id, indi);
						String[] output;
						output = line.split(" ");

						if (output[1] == "NAME") {
							indi.setName(output[2]);
						} else if (output[1] == "SEX") {
							indi.setSex(output[2]);
						} else if (output[1] == "BIRT") {

							// read addtional line for Node level 2
							line = br.readLine();
							output = line.split(" ");
							SimpleDateFormat formatter = new SimpleDateFormat(
									"MMM dd yyyy");
							indi.setBirthday(formatter.parse(output[2]));
						} else if (output[1] == "DEAT") {
							// read addtional line for Node level 2
							line = br.readLine();
							output = line.split(" ");
							SimpleDateFormat formatter = new SimpleDateFormat(
									"MMM dd yyyy");
							indi.setDeathday((formatter.parse(output[2])));
						} else if (output[1] == "FAMC") {
							indi.setFamc(output[2].substring(
									output[2].indexOf("@"),
									output[2].lastIndexOf("@")));

						} else if (output[1] == "FAMS") {
							indi.setFams(output[2].substring(
									output[2].indexOf("@"),
									output[2].lastIndexOf("@")));
						}
						indNode.put(id, indi);
						// continue to read next line
						line = br.readLine();
					}

				} else if (line.contains("FAM")) {
					String id = line.substring(line.indexOf("@"),
							line.lastIndexOf("@"));

					fm = new Family();
					fm.setId(id);
					while (!line.startsWith("0")) {

						// indNode.put(id, indi);
						String[] output;
						output = line.split(" ");

						if (output[1] == "MARR") {
							fm.setMarr(true);
							// read addtional line for Node level 2
							line = br.readLine();
							output = line.split(" ");
							SimpleDateFormat formatter = new SimpleDateFormat(
									"MMM dd yyyy");
							fm.setMarr_date((formatter.parse(output[2])));

						} else if (output[1] == "HUSB") {
							fm.setHusb(output[2]);
						} else if (output[1] == "WIFE") {
							fm.setWife(output[2]);

						} else if (output[1] == "CHIL") {
							fm.setChil(output[2]);

						} else if (output[1] == "DIV") {
							fm.setDiv(true);
							// read addtional line for Node level 2
							line = br.readLine();
							output = line.split(" ");
							SimpleDateFormat formatter = new SimpleDateFormat(
									"MMM dd yyyy");
							fm.setDiv_date(formatter.parse(output[2]));
						}
						fmNode.put(id, fm);
						// continue to read next line
						line = br.readLine();
					}
				} else {

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
