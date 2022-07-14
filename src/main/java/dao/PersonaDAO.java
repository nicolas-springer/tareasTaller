package dao;

import dominio.Persona;

public interface PersonaDAO {

	Boolean buscarDni(Integer dni);

	void guardarPersona(Persona persona);

}
