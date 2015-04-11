package com.procurandoape.advertise;

import javax.inject.Inject;

import com.google.common.base.Optional;
import com.procurandoape.room.PlaceToRental;
import com.procurandoape.room.PlacesToRental;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;

@Controller
public class AdvertiseController {

	private PlacesToRental placesToRental;

	private Result result;

	@Inject
	public AdvertiseController(PlacesToRental placesToRental, Result result) {
		this.placesToRental = placesToRental;
		this.result = result;
	}

	@Deprecated //CDI Eyes only
	AdvertiseController() {
	}

	@Get("/anuncio/{id}")
	public void advertise(Long id) {
		Optional<PlaceToRental> placeToRentalOptional = placesToRental.findBy(id);
		if (placeToRentalOptional.isPresent()) {
			result.include("placeToRental", placeToRentalOptional.get());
		}
		else {
			System.out.println("Nao encontrado");
		}
	}
}
