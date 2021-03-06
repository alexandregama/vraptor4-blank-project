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
import com.procurandoape.room.PlacesToRental;
import com.procurandoape.user.User;
import com.procurandoape.user.Users;

@Controller
public class PlaceToRentalController {

	private Result result;

	private UserSession userSession;

	private Users users;

	private Cities cities;

	private Validator validator;

	private PlacesToRental placesToRental;

	@Inject
	public PlaceToRentalController(Result result, UserSession userSession,
			Users users, Cities cities, Validator validator, PlacesToRental placesToRental) {
		this.result = result;
		this.userSession = userSession;
		this.users = users;
		this.cities = cities;
		this.validator = validator;
		this.placesToRental = placesToRental;
	}

	@Deprecated //CDI Eyes only
	PlaceToRentalController() {
	}

	@BlockUnloggedUser
	@Get("/place-to-rental")
	public void placeToRental() {
		User loggedUser = userSession.getUser();
		result.include("user", users.findByUser(loggedUser));

		List<State> states = cities.getAllStates();
		result.include("states", states);
	}

	@Post("/place-to-rental")
	public void save(PlaceToRental placeToRental) {
		System.out.println(placeToRental);
		validator.validate(placeToRental);

		if (validator.hasErrors()) {
			result.include("placeToRental", placeToRental);
		}
		placesToRental.save(placeToRental);

		validator.onErrorRedirectTo(PlaceToRentalController.class).placeToRental();
	}

}
