package com.procurandoape.home;

public class State {

	private String name;

	private String abbreviation;

	public State(String name, String abbreviation) {
		this.name = name;
		this.abbreviation = abbreviation;
	}

	public String getName() {
		return name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	@Override
	public String toString() {
		return "State [name=" + name + ", abbreviation=" + abbreviation + "]";
	}

}
