package gestor;

import java.time.LocalDate;
import java.util.List;

import dao.TareaDAO;
import dao.TareaDAO_Hibernate;
import dominio.Auto;
import dominio.Cliente;
import dominio.Mecanico;
import dominio.Tarea;
import enumClasses.EstadoTarea;
import util.ConnectionBD;

public class GestorTarea {

	TareaDAO daoTarea = new TareaDAO_Hibernate();
	
	public Tarea generarTarea(Cliente c, Auto a, Mecanico m, String desc, LocalDate fechaEntrega) {
		Tarea t = new Tarea();
		
		t.setCliente(c);
		t.setAuto(a);
		t.setMecanico(m);
		t.setDescProblema(desc);
		t.setFechaEntrega(fechaEntrega);
		
		t.setFechaCreacion(LocalDate.now());
		t.setEstado(EstadoTarea.PENDIENTE);
		
		daoTarea.guardarTarea(t);
		
		
		
		return t;
	}
	
	public void finalizarTarea(Integer id) {
		Tarea t = daoTarea.recuperarTarea(id);
		t.setEstado(EstadoTarea.FINALIZADA);
		daoTarea.finalizarTarea(t);
	}
	public void cancelarTarea(Integer id){
		Tarea t = daoTarea.recuperarTarea(id);
		t.setEstado(EstadoTarea.CANCELADA);
		daoTarea.cancelarTarea(t);
	}
	
	public List<Tarea> recuperarTareas(){
		
		return daoTarea.recuperarTareas();
		
	}
}
