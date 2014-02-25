/* Name: Display.java
 * Author: Pengfei Zhang
 * Date: 24/02/2014
 * 
 * Function: Display Errors
 */


package edu.stevens.cs555.display;

import edu.stevens.cs555.entities.ErrorOut;

public class Display {

	static public String DisplayError( ErrorOut out ){
		if(out.flag == false)
			return "";
			
		String Error = "";
		int ErrorCode = Integer.parseInt(out.type);
		switch(ErrorCode)
		{
		case 1:
			Error = "Wrong sex for role";
			break;
		case 2:
			Error = "Be parient to parient";
			break;
		case 3:
			Error = "Div date earlier than marriage";
			break;
		case 4:
			Error = "Married to a dead People";
			break;
		case 5:
			Error = "Chindren is older than parents";
			break;
		case 6:
			Error = "Death eariler than birth";
			break;
		case 7:
			Error = "Marry to oneself";
			break;
		case 8:
			Error = "Marry with parents";
			break;
		case 9:
			Error = "Has 2 or more biological father or mothers";
			break;
		case 10:
			Error = "He or she is bigamy";
			break;
		case 11:
			Error = "He or she has a abnormal long life";
			break;
		case 12:
			Error = "He or she marrys to a sibling";
			break;
			default:
				break;
		}
		
		System.out.println(Error +" " + out.info);
		//System.out.print(indi.getId()+ " " + Error);
		return (Error +" " + out.info);
	}
}


