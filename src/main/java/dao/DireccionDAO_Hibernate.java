package dao;

import javax.persistence.EntityManager;

import dominio.Direccion;
import util.ConnectionBD;

public class DireccionDAO_Hibernate implements DireccionDAO {
	
	private static EntityManager manager;
	
	public void guardarDireccion(Direccion d) {
		manager = ConnectionBD.conectar();
		try {
			manager.getTransaction().begin();
			manager.persist(d);
			manager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();
		}
	};
	
	
}
