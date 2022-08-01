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
		List<Auto> lista = manager
				.createQuery("SELECT a from auto a where idauto ='"+idAuto+"'",Auto.class).getResultList();
		manager.close(); 
		return lista;
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

	@Override
	public List<Auto> recuperarAutosDeClienteID(int id) {
		manager = ConnectionBD.conectar();
		List<Auto> lista = manager
				.createQuery("SELECT a from auto a where id_cliente ='"+id+"'",Auto.class).getResultList();
		manager.close();
		return lista;
	
	}

	@Override
	public Auto recuperarAutoConPatente(String pat) {
		manager = ConnectionBD.conectar();
		 
		 List<Auto> a = manager
				.createQuery("SELECT a from auto a where patente like'"+pat+"'",Auto.class).getResultList();
		 manager.close();
		 
		 if (a.size()==0) {
			 return null;
		 }
		 else {
			 return a.get(0);
		 }
	}


}
