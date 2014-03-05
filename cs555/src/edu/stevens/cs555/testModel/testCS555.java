/* Name: TestForDisplayError.java
 * Author: Pengfei Zhang
 * Date: 22/02/2014
 * 
 * Function: Test DisplayErrors method
 */

package edu.stevens.cs555.testModel;

import static org.junit.Assert.assertTrue;


import static org.junit.Assert.*;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.stevens.cs555.display.Display;
import edu.stevens.cs555.entities.ErrorOut;
import edu.stevens.cs555.entities.Family;
import edu.stevens.cs555.entities.Individual;
import edu.stevens.cs555.factory.Input2Node;
import edu.stevens.cs555.validation.numberOfFamily;
import edu.stevens.cs555.validation.wrongSex;

public class testCS555 {

	@BeforeClass
	public static void testSetup() {

	}

	@AfterClass
	public static void testCleanup() {

	}

	@Test
	public void testDisplay() throws IOException {

		ErrorOut[] out = new ErrorOut[13];

		for (int i = 0; i < 13; i++) {
			out[i] = new ErrorOut();
			out[i].flag = true;
			out[i].type = String.valueOf(i);
			out[i].info = String.valueOf(i);
		}

		assertTrue((Display.DisplayError(out[1])).toString().equals(
				"Wrong sex for role 1"));
		assertTrue((Display.DisplayError(out[2])).toString().equals(
				"Be parient to parient 2"));
		assertTrue((Display.DisplayError(out[3])).toString().equals(
				"Div date earlier than marriage 3"));
		assertTrue((Display.DisplayError(out[4])).toString().equals(
				"Married to a dead People 4"));
		assertTrue((Display.DisplayError(out[5])).toString().equals(
				"Chindren is older than parents 5"));
		assertTrue((Display.DisplayError(out[6])).toString().equals(
				"Death eariler than birth 6"));
		assertTrue((Display.DisplayError(out[7])).toString().equals(
				"Marry to oneself 7"));
		assertTrue((Display.DisplayError(out[8])).toString().equals(
				"Marry with parents 8"));
		assertTrue((Display.DisplayError(out[9])).toString().equals(
				"Has 2 or more biological father or mothers 9"));
		assertTrue((Display.DisplayError(out[10])).toString().equals(
				"He or she is bigamy 10"));
		assertTrue((Display.DisplayError(out[11])).toString().equals(
				"He or she has a abnormal long life 11"));
		assertTrue((Display.DisplayError(out[12])).toString().equals(
				"He or she marrys to a sibling 12"));

	}

	@Test
	public void testInput2Node() {
		String str = "/Users/andy/git/CS555.stevens/cs555/src/edu/stevens/cs555/testModel/testFile.txt";
		Input2Node test;
		Hashtable<String, Individual> indNode = null;
		Hashtable<String, Family> fmNode = null;
		try {
			test = Input2Node.getInstance(str);
			indNode = test.getIndNode();
			fmNode = test.getFmNode();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertTrue(indNode.get("I1").getId().equals("I1"));
		assertTrue(fmNode.get("F1").getId().equals("F1"));
	}

	@Test 
	public void testNumberOfFamily(){
		Family fm = new Family();
		fm.setId("I1");
		fm.setChil("Tom");
		fm.setChil("Jerry");
		Hashtable<String, Family> fmNode = new Hashtable<String, Family>();
		fmNode.put(fm.getId(), fm);
		assertTrue(numberOfFamily.numberOutInt(fmNode)==4);
		
	}
	
	@Test
	public void testWrongSex(){
		Family fm = new Family();
		Individual husb = new Individual();
		Individual wife = new Individual();
		husb.setId("I1");
		wife.setId("I2");
		husb.setSex("F");
		wife.setSex("M");
		fm.setHusb("I1");
		fm.setWife("I2");
		fm.setId("F1");
		Hashtable<String, Family> fmNode = new Hashtable<String, Family>();
		fmNode.put(fm.getId(), fm);
		Hashtable<String, Individual> indNode = new Hashtable<String, Individual> ();
		indNode.put(husb.getId(), husb);
		indNode.put(wife.getId(), wife);
		ArrayList<ErrorOut> errors = wrongSex.sexCheck(fmNode, indNode);
		assertTrue(errors.size()==2);
	}
	


}
