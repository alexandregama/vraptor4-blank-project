package com.procurandoape.home;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;

import com.procurandoape.room.PlacesToRental;
import com.procurandoape.user.Users;

@Controller
public class HomeController {

	private Users users;

	private PlacesToRental rooms;

	private Result result;

	@Inject
	public HomeController(Users users, PlacesToRental rooms, Result result) {
		this.users = users;
		this.rooms = rooms;
		this.result = result;
	}

	@Deprecated //CDI Eyes only
	HomeController() {
	}

	@Get("/")
	public void index() {
		result.include("usersForHome", users.getBestThreeUsersForHome());
		result.include("placesToRental", rooms.getPlacesToRentalForHome());
	}

}
