package com.procurandoape.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "city")
public class City implements Serializable {

	private static final long serialVersionUID = 3435985049010242796L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name", length = 100, nullable = false)
	@NotBlank
	private String name;

	@Column(name = "state", length = 100, nullable = false)
	@NotBlank
	private String state;

	@Column(name = "state_abbreviation", nullable = false, columnDefinition = "char(2)")
	@NotBlank
	private String stateAbbreviation;

	@Column(name = "district", length = 100, nullable = false)
	private String district;

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", state=" + state
				+ ", stateAbbreviation=" + stateAbbreviation + ", district="
				+ district + "]";
	}

	public String getName() {
		return name;
	}

	public String getState() {
		return state;
	}

	public String getStateAbbreviation() {
		return stateAbbreviation;
	}

	public String getDistrict() {
		return district;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

}
