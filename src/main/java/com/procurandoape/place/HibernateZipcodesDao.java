package com.procurandoape.place;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.google.common.base.Optional;

public class HibernateZipcodesDao implements Zipcodes {

	private EntityManager manager;

	@Inject
	public HibernateZipcodesDao(EntityManager manager) {
		this.manager = manager;
	}

	@Deprecated //CDI Eyes only
	HibernateZipcodesDao() {
	}

	@Override
	public Optional<Zipcode> findByZipcodeNumber(String zipcodeValue) {
		String sql = "select z from Zipcode as z where z.value = :value";
		TypedQuery<Zipcode> query = manager.createQuery(sql, Zipcode.class);
		query.setParameter("value", zipcodeValue);
		try {
			Zipcode zipcode = query.getSingleResult();
			return Optional.of(zipcode);
		} catch(NoResultException e) {
			return Optional.absent();
		}
	}

}
