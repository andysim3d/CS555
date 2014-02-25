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
import edu.stevens.cs555.entities.Individual;

public class TestForDisplayError {
	


	
	@BeforeClass
	public static void testSetup(){
		
	}
	@AfterClass
	public static void testCleanup(){
		
	}
	

	
	@Test
	public void test() throws IOException {
		Individual indi1 = new Individual("@0001@");
		Individual indi2 = new Individual("@0002@");
		
		assertEquals("@0001@ Wrong sex for role!",(Display.DisplayError(1,indi1)).toString());
		
	}
	
	

}
