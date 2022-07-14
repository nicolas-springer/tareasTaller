package dao;

import java.util.ArrayList;
import java.util.List;

import dominio.Tarea;

public interface TareaDAO {
	
	 void guardarTarea(Tarea t);
	 Tarea recuperarTarea(Integer id);
	 Tarea recuperarTarea(Tarea t);
	void finalizarTarea(Integer id);
	void cancelarTarea(Integer id);
	public List<Tarea> recuperarTareas();// para cargar la GUI de listado tareas
}
