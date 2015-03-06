package com.procurandoape.room;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.procurandoape.infra.JPAUtil;

public class HibernatePlacesToRentalDao implements PlacesToRental {

	@Override
	public List<PlaceToRental> getPlacesToRentalForHome() {
		EntityManager manager = new JPAUtil().getEntityManager();
		TypedQuery<PlaceToRental> query = manager.createQuery("select p from PlaceToRental p", PlaceToRental.class);
		query.setMaxResults(3);

		return query.getResultList();
	}

}
