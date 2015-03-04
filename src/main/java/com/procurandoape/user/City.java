package com.procurandoape.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "city")
public class City implements Serializable {

	private static final long serialVersionUID = 3435985049010242796L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name", nullable = false)
	@NotBlank
	private String name;

	@ManyToOne
	@JoinColumns(@JoinColumn(name = "state_id"))
	private State state;

	public State getState() {
		return state;
	}

	public String getName() {
		return name;
	}

}
