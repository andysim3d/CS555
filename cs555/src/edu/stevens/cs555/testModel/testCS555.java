/* Name: TestForDisplayError.java
 * Author: Pengfei Zhang
 * Date: 22/02/2014
 * 
 * Function: Test DisplayErrors method
 */

package edu.stevens.cs555.testModel;

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
import edu.stevens.cs555.validation.AbnormalLongLife;
import edu.stevens.cs555.validation.BeParentToParent;
import edu.stevens.cs555.validation.CheckBigamy;
import edu.stevens.cs555.validation.CheckDBB;
import edu.stevens.cs555.validation.CheckMTO;
import edu.stevens.cs555.validation.CheckPOC;
import edu.stevens.cs555.validation.DIVDateCheck;
import edu.stevens.cs555.validation.MarWithDead;
import edu.stevens.cs555.validation.MarriageAncestor;
import edu.stevens.cs555.validation.NumberOfFamily;
import edu.stevens.cs555.validation.SiblingBirthCheck;
import edu.stevens.cs555.validation.WrongSex;
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
		String str = "/Users/andy/git/CS555.stevens/cs555/src/edu/stevens/cs555/testModel/P2P.txt";
		Input2Node test;
		Hashtable<String, Individual> indNode = null;
		Hashtable<String, Family> fmNode = null;
		try {
			test = Input2Node.getInstance(str);
			indNode = test.getIndNode();
			fmNode = test.getFmNode();
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertTrue(indNode.get("I2004").getId().equals("I2004"));
		assertTrue(fmNode.get("F202").getId().equals("F202"));
	}

	@Test 
	public void testNumberOfFamily(){
		Family fm = new Family();
		fm.setId("I1");
		fm.setChil("Tom");
		fm.setChil("Jerry");
		Hashtable<String, Family> fmNode = new Hashtable<String, Family>();
		fmNode.put(fm.getId(), fm);
		assertTrue(NumberOfFamily.numberOutInt(fmNode)==4);
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
		ArrayList<ErrorOut> errors = WrongSex.sexCheck(fmNode, indNode);
		assertTrue(errors.size()==2);
	}
	
	
	//Test of Parent to parent
	@Test
	public void testBeParentToParent(){
		String str = "/Users/andy/git/CS555.stevens/cs555/src/edu/stevens/cs555/testModel/P2P.txt";
		Input2Node test;
		Hashtable<String, Individual> indNode = null;
		Hashtable<String, Family> fmNode = null;
		try {
			test = Input2Node.getInstance(str);
			indNode = test.getIndNode();
			fmNode = test.getFmNode();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ArrayList<ErrorOut> err = BeParentToParent.ParentToParentCheck(fmNode, indNode);
		
		for(ErrorOut a : err){
			//System.out.println(a.info);
			assertTrue(a.info.equals("Indvidual I2004is his own grandchild")||
					a.info.equals("Indvidual I2005is his own grandchild"));
		}
	}
	
	//Test of DIV date
	@Test
	public void testDIVDate()
	{
		String str = "/Users/andy/git/CS555.stevens/cs555/src/edu/stevens/cs555/testModel/P2P.txt";
		Hashtable<String, Family> fmNode = null;
		try{
			Input2Node test = Input2Node.getInstance(str);
			fmNode = test.getFmNode();
			ArrayList<ErrorOut> error = DIVDateCheck.DateCheck(fmNode);
			
			for(ErrorOut a : error){
				//System.out.println(a.info);
				assertTrue(a.info.equals("Family(F104)marry date is after Divorce date"));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMarrWithDead()
	{
		String str = "/Users/andy/git/CS555.stevens/cs555/src/edu/stevens/cs555/testModel/P2P.txt";
		Hashtable<String, Family> fmNode = null;
		Hashtable<String, Individual> indNode = null;
		
		try{
			Input2Node test = Input2Node.getInstance(str);
			fmNode = test.getFmNode();
			indNode = test.getIndNode();
			ArrayList<ErrorOut> error = MarWithDead.MarryCheck(fmNode, indNode);
			
			for(ErrorOut a : error){
				//System.out.println(a.info);
				assertTrue(a.info.equals("Inividual(I2007)marries to a dead people(I2008)"));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	//Test of POC Check
	@Test
	public void testCheckPOC()
	{
		String str = "/Users/andy/git/CS555.stevens/cs555/src/edu/stevens/cs555/testModel/P2P.txt";
		Hashtable<String, Family> fmNode = null;
		Hashtable<String, Individual> indNode = null;
		
		try{
			Input2Node test = Input2Node.getInstance(str);
			fmNode = test.getFmNode();
			indNode = test.getIndNode();
			ArrayList<ErrorOut> error = CheckPOC.pocCheck(fmNode, indNode);
			
			assertTrue(error.get(0).info.equals("Family(F202)'s parent is younger than his child"));
			assertTrue(error.get(2).info.equals("Family(F252)'s parent is yoinger than his child"));
			assertTrue(error.get(3).info.equals("Family(F301)'s parent is younger than his child"));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	//Test of DBB Check
	@Test
	public void testCheckDBB()
	{
		String str = "/Users/andy/git/CS555/cs555/src/edu/stevens/cs555/testModel/P2P.txt";
		Hashtable<String, Individual> indNode = null;
		
		try{
			Input2Node test = Input2Node.getInstance(str);
			indNode = test.getIndNode();
			ArrayList<ErrorOut> error = CheckDBB.dbbCheck(indNode);
			
			for(ErrorOut a : error){
				//System.out.println(a.info);
				assertTrue(a.info.equals("Individual(I1010)\'s deathday is before his birthday"));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCheckBigamy()
	{
		String str = "/Users/andy/git/CS555.stevens/cs555/src/edu/stevens/cs555/testModel/P2P.txt";
		Hashtable<String, Individual> indNode = null;
		Hashtable<String, Family> fmNode = null;
		boolean out = false;
		try{
			Input2Node test = Input2Node.getInstance(str);
			indNode = test.getIndNode();
			fmNode = test.getFmNode();
			
			ArrayList<ErrorOut> error = CheckBigamy.CheckBigmay(fmNode, indNode);//.dbbCheck(indNode);
			
			for(ErrorOut a : error){
				//System.out.println(a.info);
				if (a.info.equals("IndividalI3005is a bigamy")) {
					out = true;
				}
				//assertTrue(a.info.equals("Individual(I1010)\'s deathday is before his birthday"));
			}
			assertTrue(out);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	
	
	//Test of MTO Check
	@Test
	public void testCheckMTO()
	{
		String str = "/Users/andy/git/CS555.stevens/cs555/src/edu/stevens/cs555/testModel/P2P.txt";
		Hashtable<String, Family> fmNode = null;
		Hashtable<String, Individual> indNode = null;
		
		try{
			Input2Node test = Input2Node.getInstance(str);
			fmNode = test.getFmNode();
			indNode = test.getIndNode();
			ArrayList<ErrorOut> error = CheckMTO.mtoCheck(fmNode, indNode);
			
			for(ErrorOut a : error){
				//System.out.println(a.info);
				assertTrue(a.info.equals("Family(F302)'s husband and wife are same person"));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	

	@Test
	public void testAbnormalLongLife(){
		try{
			String str = "/Users/andy/git/CS555.stevens/cs555/src/edu/stevens/cs555/testModel/P2P.txt";
			Hashtable<String, Individual> indNode = null;
			Input2Node test = Input2Node.getInstance(str);
			indNode = test.getIndNode();
			ArrayList<ErrorOut> errors = AbnormalLongLife.checkIndi(indNode);
			boolean out = false;
			for(ErrorOut a : errors){
				//System.out.println(a.info);
				if(a.info.equals("Indvidual I4008's age is greater than 120")){
					out = true;
				}
			}
			 assertTrue(out);
			}catch(Exception e){
				e.printStackTrace();
			}
	}

	@Test
	public void testMarriageAncestor(){
		try{
			String str = "/Users/andy/git/CS555.stevens/cs555/src/edu/stevens/cs555/testModel/P2P.txt";
			Hashtable<String, Individual> indNode = null;
			Hashtable<String, Family> fmNode = null;
			Input2Node test = Input2Node.getInstance(str);
			indNode = test.getIndNode();
			fmNode = test.getFmNode();
			ArrayList<ErrorOut> errors = MarriageAncestor.checkIndi(fmNode, indNode);
			boolean out= false;
			for(ErrorOut a : errors){
				if(a.info.equals("Individual (I4007) marry with parent")){
					out = true;
				};	
			}
			assertTrue(out);
			}catch(Exception e){
				e.printStackTrace();
			}
	}
	
	@Test
	public void testSibilingBirthDate(){

		try{
			String str = "/Users/andy/git/CS555.stevens/cs555/src/edu/stevens/cs555/testModel/P2P.txt";
			Hashtable<String, Individual> indNode = null;
			Hashtable<String, Family> fmNode = null;
			Input2Node test = Input2Node.getInstance(str);
			indNode = test.getIndNode();
			fmNode = test.getFmNode();
			ArrayList<ErrorOut> errors = SiblingBirthCheck.SBCheck(fmNode, indNode);//(fmNode, indNode);
			boolean out= false;
			for(ErrorOut a : errors){
				System.out.println(a.info);
				if(a.info.equals("I3003 and I3010 are have a abnormal birth date")){
					out = true;
				};	
			}
			assertTrue(out);
			}catch(Exception e){
				e.printStackTrace();
			}
	}
	
}



