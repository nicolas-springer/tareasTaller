package dao;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Localidad> obtenerLocalidadesDeProvincia(String prov) {
		Integer idProv = gProvincia.obtenerIdDe(prov);
		
		manager = ConnectionBD.conectar();
		
		return manager.
				createQuery("SELECT l FROM localidad l Where id_provincia ='" + idProv + "'", Localidad.class).getResultList(); 
	}

}
