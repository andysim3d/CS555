package edu.stevens.cs555.entities;

import java.util.ArrayList;
import java.util.Date;

public class Family extends GedcomNode{

	private String id;
	private String husb;
	private String wife;
	private ArrayList<String> chil;
	private boolean marr;
	private boolean div;
	private Date div_date;
	
	public Family(String id){
		this.id = id;
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
	
	public void setChil(ArrayList<String> chil) {
		this.chil = chil;
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
		this.div_date = div_date;
	}
	
	
}
