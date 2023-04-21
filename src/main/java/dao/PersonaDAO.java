package dao;

import javax.persistence.EntityManager;

import dominio.Cliente;
import dominio.Persona;

public interface PersonaDAO {

	Boolean buscarDni(Integer dni);

	void guardarPersona(Persona persona);

	Persona recuperarPersonaDNI(Integer dni);

	public Persona recuperarPersonaDNI(String text,EntityManager aux);
}
