package com.procurandoape.login;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;

import com.google.common.base.Optional;
import com.procurandoape.home.HomeController;
import com.procurandoape.interceptor.Authenticator;
import com.procurandoape.user.User;
import com.procurandoape.user.Users;

@Controller
public class LoginController {

	private Validator validator;

	private Result result;

	private Users users;

	private UserSession userSession;

	@Inject
	public LoginController(Validator validator, Result result, Users users, UserSession userSession) {
		this.validator = validator;
		this.result = result;
		this.users = users;
		this.userSession = userSession;
	}

	@Deprecated //CDI Eyes only
	LoginController() {
	}

	@Get("/login")
	public void show() {
	}

	@Get("/logout")
	public void logout() {
		userSession.logout();
		result.redirectTo(HomeController.class).index();
	}

	@Get("/retrieve-password")
	public void retrievePassword() {
	}

	@Authenticator
	@Get("/password")
	public void redefinePassword() {
	}

	@Post("/password/redefine")
	public void redefinePassword(Password password) {
		validator.validate(password);
		validator.onErrorRedirectTo(LoginController.class).redefinePassword();
	}

	@Post("/login")
	public void signin(User user) {
		if (user.hasEmptyCredentialsSignin()) {
			validator.add(new I18nMessage("signin.credentials", "user.signin.empty.credentials"));
			result.include("user", user);
		}

		Optional<User> userFound = users.findBy(user);
		if (userFound.isPresent()) {
			userSession.add(userFound.get());
			result.redirectTo(HomeController.class).index();
		} else {
			validator.add(new I18nMessage("signin.invalid", "user.signin.invalid.credentials"));
		}

		validator.onErrorRedirectTo(LoginController.class).show();
	}

}
