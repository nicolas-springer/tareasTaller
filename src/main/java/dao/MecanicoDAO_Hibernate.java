package dao;

import javax.persistence.*;

import dominio.Mecanico;

import util.ConnectionBD;

public class MecanicoDAO_Hibernate implements MecanicoDAO{

	DireccionDAO daoDireccion = new DireccionDAO_Hibernate();
	PersonaDAO daoPersona = new PersonaDAO_Hibernate();
	private static EntityManager manager;
	
	@Override
	public void guardarMecanico(Mecanico mec) {
		manager = ConnectionBD.conectar();
		try {
		manager.getTransaction().begin();
		
		daoDireccion.guardarDireccion(mec.getPersona().getDireccion());
		daoPersona.guardarPersona(mec.getPersona());
		
		manager.persist(mec);
		manager.getTransaction().commit();
		
		} catch (Exception e) {
			 
			e.printStackTrace();
			}finally {
			manager.close();
			}
		
	}



}
