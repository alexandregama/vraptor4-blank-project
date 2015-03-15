package com.procurandoape.user;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.google.common.base.Optional;
import com.procurandoape.login.Password;

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

	@Override
	public boolean emailAlreadyExists(User user) {
		String sql = "select u from User u where u.email = :email";
		TypedQuery<User> query = manager.createQuery(sql, User.class);
		query.setParameter("email", user.getEmail());

		try {
			return query.getSingleResult() != null;
		} catch (NoResultException e) {
			return false;
		}
	}

	@Override
	public void updatePassword(User user, Password password) {
		User userToUpdate = manager.find(User.class, user.getId());
		userToUpdate.setPassword(password.getValue());
		manager.getTransaction().begin();
		manager.merge(userToUpdate);
		manager.getTransaction().commit();
	}

}
