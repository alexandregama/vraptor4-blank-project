package com.procurandoape.user;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;

import com.google.common.base.Optional;
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

	@Get("/usuario/cadastro")
	public void signup() {
		result.include("states", cities.getAllStates());
	}

	@Get("/usuario/perfil")
	public void perfil() {
		User user = users.findByUser(userSession.getUser());
		result.include("user", user);
	}

	@Get("/perfil/{id}")
	public void perfil(Long id) {
		Optional<User> userOptional = users.findById(id);
		if (userOptional.isPresent()) {
			result.include("user", userOptional.get());
		} else {
			result.redirectTo(HomeController.class).index();
		}
	}

	@Post("/user")
	public void create(User user) {
		validator.validate(user);
		validator.ensure(user.hasValidPasswordConfirmation(), new I18nMessage("user.password", "user.password.confirmation"));
		validator.addIf(users.emailAlreadyExists(user), new I18nMessage("user.email.exists", "user.signin.email.exists"));

		if (validator.hasErrors()) {
			Optional<List<City>> citiesFromStateOptional = cities.getByStateAbbreviation(user.getCity().getStateAbbreviation());
			if (citiesFromStateOptional.isPresent()) {
				result.include("cities", citiesFromStateOptional.get());
			} else {
				result.include("states", cities.getAllStates());
			}
			result.include("user", user);
		}
		validator.onErrorRedirectTo(UserController.class).signup();

		users.save(user);
		userSession.add(user);
		result.redirectTo(HomeController.class).index();
	}

}
