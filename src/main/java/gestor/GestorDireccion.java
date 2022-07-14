package gestor;

import dao.LocalidadDAO;
import dao.LocalidadDAO_Hibernate;
import dominio.Direccion;
import dominio.Localidad;

public class GestorDireccion {

	LocalidadDAO daoLocalidad = new LocalidadDAO_Hibernate();
	
	public Direccion generarDireccion (String calle, Integer numero, Integer dpto, Integer piso, String ciudad) {
		
		Direccion direccion = new Direccion();
		direccion.setCalle(calle);
		direccion.setNumero(numero);
		direccion.setDto(dpto);
		direccion.setPiso(piso);
		
		Localidad nloc = daoLocalidad.recuperarLocalidadNombre(ciudad); // busca en la DB la localidad para asignarla a la direccion
		direccion.setLocalidad(nloc);
		
		return direccion;
		}
	
}
