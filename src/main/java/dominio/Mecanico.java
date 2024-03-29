package dominio;

import javax.persistence.*;

@Entity(name="mecanico")
@Table
public class Mecanico {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idMecanico;
	
	@OneToOne(optional = false)
    @JoinColumn(name= "id_persona" , referencedColumnName = "idPersona")
    private Persona persona;
	
	@Column
	private String especialidad;
	

	public Mecanico(Integer idMecanico) {
		this.idMecanico = idMecanico;
	}

	public Mecanico() {

	}

	public Integer getIdMecanico() {
		return idMecanico;
	}

	public void setIdMecanico(Integer idMecanico) {
		this.idMecanico = idMecanico;
	}
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public void inicializarMecanico(Persona persona) {
		this.setPersona(persona);
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public Direccion getDireccionPersona() {
		return persona.getDireccion();
	}

}