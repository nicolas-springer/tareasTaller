package dao;

import java.util.List;

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
	}

	@Override
	public Direccion recuperarDireccionID(Integer id) {
		manager = ConnectionBD.conectar();
		Direccion d = manager.createQuery("select d from direccion d where id ="+id,Direccion.class).getSingleResult();
		manager.close();
		return d;
	}

	@Override
	public List<Direccion> recuperarDirecciones() {
		manager = ConnectionBD.conectar();
		 List<Direccion> lista= manager.createQuery("select d from direccion d",Direccion.class).getResultList();
		manager.close();
		return lista;
	};
	
	
}
