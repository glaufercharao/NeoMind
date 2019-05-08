package com.neomind.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("fornecedor");
	
	public EntityManager getConnection() {
		EntityManager em = emf.createEntityManager();
		return em;
	}

}
