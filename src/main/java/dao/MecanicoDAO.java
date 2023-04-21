package dao;

import dominio.Mecanico;
import dominio.MecanicoDireccion;

import java.util.*;

public interface MecanicoDAO {

	void guardarMecanico(Mecanico mec);

	List<Mecanico> recuperarMecanicos();

	Mecanico recuperarMecanicoID(Integer idpersona);

	List<Mecanico> recuperarMecanicosConNombre(String nombre);

	MecanicoDireccion getMecanicosDirecciones();

}
