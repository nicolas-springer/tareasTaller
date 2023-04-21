package dao;

import java.util.*;
import dominio.Cliente;
import dominio.ClienteDireccion;;
public interface ClienteDAO {

	void guardarCliente(Cliente cliente);
	Cliente recuperarClienteDNI(Integer dni);
	Cliente recuperarClienteID(Integer id);
	List<Cliente> recuperarClientes();
	Cliente recuperarClienteIDPersona(Integer idpersona);
	ClienteDireccion getClientesDirecciones();
	Cliente verificarClienteDNI(String text);
}	
