package dominio;

import javax.persistence.*;

@Entity
@Table
public class Direccion {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_Direccion;
	@Column
	private String calle;
	@Column
	private Integer numero;
	@Column
	private Integer piso;
	@Column
	private Integer dto;
	
	@ManyToOne
    @JoinColumn(name= "id_localidad" , referencedColumnName = "idLocalidad")
    private Localidad localidad;
	
	public Direccion () {
		
	}
	
	public Direccion(String calle, Integer numero, Integer piso, Integer dto) {
		super();
		this.calle = calle;
		this.numero = numero;
		this.piso = piso;
		this.dto = dto;
	}

	public Integer getId_Direccion() {
		return id_Direccion;
	}
	public void setId_Direccion(Integer id_Direccion) {
		this.id_Direccion = id_Direccion;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getPiso() {
		return piso;
	}

	public void setPiso(Integer piso) {
		this.piso = piso;
	}

	public Integer getDto() {
		return dto;
	}

	public void setDto(Integer dto) {
		this.dto = dto;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
}


