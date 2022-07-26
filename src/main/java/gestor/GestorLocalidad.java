package gestor;

import java.util.ArrayList;
import java.util.List;

import dao.LocalidadDAO;
import dao.LocalidadDAO_Hibernate;
import dao.ProvinciaDAO;
import dao.ProvinciaDAO_Hibernate;
import dominio.Localidad;
import dominio.Provincia;

public class GestorLocalidad {

	private LocalidadDAO daoLocalidad = new LocalidadDAO_Hibernate();
	
	
	public List<Localidad> obtenerLocalidades(String prov) {

		return daoLocalidad.obtenerLocalidadesDeProvincia(prov);
	}


	public void cargarLocalidadesBD() {
		daoLocalidad.cargarLocalidadesBD();
		
	}


	public Localidad recuperarLocalidadID(Integer id) {
			return daoLocalidad.recuperarLocalidadID(id);
	}

}
