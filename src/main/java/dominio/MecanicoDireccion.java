package dominio;

import java.util.List;

public class MecanicoDireccion {
	private List<Mecanico> mecanicos;
	private List<Direccion> direcciones;
	public List<Mecanico> getMecanicos() {
		return mecanicos;
	}
	public void setMecanicos(List<Mecanico> mecanicos) {
		this.mecanicos = mecanicos;
	}
	public List<Direccion> getDirecciones() {
		return direcciones;
	}
	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}
	
	
}
