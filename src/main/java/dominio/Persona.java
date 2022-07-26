package dominio;

import javax.persistence.*;

import dto.ClienteDTO;
import dto.MecanicoDTO;



@Entity (name = "persona")
@Table
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idPersona;
	@Column
	private String apellido;
	private String nombre;
	private Integer numeroDocumento;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="direccion_id",referencedColumnName="id_Direccion")
	private Direccion direccion;
	
	private String cuit;
	private String posFrenteIVA;
	private String telefono;

	public Persona() {

	}

	public Persona(String apellido, String nombre, Integer numeroDocumento, Direccion direccion,
			String cuit,String telefono) {
		super();
		this.apellido = apellido;
		this.nombre = nombre;
		this.numeroDocumento = numeroDocumento;
		this.direccion = direccion;
		this.cuit = cuit;
		this.telefono = telefono;

	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(Integer numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	

	public String getPosFrenteIVA() {
		return posFrenteIVA;
	}

	public void setPosFrenteIVA(String posFrenteIVA) {
		this.posFrenteIVA = posFrenteIVA;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}


	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	
	public Integer getIdpersona() {
		return idPersona;
	}

	public void setIdpersona(Integer idpersona) {
		this.idPersona = idpersona;
	}

	
	/*public Integer getEdad() {	
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("d/M/yyyy");
		LocalDate fechaNac = LocalDate.parse(nacimiento, fmt);
		LocalDate hoy = LocalDate.now();	
		Period periodo = Period.between(fechaNac, hoy);
		return periodo.getYears();
	*/

	public void inicializarPersona(MecanicoDTO mecanicoDTO, Direccion dir) {
		this.setApellido(mecanicoDTO.getApellido());
		this.setNombre(mecanicoDTO.getNombre());
		this.setNumeroDocumento(mecanicoDTO.getNumeroDocumento());
		this.setDireccion(dir);
		this.setTelefono(mecanicoDTO.getTelefono());
		
	}

	public void inicializarPersona(ClienteDTO clienteDTO, Direccion dir) {
		this.setApellido(clienteDTO.getApellido());
		this.setNombre(clienteDTO.getNombre());
		this.setNumeroDocumento(clienteDTO.getNumeroDocumento());
		this.setDireccion(dir);
		this.setTelefono(clienteDTO.getTelefono());
		
	}
	
}
