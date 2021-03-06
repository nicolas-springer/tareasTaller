package dao;

import java.util.List;

import dominio.Auto;

public interface AutoDAO {

	
	List<Auto> recuperarAutoId (Integer idAuto);

	void guardarAuto(Auto auto);

	List<Auto> recuperarAutosDeClienteID(int id);

	Auto recuperarAutoConPatente(String pat);

	
}
