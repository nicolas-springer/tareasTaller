package gestor;

import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JTextField;

import dao.AutoDAO;
import dao.AutoDAO_Hibernate;
import dominio.Auto;
import dominio.Cliente;
import dto.AutoDTO;

public class GestorAuto {

	AutoDAO daoAuto = new AutoDAO_Hibernate();
	
	public List<Auto> recuperarAutosDeClienteID(int id) {
		return daoAuto.recuperarAutosDeClienteID(id);
	}

	public void darDeAltaAuto(AutoDTO autodto) {
		GestorCliente gCliente = new GestorCliente();
		Cliente c = gCliente.recuperarClienteDNI(autodto.getDnicliente());
		
		Auto a = new Auto();
		a.inicializarAuto(autodto.getPatente(),autodto.getMarca(),autodto.getModelo(),c);
		System.out.println("puntero auto: "+a);
		System.out.println(a.getMarca().toString());
		System.out.println(a.getModelo().toString());
		System.out.println(a.getPatente().toString());
		System.out.println(a.getCliente());
	
		daoAuto.guardarAuto(a);
	}

	public Boolean validarDatos(JTextField textModelo, JTextField textPatente) throws Exception {
	
		Boolean marca = true, patente = true, modelo = true;

		String mensaje = "Datos invalidos, revisar: " +"\n";
		
		String exp6 = "[A-Z]{1}[A-Z]{1}[A-Z]{1}[0-9]{1}[0-9]{1}[0-9]{1}";
		String exp7 = "[A-Z]{1}[A-Z]{1}[0-9]{1}[0-9]{1}[0-9]{1}[A-Z]{1}[A-Z]";
		String expM = "[a-zA-Z]+";
		
		Pattern formatoPatente6 = Pattern.compile(exp6);
		Pattern formatoPatente7 = Pattern.compile(exp7);
		Pattern formatoM = Pattern.compile(expM);
		/*if(!formatoM.matcher((CharSequence) textMarca.getText()).matches()) {
			mensaje +=" Marca (Ej: Fiat)"+"\n";
			marca=false;
		}*/
		
		if(!formatoM.matcher((CharSequence) textModelo.getText()).matches()) {
			mensaje +=" Modelo (Ej: Punto)"+"\n";
			modelo=false;
		}
		
		if (textPatente.getText().toString().length() != 6
				&& textPatente.getText().toString().length() != 7) {
			mensaje += " Patente (Longitud de 6 o 7)"+"\n";
			patente = false;
			
		}
		else {
			if(textPatente.getText().toString().length() == 6) {
				if(!(formatoPatente6.matcher((CharSequence)textPatente.getText()).matches())) {
					patente = false;
					mensaje += " (Formato debe ser: LLLNNN)"+"\n";
				}
			}
			else {
				if (!(formatoPatente7.matcher((CharSequence)textPatente.getText()).matches())) {
					patente = false;
					System.out.println(textPatente.getText());
					mensaje += " (Formato debe ser: LLNNNLL)"+"\n";
				}
			}
		}

		

		if (!marca || !modelo || !patente) {
			throw new Exception(mensaje);
		} else
		{
			Auto a = recuperarAutoConPatente(textPatente.getText().toString());
			if( a!=null) {
				throw new Exception("Ya existe un vehiculo con la patente: "+textPatente.getText().toString().toUpperCase());
			}
			else {
				return true;
			}
		}
	}



	public Auto recuperarAutoConPatente(String pat) {
		return daoAuto.recuperarAutoConPatente(pat);
	}
	


}
