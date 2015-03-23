package com.procurandoape.home;

import java.util.List;

import com.google.common.base.Optional;
import com.procurandoape.user.City;

public interface Cities {

	List<State> getAllStates();

	Optional<List<City>> getByStateAbbreviation(String state);

}
