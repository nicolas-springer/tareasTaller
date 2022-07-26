package dao;

import java.util.List;

import dominio.Localidad;

public interface LocalidadDAO {

	Localidad recuperarLocalidadNombre(String loc);

	List<Localidad> obtenerLocalidadesDeProvincia(String prov);

	void cargarLocalidadesBD();

	Localidad recuperarLocalidadID(Integer id);
	
}
