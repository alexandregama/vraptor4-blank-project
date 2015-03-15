package com.procurandoape.user;

import java.util.List;

import com.google.common.base.Optional;
import com.procurandoape.login.Password;

public interface Users {

	List<User> getBestThreeUsersForHome();

	void save(User user);

	Optional<User> findBy(User user);

	boolean emailAlreadyExists(User user);

	void updatePassword(User user, Password password);

	User findById(User user);

}
