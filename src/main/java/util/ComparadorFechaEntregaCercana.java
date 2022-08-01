package util;

import java.util.Comparator;

import dominio.Tarea;

public class ComparadorFechaEntregaCercana implements Comparator<Tarea> {

	@Override
	public int compare(Tarea t1, Tarea t2) {
		
		return t1.getFechaEntrega().compareTo(t2.getFechaEntrega());

		
	}

}
