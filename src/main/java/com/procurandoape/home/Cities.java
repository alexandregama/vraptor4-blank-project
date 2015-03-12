package com.procurandoape.home;

import java.util.List;

import com.procurandoape.user.City;

public interface Cities {

	List<State> getAllStates();

	List<City> getByStateAbbreviation(String state);

}
