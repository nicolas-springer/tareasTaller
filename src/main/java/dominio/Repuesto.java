package dominio;

import javax.persistence.*;

@Entity(name="repuesto")
@Table
public class Repuesto {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idRepuesto;
	
	@Column
	private String descRepuesto;
	@Column
	private Integer Stock;
	public Integer getIdRepuesto() {
		return idRepuesto;
	}
	public void setIdRepuesto(Integer idRepuesto) {
		this.idRepuesto = idRepuesto;
	}
	public String getDescRepuesto() {
		return descRepuesto;
	}
	public void setDescRepuesto(String descRepuesto) {
		this.descRepuesto = descRepuesto;
	}
	public Integer getStock() {
		return Stock;
	}
	public void setStock(Integer stock) {
		Stock = stock;
	}
	public Repuesto() {
	}
	
}
