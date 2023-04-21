package dao;

import java.util.List;

import dominio.Provincia;
import dominio.ProvinciaLocalidad;

public interface ProvinciaDAO {
	void recuperarProvinciaNombre(String prov);

	Integer obtenerIdDe(String prov);

	List<Provincia> recuperarProvincias();

	void cargarProvinciasBD();

	ProvinciaLocalidad recuperarProvinciasLocalidades();
}
