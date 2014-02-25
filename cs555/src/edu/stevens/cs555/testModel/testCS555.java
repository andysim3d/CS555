/* Name: TestForDisplayError.java
 * Author: Pengfei Zhang
 * Date: 24/02/2014
 * 
 * Function: Test DisplayErrors method
 */

package edu.stevens.cs555.testModel;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.stevens.cs555.*;
import edu.stevens.cs555.display.Display;
import edu.stevens.cs555.entities.ErrorOut;
import edu.stevens.cs555.entities.Individual;

public class testCS555 {
	
	
	@BeforeClass
	public static void testSetup(){
		
	}
	@AfterClass
	public static void testCleanup(){
		
	}
	

	
	@Test
	public void testDisplay() throws IOException {
		
		ErrorOut [] out =  new ErrorOut[13];
		
		for(int i = 0; i < 13; i ++){
			out[i] = new ErrorOut();
			out[i].flag = true;
			out[i].type = String.valueOf(i);
			out[i].info = String.valueOf(i);
		}
		
		assertTrue((Display.DisplayError(out[1])).toString().equals("Wrong sex for role 1"));
		assertTrue((Display.DisplayError(out[2])).toString().equals("Be parient to parient 2"));
		assertTrue((Display.DisplayError(out[3])).toString().equals("Div date earlier than marriage 3"));
		assertTrue((Display.DisplayError(out[4])).toString().equals("Married to a dead People 4"));
		assertTrue((Display.DisplayError(out[5])).toString().equals("Chindren is older than parents 5"));
		assertTrue((Display.DisplayError(out[6])).toString().equals("Death eariler than birth 6"));
		assertTrue((Display.DisplayError(out[7])).toString().equals("Marry to oneself 7"));
		assertTrue((Display.DisplayError(out[8])).toString().equals("Marry with parents 8"));
		assertTrue((Display.DisplayError(out[9])).toString().equals("Has 2 or more biological father or mothers 9"));
		assertTrue((Display.DisplayError(out[10])).toString().equals("He or she is bigamy 10"));
		assertTrue((Display.DisplayError(out[11])).toString().equals("He or she has a abnormal long life 11"));
		assertTrue((Display.DisplayError(out[12])).toString().equals("He or she marrys to a sibling 12"));
			
		
	}
	
	

}
