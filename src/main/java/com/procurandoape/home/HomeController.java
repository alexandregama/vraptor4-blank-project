package com.procurandoape.home;

import java.util.List;

import javax.inject.Inject;

import com.procurandoape.room.Room;
import com.procurandoape.room.Rooms;
import com.procurandoape.user.Users;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;

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
		List<Room> roomsForHome = rooms.getRoomsForHome();
		System.out.println(roomsForHome);
		result.include("roomsForHome", roomsForHome);
	}

}
