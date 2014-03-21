package edu.stevens.cs555.entities;

import java.util.ArrayList;
import java.util.Date;

public class Family extends GedcomNode {

	private String id;
	private String husb;
	private String wife;
	private ArrayList<String> chil = new ArrayList<String>();
	
	private boolean marr = false;
	private boolean b_marr_date = false;
	private boolean div = false;
	private boolean b_div_date = false;
	private Date div_date;
	private Date marr_date;

	public Family(String id) {
		this.id = id;
	}

	public Family() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHusb() {
		return husb;
	}

	public void setHusb(String husb) {
		this.husb = husb;
	}

	public String getWife() {
		return wife;
	}

	public void setWife(String wife) {
		this.wife = wife;
	}

	public ArrayList<String> getChil() {
		return chil;
	}

	public void setChil(String chil) {
		this.chil.add(chil);
	}

	public boolean isMarr() {
		return marr;
	}

	public void setMarr(boolean marr) {
		this.marr = marr;
	}

	public boolean isDiv() {
		return div;
	}

	public void setDiv(boolean div) {
		this.div = div;
	}

	public Date getDiv_date() {
		return div_date;
	}

	public void setDiv_date(Date div_date) {
		this.b_div_date = true;
		this.div_date = div_date;
	}

	public Date getMarr_date() {
		return marr_date;
	}

	public void setMarr_date(Date marr) {
		this.b_marr_date = true;
		this.marr_date = marr;
	}
	
	public boolean getMarr_date_aval(){
		return this.b_marr_date;
	}
	
	public boolean getDiv_date_aval(){
		return this.b_div_date;
	}

}
