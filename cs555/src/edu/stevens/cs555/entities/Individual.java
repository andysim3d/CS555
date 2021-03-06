package edu.stevens.cs555.entities;

import java.util.ArrayList;
import java.util.Date;

public class Individual extends GedcomNode {

	private String id;
	private String name;
	private String sex;
	private Date birthday;
	private Date deathday;
	//used to check whether he has the record of born and death
	private boolean hasBorn;
	private boolean hasDead;

	private ArrayList<String> famc = new ArrayList<String>();
	private ArrayList<String> fams = new ArrayList<String>();

	public Individual(String id) {
		this.id = id;
		this.hasBorn = false;
		this.hasDead = false;

	}

	public Individual() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String output) {
		this.sex = output;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.hasBorn = true;
		this.birthday = birthday;
	}

	public Date getDeathday() {
		return deathday;
	}

	public void setDeathday(Date deathday) {
		this.hasDead = true;
		this.deathday = deathday;
	}

	public ArrayList<String> getFamc() {
		return famc;
	}

	public void setFamc(String famc) {
		this.famc.add(famc);
	}

	public ArrayList<String> getFams() {
		return fams;
	}

	public void setFams(String fams) {
		this.fams.add(fams);
	}
	
	public boolean isDead(){
		return this.hasDead;
	}
	
	public boolean isBorn(){
		return this.hasBorn;
	}
}
