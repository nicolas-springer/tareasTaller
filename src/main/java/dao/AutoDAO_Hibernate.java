package dao;

import java.util.List;

import javax.persistence.EntityManager;

import dominio.Auto;
import util.ConnectionBD;

public class AutoDAO_Hibernate implements AutoDAO{

	private static EntityManager manager;
	
	@Override
	public List<Auto> recuperarAutoId(Integer idAuto) {
		manager = ConnectionBD.conectar();
		 
		 return manager
				.createQuery("SELECT c FROM consumo c WHERE id_estadia ='"+idAuto+"'",Auto.class).getResultList();
	}

	@Override
	public void guardarAuto(Auto auto) {
		
		manager = ConnectionBD.conectar();
		
		try {
			
		manager.getTransaction().begin();
		manager.persist(auto);
		manager.getTransaction().commit();
		} catch (Exception e) {
			 
			e.printStackTrace();
			}finally {
			manager.close();
			}
		
	}


}
