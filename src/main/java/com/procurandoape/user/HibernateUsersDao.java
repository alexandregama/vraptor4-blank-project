package com.procurandoape.user;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.google.common.base.Optional;

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

	@Override
	public void save(User user) {
		manager.getTransaction().begin();
		manager.persist(user);
		manager.getTransaction().commit();
	}

	@Override
	public Optional<User> findBy(User user) {
		String sql = "select u from User u where u.email = :email and u.password = :password";
		TypedQuery<User> query = manager.createQuery(sql, User.class);
		query.setParameter("email", user.getEmail());
		query.setParameter("password", user.getPassword());
		try {
			User userFound = query.getSingleResult();
			return Optional.of(userFound);
		} catch (NoResultException e) {
			return Optional.absent();
		}
	}

}
