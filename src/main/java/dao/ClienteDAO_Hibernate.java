package dao;

import java.util.List;

import dominio.Cliente;
import dominio.ClienteDireccion;
import dominio.Direccion;
import dominio.Persona;
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
		
		if(lista.size()==0)return null;
		else return lista.get(0);
	}

	@Override
	public ClienteDireccion getClientesDirecciones() {
		ClienteDireccion cdaux = new ClienteDireccion();
		manager = ConnectionBD.conectar();
		List<Cliente> listac = manager.createQuery("select c from cliente c", Cliente.class).getResultList();
		List<Direccion> listad = manager.createQuery("select d from direccion d", Direccion.class).getResultList();		
		manager.close();
		cdaux.setClientes(listac);
		cdaux.setDirecciones(listad);
		return cdaux;
	}

	@Override
	public Cliente verificarClienteDNI(String text) {
		manager = ConnectionBD.conectar();
		PersonaDAO pdao = new PersonaDAO_Hibernate();
		Persona p = pdao.recuperarPersonaDNI(text, manager);
		
		if(p==null) {
			manager.close();
			return null;
		}
		
		return recuperarClienteIDPersona(p.getIdpersona());
	}

}
