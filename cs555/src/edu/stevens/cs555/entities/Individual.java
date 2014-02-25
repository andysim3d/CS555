package edu.stevens.cs555.entities;

import java.util.ArrayList;
import java.util.Date;

enum Sex {
	  male, female;
}

public class Individual {

	private String id;
	private String name;
	private Sex sex;
	private Date birthday;
	private Date deathday;
	
	private ArrayList<Integer> famc;
	private ArrayList<Integer> fams;
	
	
	public Individual(String id ){
		this.id = id;
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

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getDeathday() {
		return deathday;
	}

	public void setDeathday(Date deathday) {
		this.deathday = deathday;
	}
	
	public ArrayList<Integer> getFamc() {
		return famc;
	}

	public void setFamc(ArrayList<Integer> famc) {
		this.famc = famc;
	}

	public ArrayList<Integer> getFams() {
		return fams;
	}

	public void setFams(ArrayList<Integer> fams) {
		this.fams = fams;
	}
}
