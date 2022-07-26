package dao;

import java.sql.Connection;
import java.util.List;

import javax.persistence.EntityManager;

import dominio.Localidad;
import gestor.GestorProvincia;
import util.ConnectionBD;

public class LocalidadDAO_Hibernate implements LocalidadDAO{

	
	private GestorProvincia gProvincia = new GestorProvincia();
	
	private static EntityManager manager;
	
	@Override
	public Localidad recuperarLocalidadNombre(String loc) {
		manager = ConnectionBD.conectar();
		Localidad l = manager.createQuery("select l from localidad l where nombre='"+loc+"'",Localidad.class).getSingleResult();
		return l;
	}

	@Override
	public List<Localidad> obtenerLocalidadesDeProvincia(String prov) {
		Integer idProv = gProvincia.obtenerIdDe(prov);
		
		manager = ConnectionBD.conectar();
		
		return manager.
				createQuery("SELECT l FROM localidad l Where id_provincia ='" + idProv + "'", Localidad.class).getResultList(); 
	}

	@Override
	public void cargarLocalidadesBD() {
		// chequear si existen las localidades sino cargarlas
		
	}

	@Override
	public Localidad recuperarLocalidadID(Integer id) {
		manager = ConnectionBD.conectar();
		Localidad l  =  manager.createQuery("select l from localidad l where id="+id,Localidad.class).getSingleResult();
		manager.close();
		return l;
	}

}
