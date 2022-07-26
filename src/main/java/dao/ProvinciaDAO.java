package dao;

import java.util.List;

import dominio.Provincia;

public interface ProvinciaDAO {
	void recuperarProvinciaNombre(String prov);

	Integer obtenerIdDe(String prov);

	List<Provincia> recuperarProvincias();

	void cargarProvinciasBD();
}
