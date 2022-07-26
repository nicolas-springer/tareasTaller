package dao;

import java.util.List;

import dominio.Cliente;
import util.ConnectionBD;

import javax.persistence.*;
public class ClienteDAO_Hibernate implements ClienteDAO {

	private EntityManager manager;
	private DireccionDAO daoDireccion = new DireccionDAO_Hibernate();
	PersonaDAO daoPersona = new PersonaDAO_Hibernate();
	
	@Override
	public void guardarCliente(Cliente c) {
		// TODO Auto-generated method stub
		manager = ConnectionBD.conectar();
		
		try {
			manager.getTransaction().begin();
			
			daoDireccion.guardarDireccion(c.getPersona().getDireccion());
			daoPersona.guardarPersona(c.getPersona());
			
			manager.persist(c);
			manager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();
		}
	}

	@Override
	public Cliente recuperarClienteDNI(Integer dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente recuperarClienteID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> recuperarClientes() {
		manager = ConnectionBD.conectar();
		List<Cliente> lista = manager.createQuery("select c from cliente c", Cliente.class).getResultList();
		manager.close();
		return lista;
	}

	@Override
	public Cliente recuperarClienteIDPersona(Integer idpersona) {
		manager = ConnectionBD.conectar();
		List<Cliente> lista = manager.createQuery("select c from cliente c where id_persona ='"+idpersona+"'", Cliente.class).getResultList();
		manager.close();
		return lista.get(0);
	}

}
