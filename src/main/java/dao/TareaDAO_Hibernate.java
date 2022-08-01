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
		manager = ConnectionBD.conectar();
		Tarea t =manager.createQuery("SELECT t FROM tarea t where idtarea='"+id+"'",Tarea.class).getSingleResult();
		manager.close();
		return t;
	}

	@Override
	public Tarea recuperarTarea(Tarea t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void finalizarTarea(Integer id) {
		manager = ConnectionBD.conectar();
		manager.createQuery("update tarea set estado='0' where idtarea ="+id);
		manager.close();
	}
	@Override
	public void cancelarTarea(Integer id) {
		manager = ConnectionBD.conectar();
			
		String consulta = "UPDATE tarea SET estado = '"+1+"' WHERE idTarea = :id";
	
		try {
		manager.getTransaction().begin();
			Query query = manager.createNativeQuery(consulta);
			query.setParameter("sId", id);
			query.executeUpdate();
			manager.createNamedQuery(consulta);
			manager.createQuery(consulta).setParameter("id", id);
		manager.getTransaction().commit();

		
		} catch (Exception e) {
			 
			e.printStackTrace();
			}finally {
			manager.close();
			}
	}
	
	public List<Tarea> recuperarTareas(){
	
		manager = ConnectionBD.conectar();
		List<Tarea> lista = manager
				.createQuery("SELECT t FROM tarea t ",Tarea.class).getResultList();
		manager.close();
		return  lista;
		
		
	}

	@Override
	public void finalizarTarea(Tarea t) {
		manager = ConnectionBD.conectar();
		
		try {
		
		manager.getTransaction().begin();
		manager.find(Tarea.class, t.getIdTarea()).setEstado(EstadoTarea.FINALIZADA);
		manager.getTransaction().commit();
		} catch (Exception e) {
			 
			e.printStackTrace();
			}finally {
			manager.close();
			}
		
	}

	@Override
	public void cancelarTarea(Tarea t) {
		manager = ConnectionBD.conectar();
		
		try {
		
			manager.getTransaction().begin();
			manager.find(Tarea.class, t.getIdTarea()).setEstado(EstadoTarea.CANCELADA);
			manager.getTransaction().commit();
		} catch (Exception e) {
			 
			e.printStackTrace();
			}finally {
			manager.close();
			}
		
	}
	
}

