package com.procurandoape.place;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.procurandoape.user.City;
import com.procurandoape.user.User;

@Entity
@Table(name = "place_to_live")
public class PlaceToLive implements Serializable {

	private static final long serialVersionUID = -7746458801279299369L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
	@JoinColumn(name = "city_id")
	private City city;

	@Column(name = "neighborhood", length = 100)
	private String neighborhood;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public City getCity() {
		return city;
	}

	public User getUser() {
		return user;
	}

	public String getNeighborhood() {
		return neighborhood;
	}
}
