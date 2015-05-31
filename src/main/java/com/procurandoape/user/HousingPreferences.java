package com.procurandoape.user;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.procurandoape.room.PropertyType;
import com.procurandoape.room.ValidPropertyType;

@Embeddable
public class HousingPreferences {

	@OneToOne
	@JoinColumn(name = "preference_city_id")
	private City cityPreference;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "preference_property_type", length = 20)
	@ValidPropertyType
	private PropertyType propertyType;

	public City getCityPreference() {
		return cityPreference;
	}

	public void setCityPreference(City cityPreference) {
		this.cityPreference = cityPreference;
	}

	public PropertyType getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
	}

}
