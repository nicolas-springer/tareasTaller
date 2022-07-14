package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionBD {

	public ConnectionBD() {

	}

	private static EntityManager manager;
	private static EntityManagerFactory emf;

	public static EntityManager conectar() {

		try {
			emf = Persistence.createEntityManagerFactory("aplicaciontaller");
			manager = emf.createEntityManager();
		
			manager.setProperty("hibernate.temp.use_jdbc_metadata_defaults","false");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return manager;
	}
}

