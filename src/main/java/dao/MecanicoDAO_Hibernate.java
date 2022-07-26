package dao;

import java.util.List;

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

	@Override
	public List<Mecanico> recuperarMecanicos() {

		manager = ConnectionBD.conectar();
		List<Mecanico> r = manager.createQuery("select m from mecanico m", Mecanico.class).getResultList();
		manager.close();
		return r;
	}

	@Override
	public Mecanico recuperarMecanicoID(Integer idpersona) {
		manager = ConnectionBD.conectar();
		Mecanico r = manager.createQuery("select m from mecanico m where id_persona='"+idpersona+"'", Mecanico.class).getSingleResult();
		manager.close();
		return r;
	}




}
