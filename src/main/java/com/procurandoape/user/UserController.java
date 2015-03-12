package com.procurandoape.user;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

import com.procurandoape.home.Cities;

@Controller
public class UserController {

	private Validator validator;

	private Users users;

	private Cities cities;

	private Result result;

	@Inject
	public UserController(Validator validator, Users users, Cities cities, Result result) {
		this.validator = validator;
		this.users = users;
		this.cities = cities;
		this.result = result;
	}

	@Deprecated //CDI Eyes only
	UserController() {
	}

	@Get("/user")
	public void user() {
		result.include("states", cities.getAllStates());
	}

	@Post("/user")
	public void create(User user) {
		System.out.println(user);
		validator.onErrorRedirectTo(UserController.class).user();

		users.save(user);
	}

}
