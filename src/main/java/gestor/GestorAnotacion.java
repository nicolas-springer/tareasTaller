package gestor;

import java.time.LocalDate;

import dao.AnotacionDAO;
import dao.AnotacionDAO_Hibernate;
import dominio.Anotacion;
import java.util.*;
public class GestorAnotacion {
	
	AnotacionDAO daoAnotacion = new AnotacionDAO_Hibernate();
	
	public void darAltaNota(String cont) {
		Anotacion nota = new Anotacion();
		nota.inicializarNota(cont, LocalDate.now());
		daoAnotacion.guardarAnotacion(nota);
	}
	
	public List<Anotacion> recuperarAnotaciones(){
		return daoAnotacion.recuperarAnotaciones();
	}

	public List<Anotacion> recuperarAnotacionesPalabraClave(String palabra) {
		// TODO Auto-generated method stub
		return daoAnotacion.recuperarAnotacionesPalabraClave(palabra);
	}
	
}
