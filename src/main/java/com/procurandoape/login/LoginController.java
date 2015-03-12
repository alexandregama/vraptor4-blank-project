package com.procurandoape.login;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;

import com.procurandoape.user.User;

@Controller
public class LoginController {

	private Validator validator;

	private Result result;

	@Inject
	public LoginController(Validator validator, Result result) {
		this.validator = validator;
		this.result = result;
	}

	@Deprecated //CDI Eyes only
	LoginController() {
	}

	@Get("/login")
	public void show() {
	}

	@Get("/retrieve-password")
	public void retrievePassword() {
	}

	@Post("/login")
	public void signin(User user) {
		if (user.hasEmptyCredentialsSignin()) {
			validator.add(new I18nMessage("signin.credentials", "user.signin.empty.credentials"));
			result.include("user", user);
		}

		validator.onErrorRedirectTo(LoginController.class).show();
	}

}
