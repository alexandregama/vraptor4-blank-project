package com.procurandoape.home;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;

import com.procurandoape.room.Rooms;
import com.procurandoape.user.Users;

@Controller
public class HomeController {

	@Inject
	private Users users;

	@Inject
	private Rooms rooms;

	@Inject
	private Result result;

	@Get("/")
	public void index() {
		result.include("usersForHome", users.getBestThreeUsersForHome());
		result.include("roomsForHome", rooms.getRoomsForHome());
	}

}
