package dominio;

import javax.persistence.*;

@Entity(name="auto")
@Table 
public class Auto {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idAuto;
	
	@Column
	private String patente;
	@Column
	private String marca;
	@Column
	private String modelo;
	
	@ManyToOne
	@JoinColumn(name= "id_cliente" , referencedColumnName = "idCliente")
	private Cliente cliente;
	
	public Auto() {

	}
	
	public Auto(Integer id_auto, String patente, String marca, String modelo) {
		this.idAuto = id_auto;
		this.patente = patente;
		this.marca = marca;
		this.modelo = modelo;
	}

	public Integer getIdAuto() {
		return idAuto;
	}

	public void setIdAuto(Integer idAuto) {
		this.idAuto = idAuto;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void inicializarAuto(String patente2, String marca2, String modelo2, Cliente c) {
		this.setMarca(marca2);
		this.setPatente(patente2);
		this.setModelo(modelo2);
		this.setCliente(c);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
}
