package com.procurandoape.place;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

import com.procurandoape.home.Cities;
import com.procurandoape.home.State;
import com.procurandoape.interceptor.BlockUnloggedUser;
import com.procurandoape.login.UserSession;
import com.procurandoape.room.PlaceToRental;
import com.procurandoape.user.User;
import com.procurandoape.user.Users;

@Controller
public class PlaceToRentalController {

	private Result result;

	private UserSession userSession;

	private Users users;

	private Cities cities;

	private Validator validator;

	@Inject
	public PlaceToRentalController(Result result, UserSession userSession,
			Users users, Cities cities, Validator validator) {
		this.result = result;
		this.userSession = userSession;
		this.users = users;
		this.cities = cities;
		this.validator = validator;
	}

	@Deprecated //CDI Eyes only
	PlaceToRentalController() {
	}

	@BlockUnloggedUser
	@Get("/place-to-rental")
	public void placeToRental() {
		User loggedUser = userSession.getUser();
		result.include("user", users.findById(loggedUser));

		List<State> states = cities.getAllStates();
		result.include("states", states);
	}

	@Post("/place-to-rental")
	public void save(PlaceToRental placeToRental) {
		validator.validate(placeToRental);

		validator.onErrorRedirectTo(PlaceToRentalController.class).placeToRental();
		System.out.println(placeToRental);
	}

}
