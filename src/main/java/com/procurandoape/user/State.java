package com.procurandoape.user;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "state")
public class State implements Serializable {

	private static final long serialVersionUID = -2800904371869513010L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name", nullable = false, unique = true)
	@NotBlank
	private String name;

	@Column(name = "abbreviation", nullable = false, unique = true)
	@NotBlank
	private String abbreviation;

	@OneToMany(mappedBy = "state")
	private List<City> cities;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

}
