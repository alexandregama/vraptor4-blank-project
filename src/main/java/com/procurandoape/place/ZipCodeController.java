package com.procurandoape.place;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

import com.google.common.base.Optional;

@Controller
public class ZipCodeController {

	private Zipcodes zipcodes;

	private Result result;

	@Inject
	public ZipCodeController(Zipcodes zipcodes, Result result) {
		this.zipcodes = zipcodes;
		this.result = result;
	}

	@Deprecated //CDI Eyes only
	ZipCodeController() {
	}

	@Get("/zipcode/{zipcode}")
	public void get(String zipcode) {
		Optional<Zipcode> zipcodeOptional = zipcodes.findByZipcodeNumber(zipcode);
		if (zipcodeOptional.isPresent()) {
			result.use(Results.json()).from(zipcodeOptional.get()).serialize();
		} else {
			result.notFound();
		}
	}

}
