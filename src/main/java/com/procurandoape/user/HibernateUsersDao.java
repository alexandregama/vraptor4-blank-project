package com.procurandoape.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.procurandoape.infra.JPAUtil;

public class HibernateUsersDao implements Users {

	@Override
	public List<User> bestThreeUsersForHome() {
		EntityManager manager = new JPAUtil().getEntityManager();
		TypedQuery<User> query = manager.createQuery("select u from User u", User.class);
		query.setMaxResults(4);

		return query.getResultList();
	}

}
