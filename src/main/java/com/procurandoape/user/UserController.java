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
import com.procurandoape.login.UserSession;

@Controller
public class UserController {

	private Validator validator;

	private Users users;

	private Cities cities;

	private Result result;

	private UserSession userSession;

	@Inject
	public UserController(Validator validator, Users users, Cities cities, Result result, UserSession userSession) {
		this.validator = validator;
		this.users = users;
		this.cities = cities;
		this.result = result;
		this.userSession = userSession;
	}

	@Deprecated //CDI Eyes only
	UserController() {
	}

	@Get("/signup")
	public void user() {
		result.include("states", cities.getAllStates());
	}

	@Get("/perfil")
	public void perfil() {
		User user = users.findById(userSession.getUser());
		result.include("user", user);
	}

	@Get("/place-to-rental")
	public void placeToRental() {

	}

	@Post("/user")
	public void create(User user) {
		validator.validate(user);
		validator.ensure(user.hasValidPasswordConfirmation(), new I18nMessage("user.password", "user.password.confirmation"));
		validator.addIf(users.emailAlreadyExists(user), new I18nMessage("user.email.exists", "user.signin.email.exists"));

		if (validator.hasErrors()) {
			List<City> citiesFromState = cities.getByStateAbbreviation(user.getCity().getStateAbbreviation());
			result.include("user", user);
			result.include("cities", citiesFromState);
		}
		validator.onErrorRedirectTo(UserController.class).user();

		users.save(user);
		userSession.add(user);
		result.redirectTo(HomeController.class).index();
	}

}
