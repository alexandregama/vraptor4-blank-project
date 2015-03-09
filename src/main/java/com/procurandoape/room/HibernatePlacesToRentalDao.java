package com.procurandoape.room;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class HibernatePlacesToRentalDao implements PlacesToRental {

	private EntityManager manager;

	@Inject
	public HibernatePlacesToRentalDao(EntityManager manager) {
		this.manager = manager;
	}

	HibernatePlacesToRentalDao() {
	}

	@Override
	public List<PlaceToRental> getPlacesToRentalForHome() {
		TypedQuery<PlaceToRental> query = manager.createQuery("select p from PlaceToRental p", PlaceToRental.class);
		query.setMaxResults(3);

		return query.getResultList();
	}

}
