package dao;

import java.util.List;

import javax.persistence.EntityManager;

import dominio.Provincia;
import util.ConnectionBD;

public class ProvinciaDAO_Hibernate implements ProvinciaDAO{

	private static EntityManager manager;
	
	@Override
	public void recuperarProvinciaNombre(String prov) {
		
		
	}
	@Override
	public List<Provincia> recuperarProvincias() {
		
		manager = ConnectionBD.conectar();
		return (List<Provincia>) manager.createQuery(
						 "SELECT p FROM provincia p ", Provincia.class ).getResultList();
	}

	@Override
	public Integer obtenerIdDe(String p) {
		manager = ConnectionBD.conectar();
		
		List<Provincia> idProvincia = (List<Provincia>) manager
				.createQuery("SELECT p FROM provincia p WHERE nombre ='"+p+"'",Provincia.class).getResultList();


		return idProvincia.get(0).getIdProvincia();
	}
	@Override
	public void cargarProvinciasBD() {
		// TODO Auto-generated method stub
		//chequear que existan provincias cargas, sino cargarlas con txt de meta-inf
		
	}
	
	
}
