package gestor;

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
			throw new Exception("No se pude dar de alta el nuevo mecanico");

	}

	public Boolean validarDatosMecanico(JTextField textFieldApellido, JTextField textFieldNombre,
			JTextField textFieldDNI, JTextField textFieldTelefono) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/*public Mecanico recuperarMecanico(Integer dni) {
		return daoMecanico.recuperarMecanicoDNI(dni);
	}*/
	
}
