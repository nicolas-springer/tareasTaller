package dao;

import dominio.Direccion;

public interface DireccionDAO {
	
	public void guardarDireccion(Direccion d);

	public Direccion recuperarDireccionID(Integer id);	
	
}
