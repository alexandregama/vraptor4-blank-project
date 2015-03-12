package com.procurandoape.user;

import java.util.List;

import com.google.common.base.Optional;

public interface Users {

	List<User> getBestThreeUsersForHome();

	void save(User user);

	Optional<User> findBy(User user);

	boolean emailAlreadyExists(User user);

}
