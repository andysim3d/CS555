package edu.stevens.cs555.entities;

public abstract class GedcomNode {
	private String id;

	protected String getId() {
		return id;
	}

	protected void setId(String id) {
		this.id = id;
	}
}
