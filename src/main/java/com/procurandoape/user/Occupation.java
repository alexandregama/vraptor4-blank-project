package com.procurandoape.user;

public enum Occupation {

	WORKER("placetorental.occupation.worker"),
	STUDENT("placetorental.occupation.student"),
	WORKER_STUDENT("placetorental.occupation.worker.student"),
	UNEMPLOYED("placetorental.occupation.worker.unemployed");

	private String name;

	Occupation(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
