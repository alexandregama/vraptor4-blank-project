package com.procurandoape.home;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.procurandoape.user.City;

public class HibernateCitiesDao implements Cities {

	private EntityManager manager;

	@Inject
	public HibernateCitiesDao(EntityManager manager) {
		this.manager = manager;
	}

	@Deprecated //CDI Eyes only
	HibernateCitiesDao() {
	}

	@Override
	public List<State> getAllStates() {
		TypedQuery<City> query = manager.createQuery("select c from City c group by state order by state asc", City.class);
		List<City> cities = query.getResultList();
		List<State> states = new ArrayList<>();
		for (City city: cities) {
			State state = new State(city.getState(), city.getStateAbbreviation());
			states.add(state);
		}
		return states;
	}

	@Override
	public List<City> getByState(String state) {
		String sql = "select c from City c where c.stateAbbreviation = :abbreviation group by name order by name";
		TypedQuery<City> query = manager.createQuery(sql, City.class);
		query.setParameter("abbreviation", state);
		return query.getResultList();
	}

}
