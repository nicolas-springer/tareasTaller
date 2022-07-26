package dao;

import dominio.Mecanico;
import java.util.*;

public interface MecanicoDAO {

	void guardarMecanico(Mecanico mec);

	List<Mecanico> recuperarMecanicos();

	Mecanico recuperarMecanicoID(Integer idpersona);

}
