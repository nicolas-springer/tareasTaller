package gestor;

import dao.PersonaDAO;
import dao.PersonaDAO_Hibernate;
import dominio.Direccion;
import dominio.Persona;
import dto.MecanicoDTO;

public class GestorPersona {
	
	PersonaDAO daoPersona = new PersonaDAO_Hibernate();

	public Persona darDeAltaPersona(MecanicoDTO mecanicoDTO) {

		GestorDireccion gestorDireccion = new GestorDireccion();
		Direccion direccion = gestorDireccion.generarDireccion(mecanicoDTO.getCalle(), mecanicoDTO.getNumeroCalle(),mecanicoDTO.getDepartamento(), mecanicoDTO.getPiso(), mecanicoDTO.getLocalidad());

		Persona persona = new Persona();
		persona.inicializarPersona(mecanicoDTO, direccion);

		return persona;
	}


	
	/*public List<Persona> recuperarPasajeros(BusquedaPasajeroDTO pasajeroBusqueda) {

		return daoPersona.recuperarPersonaBusqueda(pasajeroBusqueda.getNombre(), pasajeroBusqueda.getApellido(),
				pasajeroBusqueda.getNumeroDeDocumento(), pasajeroBusqueda.getTipoDeDocumento());

	}
	*/
	public Boolean buscarDNI (Integer dni) {
		
		return daoPersona.buscarDni(dni);
	}
	
}
