package dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import dominio.Anotacion;
import util.ConnectionBD;

public class AnotacionDAO_Hibernate implements AnotacionDAO {

	private EntityManager manager;
	
	@Override
	public void guardarAnotacion(Anotacion a) {
		manager =  ConnectionBD.conectar();
		
		try {
			manager.getTransaction().begin();
			manager.persist(a);
			manager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();
		}
		
	}

	@Override
	public Anotacion recuperarAnotacionID(Integer id) {
		manager = ConnectionBD.conectar();
		Anotacion a = manager.createQuery("select a from anotacion a where id ="+id,Anotacion.class).getSingleResult();
		manager.close();
		return a;
	}

	@Override
	public List<Anotacion> recuperarAnotaciones() {
		manager = ConnectionBD.conectar();
		List<Anotacion> lista = manager.createQuery("select a from anotacion a",Anotacion.class).getResultList();
		manager.close();
		return lista;
	}

	@Override
	public List<Anotacion> recuperarAnotacionesFecha(LocalDate fecha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Anotacion> recuperarAnotacionesEntreFechas(LocalDate primera, LocalDate segunda) {
		// TODO Auto-generated method stub
		return null;
	}

}
