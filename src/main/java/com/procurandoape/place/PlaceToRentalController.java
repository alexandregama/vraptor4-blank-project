package com.procurandoape.place;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;

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

	@Inject
	public PlaceToRentalController(Result result, UserSession userSession,
			Users users) {
		this.result = result;
		this.userSession = userSession;
		this.users = users;
	}

	@Deprecated //CDI Eyes only
	PlaceToRentalController() {
	}

	@BlockUnloggedUser
	@Get("/place-to-rental")
	public void placeToRental() {
		User loggedUser = userSession.getUser();
		result.include("user", users.findById(loggedUser));
	}

	@Post("/place-to-rental")
	public void save(PlaceToRental placeToRental) {
		System.out.println(placeToRental);
	}

}
