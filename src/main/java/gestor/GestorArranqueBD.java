package gestor;

import dominio.Localidad;

public class GestorArranqueBD {

	public Localidad localidadesCargadas() {
		//si existen una localidad cargada entonces existe previamente las provincias.
		GestorLocalidad gLocalidad = new GestorLocalidad();
		Localidad l = gLocalidad.recuperarLocalidadID(2084);//2084 id existentes en loc2
		return l;
	}

	public void cargarProvinciasYLocalidades() {
		// TODO Auto-generated method stub
		
	}
	
}
