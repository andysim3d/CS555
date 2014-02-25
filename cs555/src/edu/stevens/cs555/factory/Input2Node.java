/* Name: Input2Node.java
 * Author: Gao Xing
 * Date: 
 * 
 * Function: getInstance than use get
 */
package edu.stevens.cs555.factory;

import java.util.Hashtable;

import edu.stevens.cs555.entities.*;

public class Input2Node {

	private static Input2Node instance = null;

	private Input2Node() {

	}

	public Input2Node getInstance() {
		if (instance == null) {
			instance = new Input2Node();
		}
		return instance;
	}

	private Hashtable<String, Individual> indNode = null;
	private Hashtable<String, Family> fmNode = null;

	public static void convertNode(String path) {

	}

	public Hashtable<String, Individual> getIndNode() {
		return this.indNode;
	}

	public Hashtable<String, Family> getfmNode() {
		return this.fmNode;
	}

}
