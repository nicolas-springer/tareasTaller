package gestor;

import javax.persistence.EntityManager;

import dao.PersonaDAO;
import dao.PersonaDAO_Hibernate;
import dominio.Cliente;
import dominio.Direccion;
import dominio.Persona;
import dto.ClienteDTO;
import dto.MecanicoDTO;

public class GestorPersona {
	
	PersonaDAO daoPersona = new PersonaDAO_Hibernate();

	public Persona darDeAltaPersona(MecanicoDTO mecanicoDTO) {

		GestorDireccion gestorDireccion = new GestorDireccion();
		Direccion direccion = gestorDireccion.generarDireccion(mecanicoDTO.getCalle(), mecanicoDTO.getNumeroCalle(),
				mecanicoDTO.getDepartamento(), mecanicoDTO.getPiso(), mecanicoDTO.getLocalidad(), mecanicoDTO.getProvincia());
		//System.out.println(direccion.getLocalidad());
		Persona persona = new Persona();
		persona.inicializarPersona(mecanicoDTO, direccion);

		return persona;
	}

	public Boolean buscarDNI (Integer dni) {
		
		return daoPersona.buscarDni(dni);
	}



	public Persona darDeAltaPersona(ClienteDTO clienteDTO) {
		GestorDireccion gestorDireccion = new GestorDireccion();
		Direccion direccion = gestorDireccion.generarDireccion(clienteDTO.getCalle(), clienteDTO.getNumeroCalle(),clienteDTO.getDepartamento(), clienteDTO.getPiso(), clienteDTO.getLocalidad(), clienteDTO.getProvincia());
		//System.out.println(direccion.getLocalidad());
		Persona persona = new Persona();
		persona.inicializarPersona(clienteDTO, direccion);

		return persona;
	}



	public Persona recuperarPersonaDNI(String text) {
		return daoPersona.recuperarPersonaDNI(Integer.parseInt(text));
	}

	
}
