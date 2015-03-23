package com.procurandoape.home;

import static br.com.caelum.vraptor.view.Results.json;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;

import com.google.common.base.Optional;
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
		Optional<List<City>> citiesFromStateOptional = cities.getByStateAbbreviation(state);
		if (citiesFromStateOptional.isPresent()) {
			result.use(json()).withoutRoot().from(citiesFromStateOptional.get()).serialize();
		} else {
			result.notFound();
		}

	}

}
