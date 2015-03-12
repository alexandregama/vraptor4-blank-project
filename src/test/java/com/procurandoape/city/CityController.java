package com.procurandoape.city;

import static br.com.caelum.vraptor.view.Results.json;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;

import com.procurandoape.home.Cities;
import com.procurandoape.user.City;

@Controller
public class CityController {

	private Result result;

	private Cities cities;

	@Inject
	public CityController(Result result, Cities cities) {
		this.result = result;
		this.cities = cities;
	}

	@Deprecated //CDI Eyes only
	CityController() {
	}

	@Get("/city/{state}")
	public void getCity(String state) {
		List<City> citiesFromState = cities.getByStateAbbreviation(state);
		result.use(json()).withoutRoot().from(citiesFromState).serialize();;
	}

}
