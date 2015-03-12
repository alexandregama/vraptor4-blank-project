package com.procurandoape.user;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;

import com.procurandoape.home.Cities;
import com.procurandoape.home.HomeController;

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
		validator.validate(user);
		validator.ensure(user.hasValidPasswordConfirmation(), new I18nMessage("password", "user.password.confirmation"));
		if (validator.hasErrors()) {
			List<City> citiesFromState = cities.getByStateAbbreviation(user.getCity().getStateAbbreviation());
			result.include("user", user);
			result.include("cities", citiesFromState);
		}
		validator.onErrorRedirectTo(UserController.class).user();

		users.save(user);
		result.redirectTo(HomeController.class).index();
	}

}
