package dao;

import java.util.List;

import javax.persistence.EntityManager;

import dominio.Cliente;
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
		manager.close();
		if(p.size() == 0) return false;
		else return true;
		
	}

	@Override
	public Persona recuperarPersonaDNI(Integer dni) {
		manager = ConnectionBD.conectar();
		List<Persona> p =  manager
				.createQuery("SELECT p FROM persona p WHERE numeroDocumento = '"+dni+"' ",Persona.class).getResultList();
		manager.close();
		if(p.size() == 0) return null;
		else return p.get(0);
		
	}

	@Override
	public Persona recuperarPersonaDNI(String text, EntityManager aux) {
		List<Persona> p =  aux
				.createQuery("SELECT p FROM persona p WHERE numeroDocumento = '"+text+"' ",Persona.class).getResultList();
		if(p.size() == 0) return null;
		else return p.get(0);
	}

}
