package dao;
import dominio.Anotacion;

import java.time.LocalDate;
import java.util.*;
public interface AnotacionDAO {
	void guardarAnotacion(Anotacion c);
	Anotacion recuperarAnotacionID(Integer id);
	List<Anotacion> recuperarAnotaciones();
	List<Anotacion> recuperarAnotacionesFecha(LocalDate fecha);
	List<Anotacion> recuperarAnotacionesEntreFechas(LocalDate primera, LocalDate segunda);
	List<Anotacion> recuperarAnotacionesPalabraClave(String palabra);
}
