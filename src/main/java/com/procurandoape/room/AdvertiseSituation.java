package com.procurandoape.room;

import com.procurandoape.util.I18nMessageKey;

public enum AdvertiseSituation {

	RENTER_LIVING("renter.living"),
	RENTER_NOT_LIVING("renter.not.living"),
	OWNER_LIVING("owner.living"),
	OWNER_NOT_LIVING("owner.not.living");

	private String name;

	AdvertiseSituation(String name) {
		this.name = name;
	}

	public String getName() {
		return I18nMessageKey.getKey(this.name);
	}

}
