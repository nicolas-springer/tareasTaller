package dominio;

import java.util.List;

public class ProvinciaLocalidad {
    private List<Provincia> provincias;
    private List<Localidad> localidades;

    public List<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<Provincia> provincias) {
        this.provincias = provincias;
    }

    public List<Localidad> getLocalidades() {
        return localidades;
    }

    public void setLocalidades(List<Localidad> localidades) {
        this.localidades = localidades;
    }
}

