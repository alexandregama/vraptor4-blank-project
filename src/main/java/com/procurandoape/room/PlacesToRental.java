package com.procurandoape.room;

import java.util.List;

import com.google.common.base.Optional;

public interface PlacesToRental {

	List<PlaceToRental> getPlacesToRentalForHome();

	void save(PlaceToRental placeToRental);

	Optional<PlaceToRental> findBy(Long id);

}
