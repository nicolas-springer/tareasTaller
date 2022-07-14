package dominio;

import javax.persistence.*;

@Entity(name="cliente")
@Table
public class Cliente {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idCliente;
	
	@OneToOne(optional = false)
    @JoinColumn(name= "id_persona" , referencedColumnName = "idpersona")
    private Persona persona;

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public void inicializarCliente(Persona persona) {
		this.setPersona(persona);
	}

	

}
