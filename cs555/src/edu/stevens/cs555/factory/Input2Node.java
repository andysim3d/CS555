/* Name: Input2Node.java
 * Author: Gao Xing
 * Date: 24/02/2014
 * 
 * Function:Singlton Patten: getInstance than use getIndNode
 */
package edu.stevens.cs555.factory;

import java.util.Hashtable;

import edu.stevens.cs555.entities.*;

public class Input2Node {

	private static Input2Node instance = null;

	private Input2Node() {

	}

	public static Input2Node getInstance(String path) {
		if (instance == null) {
			instance = new Input2Node();
			instance.convertNode(path);
		}
		return instance;
	}

	private Hashtable<String, Individual> indNode = null;
	private Hashtable<String, Family> fmNode = null;

	public void convertNode(String path) {
		//Fill in two hashtable
	}

	public Hashtable<String, Individual> getIndNode() {
		return this.indNode;
	}

	public Hashtable<String, Family> getFmNode() {
		return this.fmNode;
	}

}
