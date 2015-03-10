package com.procurandoape.user;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class UserController {

	private Validator validator;

	private Users users;

	@Inject
	public UserController(Validator validator, Users users) {
		this.validator = validator;
		this.users = users;
	}

	@Deprecated //CDI Eyes only
	UserController() {
	}

	@Get("/user")
	public void user() {
	}

	@Post("/user")
	public void create(User user) {
		System.out.println(user);
		validator.onErrorRedirectTo(UserController.class).user();

		users.save(user);
	}

}
