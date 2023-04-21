package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dominio.Localidad;
import dominio.Provincia;
import dominio.ProvinciaLocalidad;
import dto.ClienteDTO;
import dto.MecanicoDTO;
import gestor.GestorCliente;
import gestor.GestorDireccion;
import gestor.GestorLocalidad;
import gestor.GestorMecanico;
import gestor.GestorProvincia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Font;

public class AltaClienteGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCalle;
	private JTextField textFieldDNI;
	private JTextField textFieldPiso;
	private JTextField textFieldDepto;
	private JTextField textFieldNumero;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldTelefono;

	GestorProvincia gestorProvincia = new GestorProvincia();
	GestorLocalidad gestorLocalidad = new GestorLocalidad();
	ProvinciaLocalidad pl = gestorProvincia.recuperarProvinciasLocalidades();
	//List<Provincia> listaProvinciasArg = gestorProvincia.recuperarProvincias();
	
	GestorCliente gCliente= new GestorCliente();
	GestorDireccion gDireccion = new GestorDireccion();
	
	public AltaClienteGUI() {
		setTitle("Dar alta cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		generarAltaClienteGUI();
	}
	public void generarAltaClienteGUI() {
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Complete los campos para dar de alta un cliente:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(25, 25, 348, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombres:");
		lblNewLabel_1.setBounds(25, 50, 62, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido:");
		lblNewLabel_2.setBounds(25, 75, 62, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DNI:");
		lblNewLabel_3.setBounds(25, 100, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Provincia:");
		lblNewLabel_4.setBounds(25, 125, 68, 14);
		contentPane.add(lblNewLabel_4);
		
		JComboBox<String> comboBoxProvincias = new JComboBox<String>();
		comboBoxProvincias.setBounds(90, 121, 118, 22);
		contentPane.add(comboBoxProvincias);
		//comboBoxProvincias.addItem("Santa Fe");
		for (Provincia p : pl.getProvincias()) {
			comboBoxProvincias.addItem(p.getNombre().toString());
		}
		comboBoxProvincias.setSelectedItem("Santa Fe");
		
		
		
		JLabel lblNewLabel_5 = new JLabel("Localidad:");
		lblNewLabel_5.setBounds(218, 125, 68, 14);
		contentPane.add(lblNewLabel_5);
		
		JComboBox<String> comboBoxLocalidad = new JComboBox<String>();
		comboBoxLocalidad.setBounds(280, 121, 182, 22);
		contentPane.add(comboBoxLocalidad);
		
		JLabel lblNewLabel_6 = new JLabel("Calle:");
		lblNewLabel_6.setBounds(25, 150, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		textFieldCalle = new JTextField();
		textFieldCalle.setBounds(90, 147, 196, 20);
		contentPane.add(textFieldCalle);
		textFieldCalle.setColumns(10);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setBounds(90, 97, 86, 20);
		contentPane.add(textFieldDNI);
		textFieldDNI.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Piso:");
		lblNewLabel_7.setBounds(25, 175, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		textFieldPiso = new JTextField();
		textFieldPiso.setBounds(90, 172, 46, 20);
		contentPane.add(textFieldPiso);
		textFieldPiso.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Depto:");
		lblNewLabel_8.setBounds(185, 175, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		textFieldDepto = new JTextField();
		textFieldDepto.setBounds(241, 172, 46, 20);
		contentPane.add(textFieldDepto);
		textFieldDepto.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Numero:");
		lblNewLabel_9.setBounds(311, 150, 62, 14);
		contentPane.add(lblNewLabel_9);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setBounds(376, 147, 86, 20);
		contentPane.add(textFieldNumero);
		textFieldNumero.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(25, 327, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnDarAlta = new JButton("Dar de alta");
		btnDarAlta.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDarAlta.setBounds(345, 327, 107, 23);
		contentPane.add(btnDarAlta);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(90, 50, 197, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(90, 72, 197, 20);
		contentPane.add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Telefono:");
		lblNewLabel_11.setBounds(25, 200, 62, 14);
		contentPane.add(lblNewLabel_11);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setBounds(90, 197, 86, 20);
		contentPane.add(textFieldTelefono);
		textFieldTelefono.setColumns(10);
		
		for (Localidad l : pl.getLocalidades()) {
			if(l.getProvincia().getNombre().equals("Santa Fe"))
				{
				comboBoxLocalidad.addItem(l.getNombre().toString());
				}
		}
		
		//al seleccionar una provincia del drop box se van a mostrar las localidades de dicha provincia
		comboBoxProvincias.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				if (e.getStateChange() == ItemEvent.SELECTED) {

					comboBoxLocalidad.removeAllItems();

					//List<Localidad> localidadesSegunProvincia = gestorLocalidad.obtenerLocalidades(comboBoxProvincias.getSelectedItem().toString());
					String saux = comboBoxProvincias.getSelectedItem().toString();
					for (Localidad l : pl.getLocalidades()) {
						if(l.getProvincia().getNombre().equals(saux))
							{
							comboBoxLocalidad.addItem(l.getNombre().toString());
							}
					}

				}

			}
		});

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnDarAlta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				List<JTextField> avalidar = new ArrayList<JTextField>();
				avalidar.add(textFieldApellido);
				avalidar.add(textFieldNombre);
				avalidar.add(textFieldDNI);
				avalidar.add(textFieldTelefono);
				avalidar.add(textFieldCalle);

				boolean hayvacios = validarHayVacios(avalidar);

	
				if (hayvacios) {
					JOptionPane.showMessageDialog(null, "Existen campos sin completar");
				}
				else {

					try {

						Boolean validarDatosCliente = gCliente.validarDatosCliente(textFieldApellido,textFieldNombre,textFieldDNI,textFieldTelefono,textFieldCalle,textFieldNumero,textFieldPiso,textFieldDepto);
						if (validarDatosCliente) {
							System.out.println("datoscliente " + validarDatosCliente);
							ClienteDTO clienteDTO= new ClienteDTO();

							clienteDTO.setApellido(textFieldApellido.getText().toString());
							clienteDTO.setNombre(textFieldNombre.getText().toString());
							clienteDTO.setNumeroDocumento(Integer.parseInt(textFieldDNI.getText().toString()));
							clienteDTO.setTelefono(textFieldTelefono.getText().toString());
							clienteDTO.setProvincia(comboBoxProvincias.getSelectedItem().toString());
							clienteDTO.setCalle(textFieldCalle.getText().toString());
							clienteDTO.setNumeroCalle(Integer.parseInt(textFieldNumero.getText().toString()));
							clienteDTO.setLocalidad(comboBoxLocalidad.getSelectedItem().toString());
							//System.out.println(comboBoxLocalidad.getSelectedItem().toString());
							clienteDTO.setProvincia(comboBoxProvincias.getSelectedItem().toString());
							//System.out.println(comboBoxProvincias.getSelectedItem().toString());
							
							//en caso de no vivir en departamento se asigna 0 como valor default
							if (!textFieldDepto.getText().isEmpty())
								clienteDTO.setDepartamento(Integer.parseInt(textFieldDepto.getText().toString()));
							else clienteDTO.setDepartamento(0); 
							if (!textFieldPiso.getText().isEmpty())
								clienteDTO.setPiso(Integer.parseInt(textFieldPiso.getText().toString()));
							else clienteDTO.setPiso(0);
							try {
								gCliente.darDeAltaCliente(clienteDTO);
								JOptionPane.showMessageDialog(null, "Datos cargados correctamente");
								dispose();
							} catch (Exception e1) {
								JOptionPane.showMessageDialog(new JPanel(), e1.getMessage(), "Error",
										JOptionPane.ERROR_MESSAGE);
								throw e1;
							}
						}

					} catch (Exception e2) {
						JOptionPane.showMessageDialog(new JPanel(), e2.getMessage(), "Error",
								JOptionPane.ERROR_MESSAGE);
					}

				}

			}
		});
		
		
		
		
	}
	boolean validarHayVacios(List<JTextField> av) {
		boolean flag = false;
	for (JTextField j : av) {
		
		if (j.getText().isEmpty()) {
			flag=true;
			j.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
		}
		else {
			j.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
		}
		
	}
		
		
		return flag;
		
	}
}

	
