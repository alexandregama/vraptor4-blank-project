package com.procurandoape.login;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.procurandoape.user.User;

@SessionScoped
@Named
public class UserSession implements Serializable {

	private static final long serialVersionUID = 7202542356342170351L;

	private User user;

	public void add(User user) {
		this.user = user;
	}

	public boolean isUserLogged() {
		return this.user != null;
	}

	public void logout() {
		this.user = null;
	}

	public User getUser() {
		return user;
	}

}
