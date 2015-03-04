package com.procurandoape.room;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.procurandoape.infra.JPAUtil;

public class HibernateRoomsDao implements Rooms {

	@Override
	public List<Room> getRoomsForHome() {
		EntityManager manager = new JPAUtil().getEntityManager();
		TypedQuery<Room> query = manager.createQuery("select r from Room r", Room.class);
		query.setMaxResults(3);

		return query.getResultList();
	}

}
