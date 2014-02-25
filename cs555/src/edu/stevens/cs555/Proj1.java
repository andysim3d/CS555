package edu.stevens.cs555;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Proj1 {

	public static void main(String[] args) throws Exception {
		try {
		} catch (Exception e) {

		}
	}

	/**
	 * @author andy
	 * @functionName read
	 * @param sPath
	 * @return
	 * @throws FileNotFoundException
	 */
	public int read(String sPath) throws FileNotFoundException {
		try {
			// Read the file
			// BufferedReader fr = new BufferedReader(new FileReader(
			// "//Users//andy//Documents//workspace//SSW555//bin//GU.txt"));

			BufferedReader fr = new BufferedReader(new FileReader(sPath));
			String str;

			str = fr.readLine();

			while (str != null) {
				// read each line and parse it immediately.
				parse(str);
				str = fr.readLine();
			}
			fr.close();
			return 1;
		} catch (Exception e) {
			System.out.print(e.toString());
			throw new java.io.FileNotFoundException();
			// return -1;
		}

	}

	public static void parse(String str) {
		Proj1 pro = new Proj1();
		String[] spli = str.split("\\s+");
		String Num = spli[0];
		String Tag = spli[1];

		System.out.println(str);
		System.out.println(Num);
		boolean Leag = pro.LeageTags.contains(Tag);

		// compare the Tag with legal tags.
		if (Leag) {
			System.out.println(Tag);
		} else {
			System.out.println("Invalid tag");
		}
	}

	// legal tags set.
	public Proj1() {
		LeageTags.add("INDI");
		LeageTags.add("NAME");
		LeageTags.add("SEX");
		LeageTags.add("BIRT");
		LeageTags.add("DEAT");
		LeageTags.add("FAMC");
		LeageTags.add("FAMS");
		LeageTags.add("FAM");
		LeageTags.add("MARR");
		LeageTags.add("HUSB");
		LeageTags.add("WIFE");
		LeageTags.add("CHIL");
		LeageTags.add("DIV");
		LeageTags.add("DATE");
		LeageTags.add("TRLR");
		LeageTags.add("NOTE");
	}

	private List<String> LeageTags = new ArrayList<String>();

}
