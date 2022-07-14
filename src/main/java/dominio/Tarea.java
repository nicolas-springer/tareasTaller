package dominio;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import enumClasses.EstadoTarea;

@Entity
@Table
public class Tarea {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idTarea;
	
	@Column
	private Cliente cliente;
	@Column 
	private Auto auto;
	@Column
	private Mecanico mecanico;
	@Column
	private LocalDate fechaCreacion;
	@Column
	private LocalDate fechaEntrega;
	@Column
	private EstadoTarea estado;
	@Column
	private String descProblema;
	
	
	
	@OneToMany(mappedBy="tarea")
    private List<ItemTarea> items;
	
	
	public Integer getIdTarea() {
		return idTarea;
	}
	public void setIdTarea(Integer idTarea) {
		this.idTarea = idTarea;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Mecanico getMecanico() {
		return mecanico;
	}
	public void setMecanico(Mecanico mecanico) {
		this.mecanico = mecanico;
	}
	
	public Auto getAuto() {
		return auto;
	}
	public void setAuto(Auto auto) {
		this.auto = auto;
	}
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(LocalDate fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public List<ItemTarea> getItems() {
		return items;
	}
	public void setItems(List<ItemTarea> items) {
		this.items = items;
	}
	public EstadoTarea getEstado() {
		return estado;
	}
	public void setEstado(EstadoTarea estado) {
		this.estado = estado;
	}
	
	public String getDescProblema() {
		return descProblema;
	}
	public void setDescProblema(String descProblema) {
		this.descProblema = descProblema;
	}
	public Tarea(Integer idTarea, Cliente cliente, Mecanico mecanico, LocalDate fechaCreacion, LocalDate fechaEntrega,
			EstadoTarea estado) {
		super();
		this.idTarea = idTarea;
		this.cliente = cliente;
		this.mecanico = mecanico;
		this.fechaCreacion = fechaCreacion;
		this.fechaEntrega = fechaEntrega;
		this.estado = estado;
	}
	
	public Tarea() {
		
	}
	
	
}
