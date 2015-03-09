package com.procurandoape.user;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class HibernateUsersDao implements Users {

	private EntityManager manager;

	@Inject
	public HibernateUsersDao(EntityManager manager) {
		this.manager = manager;
	}

	HibernateUsersDao() {
	}

	@Override
	public List<User> getBestThreeUsersForHome() {
		TypedQuery<User> query = manager.createQuery("select u from User u", User.class);
		query.setMaxResults(4);

		return query.getResultList();
	}

}
