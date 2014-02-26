/**
 * 
 */
package edu.stevens.cs555.entities;

public class ErrorOut {
	// type code for look up
	public String type;
	// true is alarm been trigered
	public boolean flag;
	// info for result output
	public String info;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean getFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
