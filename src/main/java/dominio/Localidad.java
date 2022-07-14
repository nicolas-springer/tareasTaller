package dominio;

import javax.persistence.*;

@Entity (name="localidad")
@Table 

public class Localidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLocalidad;
    
    @ManyToOne(optional = false)
    @JoinColumn(name= "id_provincia" , referencedColumnName = "idProvincia")
    private Provincia provincia;
    
    private String nombre;
    
    public Localidad() {
        
    }

    public Localidad(Integer idLocalidad, Provincia provincia, String nombre) {
        super();
        this.idLocalidad = idLocalidad;
        this.provincia = provincia;
        this.nombre = nombre;
    }

    public Integer getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(Integer idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    

}
