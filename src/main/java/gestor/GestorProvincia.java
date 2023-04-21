package gestor;

import java.util.List;

import dao.ProvinciaDAO;
import dao.ProvinciaDAO_Hibernate;
import dominio.Provincia;
import dominio.ProvinciaLocalidad;

public class GestorProvincia {

	private ProvinciaDAO daoProvincias = new ProvinciaDAO_Hibernate();
	
	public List<Provincia> recuperarProvincias() {

		return daoProvincias.recuperarProvincias();
	}

	public Integer obtenerIdDe(String prov) {
		return daoProvincias.obtenerIdDe(prov);
	}

	public void cargarProvinciasBD() {
		daoProvincias.cargarProvinciasBD();
		
	}

	public ProvinciaLocalidad recuperarProvinciasLocalidades() {
		return daoProvincias.recuperarProvinciasLocalidades();
	}

}
