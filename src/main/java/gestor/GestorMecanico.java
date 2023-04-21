package gestor;

import java.util.regex.Pattern;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.MecanicoDAO;
import dao.MecanicoDAO_Hibernate;
import dominio.Mecanico;
import dominio.MecanicoDireccion;
import dominio.Persona;
import dto.MecanicoDTO;



public class GestorMecanico {

	MecanicoDAO daoMecanico = new MecanicoDAO_Hibernate();
	Mecanico mecanico= new Mecanico();
	GestorPersona gestorPersona = new GestorPersona();
	DefaultTableModel dtm;

	public void darDeAltaMecanico(MecanicoDTO mec) throws Exception {

		int variable = 0;

		if (gestorPersona.buscarDNI(mec.getNumeroDocumento()))
			variable = JOptionPane.showConfirmDialog(null, "¿Dar de alta mecanico?",
					"Cuidado", JOptionPane.YES_NO_OPTION);

		if (variable == 0) {

			Persona persona = gestorPersona.darDeAltaPersona(mec);
			mecanico.inicializarMecanico(persona);//pasamos de MecanicoDTO a Objeto Mecanico
			mecanico.setEspecialidad(mec.getEspecialidad().toString());
			daoMecanico.guardarMecanico(mecanico);
		}

		else
			throw new Exception("No se pudo dar de alta el nuevo mecanico");

	}

	public Boolean validarDatosMecanico(JTextField textFieldApellido, JTextField textFieldNombre,
			JTextField textFieldDNI, JTextField textFieldTelefono,
			JTextField textFieldCalle,JTextField textFieldNumero,
			JTextField textFieldPiso,JTextField textFieldDepto) throws Exception {

		Boolean dniValido = true, telefonoValido = true, emailValido = true, pisoValido = true, nombreValido = true,apellidoValido = true, dptoValido = true, numValido = true;

		String mensaje = "Datos invalidos, revisar: " +"\n";
		
		//String expression = "^[A-Z][a-z]+";
		String expression = "^[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+";
		Pattern formato = Pattern.compile(expression);
		String expDNI = "[1-9][0-9]+";
		Pattern formatoDNI = Pattern.compile(expDNI);
		
		String expTelefono = "[1-9][0-9]+";
		Pattern formatoTel = Pattern.compile(expTelefono);
	
		String[] nombres = textFieldNombre.getText().toString().split(" ");
		String[] apellidos = textFieldApellido.getText().toString().split(" ");
		System.out.println(nombres.toString());
		System.out.println(apellidos.toString());
		for(String s: nombres) {
			//System.out.println(s);
			if(!formato.matcher(s).matches()) {
				mensaje +="Nombre (Ej: Mario ó José Luis)"+"\n";
				nombreValido=false;
			}
		}
		
		for(String s: apellidos) {
			//System.out.println(s);
			if(!formato.matcher(s).matches()) {
				mensaje +="Apellido (Ej: Méndez ó Del Valle)"+"\n";
				nombreValido=false;
			}
		}
		if(!formatoDNI.matcher((CharSequence) textFieldDNI.getText()).matches()) {
			mensaje += "El DNI solo debe contener NUMEROS";
		}
		else if (textFieldDNI.getText().toString().length() != 8
				&& textFieldDNI.getText().toString().length() != 7) {
			mensaje += "DNI (Longitud de 8 o 7 numeros)"+"\n";
			dniValido = false;
		}

		
		if(!formatoTel.matcher((CharSequence) textFieldTelefono.getText().toString()).matches()) {
			mensaje+="El TELEFONO solo debe conteners numeros.";
		}
		
		if (textFieldTelefono.getText().toString().length() != 10) {
			mensaje += "TELEFONO (Longitud de 10)"+"\n";
			telefonoValido = false;
		}

		if (textFieldPiso.getText().toString().length() != 0 && Integer.parseInt(textFieldPiso.getText().toString()) < 0)  {
			mensaje += "PISO "+"\n";
			pisoValido = false;
		}
		
		if (textFieldDepto.getText().toString().length() != 0 && Integer.parseInt(textFieldDepto.getText().toString()) < 0)  {
			mensaje += "DEPTO"+"\n";
			dptoValido = false;
		}
		
		if (textFieldDepto.getText().toString().length() != 0 && Integer.parseInt(textFieldDepto.getText().toString()) < 0)  {
			mensaje += "NUMERO"+"\n";
			numValido = false;
		}
			
		

		if (!dniValido || !telefonoValido || !emailValido || !pisoValido || !dptoValido|| !numValido || !nombreValido || !apellidoValido) {
			throw new Exception(mensaje);
		} else
			return true;
	}

	public List<Mecanico> recuperarMecanicos() {
		// TODO Auto-generated method stub
		return daoMecanico.recuperarMecanicos();
	}

	public Mecanico recuperarMecanicoDNI(String dniAsignado) {
		
		Persona p = gestorPersona.recuperarPersonaDNI(dniAsignado);
		return daoMecanico.recuperarMecanicoID(p.getIdpersona());
	}

	public List<Mecanico> recuperarMecanicosConNombre(String nombre) {
		return daoMecanico.recuperarMecanicosConNombre(nombre);
	}

	public MecanicoDireccion getMecanicosDirecciones() {
			return daoMecanico.getMecanicosDirecciones();
	}
	
}
