package dao;

import java.util.List;

import javax.persistence.EntityManager;

import dominio.Persona;
import util.ConnectionBD;

public class PersonaDAO_Hibernate implements PersonaDAO {

	private static EntityManager manager;

	@Override
	public void guardarPersona(Persona persona) {
		manager = ConnectionBD.conectar();
		try {
		manager.getTransaction().begin();
		manager.persist(persona);
		manager.getTransaction().commit();
		} catch (Exception e) {
			 
			e.printStackTrace();
			}finally {
			manager.close();
			}
	}
	
	public Boolean buscarDni(Integer dni) {
		
		manager = ConnectionBD.conectar();
		
		List<Persona> p =  manager
			.createQuery("SELECT p FROM persona p WHERE numeroDocumento = '"+dni+"' ",Persona.class).getResultList();
	
		if(p.size() == 0) return false;
		else return true;
		
	}

}
