package dominio;

import java.time.LocalDate;
import javax.persistence.*;

@Entity (name="anotacion")
@Table
public class Anotacion {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idAnotacion ;
	@Column
	private String contenido;
	@Column
	private LocalDate fechaCreacion;

	public Integer getIdAnotacion() {
		return idAnotacion;
	}

	public void setIdAnotacion(Integer idAnotacion) {
		this.idAnotacion = idAnotacion;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Anotacion() {
		super();
	}

	public void inicializarNota(String cont, LocalDate now) {
		this.contenido=cont;
		this.fechaCreacion=now;
	}
	
	
	
}
