package gestor;

import java.util.regex.Pattern;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.MecanicoDAO;
import dao.MecanicoDAO_Hibernate;
import dominio.Mecanico;
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
		
		String expression = "^[A-Z][a-z]+";
		
		Pattern formato = Pattern.compile(expression);
		
		if(!formato.matcher((CharSequence) textFieldApellido.getText()).matches()) {
			mensaje +="Apellido (Ej: Perez)"+"\n";
			apellidoValido=false;
		}
		
		if(!formato.matcher((CharSequence) textFieldNombre.getText()).matches()) {
			mensaje +="Nombre (Ej: Mario)"+"\n";
			nombreValido=false;
		}
		
		if (textFieldDNI.getText().toString().length() != 8
				&& textFieldDNI.getText().toString().length() != 7) {
			mensaje += "DNI (Longitud de 8 o 7)"+"\n";
			dniValido = false;
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
	
}
