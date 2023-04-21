package dao;

import java.util.List;

import dominio.Direccion;

public interface DireccionDAO {
	
	public void guardarDireccion(Direccion d);

	public Direccion recuperarDireccionID(Integer id);

	public List<Direccion> recuperarDirecciones();	
	
}
