package com.procurandoape.infra;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;

public class EntityManagerProducer {

	@Produces
	@RequestScoped
	public EntityManager get() {
		return new JPAUtil().getEntityManager();
	}

	public void destroy(@Disposes EntityManager manager) {
		manager.close();
	}

}
