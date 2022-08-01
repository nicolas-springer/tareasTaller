package gestor;

import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.ClienteDAO;
import dao.ClienteDAO_Hibernate;
import dominio.Cliente;
import dominio.Persona;
import dto.ClienteDTO;
import dominio.Auto;

public class GestorCliente {

	ClienteDAO daoCliente = new ClienteDAO_Hibernate();
	GestorPersona gestorPersona = new GestorPersona();
	
	
	public void darDeAltaCliente(ClienteDTO clienteDTO) throws Exception {
		
		int variable = 0;

		if (gestorPersona.buscarDNI(clienteDTO.getNumeroDocumento()))
			variable = JOptionPane.showConfirmDialog(null, "¿Dar de alta cliente?",
					"Cuidado", JOptionPane.YES_NO_OPTION);

		if (variable == 0) {
			Cliente cliente = new Cliente();
			Persona persona = gestorPersona.darDeAltaPersona(clienteDTO);
			cliente.inicializarCliente(persona);
			daoCliente.guardarCliente(cliente);
		}

		else
			throw new Exception("No se pudo dar de alta el nuevo cliente.");
		
	}
	
	
	public Boolean validarDatosCliente(JTextField textFieldApellido, JTextField textFieldNombre,
			JTextField textFieldDNI, JTextField textFieldTelefono,
			JTextField textFieldCalle,JTextField textFieldNumero,
			JTextField textFieldPiso,JTextField textFieldDepto) throws Exception {

		Boolean dniValido = true, telefonoValido = true, pisoValido = true,
				nombreValido = true,apellidoValido = true, 
				dptoValido = true, numValido = true;

		String mensaje = "Datos invalidos, revisar: " +"\n";
		
		String expression = "^[A-Z][a-z]+";
		
		Pattern formato = Pattern.compile(expression);
		String expDNI = "[1-9][0-9]+";
		Pattern formatoDNI = Pattern.compile(expDNI);

		String expTelefono = "[1-9][0-9]+";
		Pattern formatoTel = Pattern.compile(expTelefono);
		if(!formato.matcher((CharSequence) textFieldApellido.getText()).matches()) {
			mensaje +="Apellido (Ej: Perez)"+"\n";
			apellidoValido=false;
		}
		
		if(!formato.matcher((CharSequence) textFieldNombre.getText()).matches()) {
			mensaje +="Nombre (Ej: Mario)"+"\n";
			nombreValido=false;
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
		else if (textFieldTelefono.getText().toString().length() != 10) {
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
			
		

		if (!dniValido || !telefonoValido || !pisoValido || !dptoValido|| !numValido || !nombreValido || !apellidoValido) {
			throw new Exception(mensaje);
		} else
			return true;
	}


	public List<Cliente> recuperarClientes() {
		
		return daoCliente.recuperarClientes();
	}


	public boolean verificarDNI(String text) {
		return gestorPersona.buscarDNI(Integer.parseInt(text));
	}


	public List<Auto> recuperarAutosClienteDNI(String dni) {
		GestorAuto gAuto = new GestorAuto();
		
		Cliente c = daoCliente.recuperarClienteIDPersona(gestorPersona.recuperarPersonaDNI(dni).getIdpersona());
		return gAuto.recuperarAutosDeClienteID(c.getIdCliente());
	}


	public Cliente recuperarClienteDNI(String text) {
		Persona p = gestorPersona.recuperarPersonaDNI(text);
		if (p==null) {
			return null;
		}else return daoCliente.recuperarClienteIDPersona(p.getIdpersona());
	}

	
}
