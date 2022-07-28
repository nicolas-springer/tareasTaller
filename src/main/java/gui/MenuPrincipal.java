package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.SystemColor;
import javax.swing.border.LineBorder;

import gestor.GestorAnotacion;

import java.awt.Color;

@SuppressWarnings("serial")
public class MenuPrincipal extends JFrame {

	private JPanel contentPane;

	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 1280, 720);
		setResizable(false);
		setTitle("Gestiones");
		setLocationRelativeTo(null); 
		//cargar localidades y provincias sql
		//GestorProvincia gp = new GestorProvincia();
		//GestorLocalidad gl = new GestorLocalidad();
		//gp.cargarProvinciasBD();
		//gl.cargarLocalidadesBD();
		generarMenuPrincipal();

	}

	public void generarMenuPrincipal() {

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(SystemColor.activeCaptionBorder);
		separator.setBounds(316, 30, 3, 620);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBackground(SystemColor.activeCaptionBorder);
		separator_1.setBounds(632, 30, 3, 620);
		contentPane.add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1.setBackground(SystemColor.activeCaptionBorder);
		separator_1_1.setBounds(948, 30, 3, 620);
		contentPane.add(separator_1_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 10, 1264, 2);
		contentPane.add(separator_2);
		
		JLabel lblNewLabel = new JLabel("GESTION FACTURAS");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(50, 30, 200, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblGestionStock = new JLabel("GESTION STOCK");
		lblGestionStock.setFont(new Font("Arial", Font.PLAIN, 20));
		lblGestionStock.setBounds(50, 370, 199, 31);
		contentPane.add(lblGestionStock);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(0, 340, 1264, 3);
		contentPane.add(separator_2_1);
		
		JSeparator separator_2_2 = new JSeparator();
		separator_2_2.setBounds(0, 671, 1264, 2);
		contentPane.add(separator_2_2);
		
		JLabel lblGestionTareas = new JLabel("GESTION TAREAS");
		lblGestionTareas.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionTareas.setFont(new Font("Arial", Font.PLAIN, 20));
		lblGestionTareas.setBounds(374, 30, 200, 31);
		contentPane.add(lblGestionTareas);
		
		JLabel lblNewLabel_1_1 = new JLabel("GESTION CLIENTES");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(690, 30, 200, 31);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("GESTION MECANICOS");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_1_2.setBounds(356, 370, 248, 31);
		contentPane.add(lblNewLabel_1_1_2);
		
		JButton btnListadoTarea = new JButton("Listado de tareas");
		btnListadoTarea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnListadoTarea.setBounds(361, 94, 220, 40);
		contentPane.add(btnListadoTarea);
		
		JButton btnAgregarTarea = new JButton("Agregar tarea");
		btnAgregarTarea.setBounds(361, 156, 220, 40);
		contentPane.add(btnAgregarTarea);
		
		JButton btnListadoDeClientes = new JButton("Listado de clientes");
		btnListadoDeClientes.setBounds(699, 94, 220, 40);
		contentPane.add(btnListadoDeClientes);
		
		JButton btnCargarNuevoCliente = new JButton("Cargar nuevo cliente");
		btnCargarNuevoCliente.setBounds(699, 156, 220, 40);
		contentPane.add(btnCargarNuevoCliente);
		
		JButton btnCargarNuevoMecanico = new JButton("Cargar nuevo mecanico");
		btnCargarNuevoMecanico.setBounds(407, 475, 180, 23);
		contentPane.add(btnCargarNuevoMecanico);
		
		JButton btnListadoDeMecanicos = new JButton("Listado de mecanicos");
		btnListadoDeMecanicos.setBounds(407, 424, 180, 23);
		contentPane.add(btnListadoDeMecanicos);
		
		JLabel lblNewLabel_1 = new JLabel("enlace a explorador google");
		lblNewLabel_1.setBounds(991, 71, 136, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("encale a bandeja de correo");
		lblNewLabel_2.setBounds(991, 98, 136, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Anotaciones:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(959, 349, 125, 31);
		contentPane.add(lblNewLabel_3);
		
		JButton btnGuardarNota = new JButton("Guardar Nota");
		btnGuardarNota.setBounds(1142, 627, 112, 23);
		contentPane.add(btnGuardarNota);
		
		JButton btnVerNotas = new JButton("Ver Notas");
		btnVerNotas.setBounds(961, 627, 112, 23);
		contentPane.add(btnVerNotas);
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBorder(new LineBorder(Color.GRAY));
		textArea.setBounds(961, 391, 293, 225);
		contentPane.add(textArea);
		
		
	
		btnListadoDeMecanicos.addActionListener(new ActionListener() {
			@Override
			
			public void actionPerformed(ActionEvent e) {
				
				final ListadoMecanicosGUI listaMec = new ListadoMecanicosGUI();
				listaMec.setVisible(true);
				dispose();
			}
		});
		btnCargarNuevoMecanico.addActionListener(new ActionListener() {
			@Override
			
			public void actionPerformed(ActionEvent e) {
				AltaMecanicoGUI altaMecanico = new AltaMecanicoGUI();
				altaMecanico.setVisible(true);
				//dispose();
			}
		});
		
		btnListadoTarea.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				final ListadoTareasGUI listadoTareas = new ListadoTareasGUI();
				listadoTareas.setVisible(true);
				dispose();
			}
		});
		btnAgregarTarea.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("test");
			}
		});
		
		btnListadoDeClientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				final ListadoClientesGUI listado = new ListadoClientesGUI();
				listado.setVisible(true);
				dispose();
			}
		});
		
		
		
		btnCargarNuevoCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				final AltaClienteGUI altaCliente = new AltaClienteGUI();
				altaCliente.setVisible(true);
			}
		});
		
		btnGuardarNota.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GestorAnotacion gAnotacion = new GestorAnotacion();
				gAnotacion.darAltaNota(textArea.getText());
			}
		});
		btnVerNotas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//ventana de notas
				final ListadoAnotacionesGUI la = new ListadoAnotacionesGUI();
				la.setLocationRelativeTo(null);
				la.setVisible(true);
			}
		});

		btnAgregarTarea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
	}
}

