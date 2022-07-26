package gestor;

import dao.DireccionDAO;
import dao.DireccionDAO_Hibernate;
import dao.LocalidadDAO;
import dao.LocalidadDAO_Hibernate;
import dominio.Direccion;
import dominio.Localidad;

public class GestorDireccion {

	LocalidadDAO daoLocalidad = new LocalidadDAO_Hibernate();
	DireccionDAO daoDireccion = new DireccionDAO_Hibernate();
	public Direccion generarDireccion (String calle, Integer numero, Integer dpto, Integer piso, String ciudad) {
		
		Direccion direccion = new Direccion();
		direccion.setCalle(calle);
		direccion.setNumero(numero);
		direccion.setDto(dpto);
		direccion.setPiso(piso);
		System.out.println("gestDir : " +ciudad);
		Localidad nloc = daoLocalidad.recuperarLocalidadNombre(ciudad); // busca en la DB la localidad para asignarla a la direccion
		System.out.println("ba :"+nloc);
		direccion.setLocalidad(nloc);
		
		return direccion;
		}

	public Direccion recuperarDireccion(Integer id){
		// TODO Auto-generated method stub
		return daoDireccion.recuperarDireccionID(id);
	}
	
}
