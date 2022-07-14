package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dominio.Tarea;
import enumClasses.EstadoTarea;
import util.ConnectionBD;

public class TareaDAO_Hibernate implements TareaDAO{

	private static EntityManager manager;
	
	@Override
	public void guardarTarea(Tarea t) {
		
		manager = ConnectionBD.conectar();
		
		try {
		
		manager.getTransaction().begin();
		manager.persist(t);
		manager.getTransaction().commit();
		} catch (Exception e) {
			 
			e.printStackTrace();
			}finally {
			manager.close();
			}
		
	}

	@Override
	public Tarea recuperarTarea(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tarea recuperarTarea(Tarea t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void finalizarTarea(Integer id) {
		manager = ConnectionBD.conectar();
			
		String consulta = "UPDATE tarea SET estado = '"+EstadoTarea.FINALIZADA+"' WHERE idTarea =:sId";

		
		try {
			manager.getTransaction().begin();
			Query query = manager.createNativeQuery(consulta);
			query.setParameter("sId", id);
			query.executeUpdate();
			manager.createNamedQuery(consulta);
			
		manager.getTransaction().commit();
		} catch (Exception e) {
			 
			e.printStackTrace();
			}finally {
			manager.close();
			}
	}
	@Override
	public void cancelarTarea(Integer id) {
		manager = ConnectionBD.conectar();
			
		String consulta = "UPDATE tarea SET estado = '"+EstadoTarea.CANCELADA+"' WHERE idTarea =:sId";

		
		try {
			manager.getTransaction().begin();
			Query query = manager.createNativeQuery(consulta);
			query.setParameter("sId", id);
			query.executeUpdate();
			manager.createNamedQuery(consulta);
			
		manager.getTransaction().commit();
		} catch (Exception e) {
			 
			e.printStackTrace();
			}finally {
			manager.close();
			}
	}
	
	public List<Tarea> recuperarTareas(){
	
		manager = ConnectionBD.conectar();
		
		return  manager
				.createQuery("SELECT t FROM tarea t ",Tarea.class).getResultList();
		
		
	}
	
}

