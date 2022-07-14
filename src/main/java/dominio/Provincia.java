package dominio;

import javax.persistence.*;

@Entity (name= "provincia")
@Table
public class Provincia {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="idprovincia")
    private Integer idProvincia;
    
    private String nombre;

	public Integer getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(Integer idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}  
    
}
