package com.procurandoape.place;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "zipcode")
public class Zipcode implements Serializable {

	private static final long serialVersionUID = 8059953831875294342L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "value", length = 8, nullable = false)
	private String value;

	@Column(name = "address", length = 150, nullable = false)
	private String address;

	@Column(name = "neighborhood", length = 100, nullable = false)
	private String neighborhood;

	@Column(name = "city", length = 100, nullable = false)
	private String city;

	@Column(name = "state", length = 50, nullable = false)
	private String state;

	@Column(name = "state_abbreviation", length = 2, nullable = false, columnDefinition = "char(2)")
	private String stateAbbreviation;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public String getValue() {
		return value;
	}

	public String getAddress() {
		return address;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getStateAbbreviation() {
		return stateAbbreviation;
	}

}
