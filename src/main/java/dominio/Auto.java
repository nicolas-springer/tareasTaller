package dominio;

import javax.persistence.*;

@Entity(name="auto")
@Table 
public class Auto {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_auto;
	
	@Column
	private String patente;
	@Column
	private String marca;
	@Column
	private String modelo;
	
	
	public Auto() {

	}
	
	public Auto(Integer id_auto, String patente, String marca, String modelo) {
		this.id_auto = id_auto;
		this.patente = patente;
		this.marca = marca;
		this.modelo = modelo;
	}
	
	
	
}
