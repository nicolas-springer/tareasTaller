package dominio;

import javax.persistence.*;

@Entity(name="itemtarea")
@Table
public class ItemTarea {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer iditem;
	
	@ManyToOne
	@JoinColumn(name= "id_tarea" , referencedColumnName = "idTarea")
	private Tarea tarea;
	
	@ManyToOne
	 @JoinColumn(name= "id_rep" , referencedColumnName = "idRepuesto")
	private Repuesto repuesto;
	
	@Column
	private Integer cantidadusada;

	public Integer getIditem() {
		return iditem;
	}

	public void setIditem(Integer iditem) {
		this.iditem = iditem;
	}

	public Tarea getTarea() {
		return tarea;
	}

	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}

	public Repuesto getRepuesto() {
		return repuesto;
	}

	public void setRepuesto(Repuesto repuesto) {
		this.repuesto = repuesto;
	}

	public Integer getCantidadusada() {
		return cantidadusada;
	}

	public void setCantidadusada(Integer cantidadusada) {
		this.cantidadusada = cantidadusada;
	}

	public ItemTarea() {
	}
	
	
	
	
}
