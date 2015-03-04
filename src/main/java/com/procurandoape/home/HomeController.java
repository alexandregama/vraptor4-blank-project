package com.procurandoape.home;

import javax.inject.Inject;

import com.procurandoape.user.Users;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;

@Controller
public class HomeController {

	@Inject
	private Users users;

	@Inject
	private Result result;

	@Get("/")
	public void index() {
		result.include("usersForHome", users.bestThreeUsersForHome());
	}

}
