package com.procurandoape.user;

import com.procurandoape.util.I18nMessageKey;

public enum GenderOrientation {

	GAY("user.gender.orientation.gay"),
	BISSEXUAL("user.gender.orientation.bissexual"),
	HETEROSEXUAL("user.gender.orientation.heterosexual"),
	LESBIAN("user.gender.orientation.lesbian");

	private String name;

	GenderOrientation(String name) {
		this.name = name;
	}

	public String getName() {
		return I18nMessageKey.getKey(this.name);
	}
}
