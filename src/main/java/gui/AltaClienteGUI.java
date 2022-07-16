package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
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
		
		JLabel lblNewLabel = new JLabel("Complete los campos para dar de alta un CLIENTE:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(25, 25, 348, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombres:");
		lblNewLabel_1.setBounds(25, 50, 62, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido:");
		lblNewLabel_2.setBounds(25, 75, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DNI");
		lblNewLabel_3.setBounds(25, 100, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Provincia");
		lblNewLabel_4.setBounds(25, 125, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JComboBox comboBoxProvincias = new JComboBox();
		comboBoxProvincias.setBounds(81, 121, 93, 22);
		contentPane.add(comboBoxProvincias);
		
		JLabel lblNewLabel_5 = new JLabel("Localidad");
		lblNewLabel_5.setBounds(218, 125, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JComboBox comboBoxLocalidad = new JComboBox();
		comboBoxLocalidad.setBounds(274, 121, 178, 22);
		contentPane.add(comboBoxLocalidad);
		
		JLabel lblNewLabel_6 = new JLabel("Calle");
		lblNewLabel_6.setBounds(25, 150, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		textFieldCalle = new JTextField();
		textFieldCalle.setBounds(81, 147, 197, 20);
		contentPane.add(textFieldCalle);
		textFieldCalle.setColumns(10);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setBounds(81, 97, 86, 20);
		contentPane.add(textFieldDNI);
		textFieldDNI.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Piso");
		lblNewLabel_7.setBounds(25, 175, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		textFieldPiso = new JTextField();
		textFieldPiso.setBounds(81, 172, 46, 20);
		contentPane.add(textFieldPiso);
		textFieldPiso.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Depto:");
		lblNewLabel_8.setBounds(151, 175, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		textFieldDepto = new JTextField();
		textFieldDepto.setBounds(207, 172, 46, 20);
		contentPane.add(textFieldDepto);
		textFieldDepto.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Numero:");
		lblNewLabel_9.setBounds(311, 150, 46, 14);
		contentPane.add(lblNewLabel_9);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setBounds(366, 147, 86, 20);
		contentPane.add(textFieldNumero);
		textFieldNumero.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(25, 327, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnNewButton = new JButton("Dar de alta");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(345, 327, 107, 23);
		contentPane.add(btnNewButton);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(81, 47, 197, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(81, 72, 197, 20);
		contentPane.add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Telefono:");
		lblNewLabel_11.setBounds(25, 200, 46, 14);
		contentPane.add(lblNewLabel_11);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setBounds(81, 197, 86, 20);
		contentPane.add(textFieldTelefono);
		textFieldTelefono.setColumns(10);
		
		
		
		
	}
}

