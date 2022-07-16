package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class Principal extends JFrame {

	private JPanel contentPane;

	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 1280, 720);
		setResizable(false);
		setTitle("Gestiones");
		setLocationRelativeTo(null); 
		generarVentana();

	}

	public void generarVentana() {

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelCentral = new JPanel();
		panelCentral.setBackground(SystemColor.control);
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);

		JButton btnGestionarTareas = new JButton("Gestionar Tareas");
		btnGestionarTareas.setBackground(Color.WHITE);
		btnGestionarTareas.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnGestionarTareas.setBounds(323, 226, 250, 80);
		panelCentral.add(btnGestionarTareas);

		JButton btnGestionarStock = new JButton("Gestionar Stock");
		btnGestionarStock.setBackground(Color.WHITE);
		btnGestionarStock.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnGestionarStock.setBounds(690, 226, 250, 80);
		panelCentral.add(btnGestionarStock);
		
		JButton btnGestionarMecanicos = new JButton("Gestionar Mecanicos");
		btnGestionarMecanicos.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnGestionarMecanicos.setBackground(Color.WHITE);
		btnGestionarMecanicos.setBounds(323, 377, 250, 80);
		panelCentral.add(btnGestionarMecanicos);
		
		JButton btnGestionarClientes = new JButton("Gestionar Clientes");
		btnGestionarClientes.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnGestionarClientes.setBackground(Color.WHITE);
		btnGestionarClientes.setBounds(690, 377, 250, 80);
		panelCentral.add(btnGestionarClientes);


		final ListadoTareasGUI listadoTareas = new ListadoTareasGUI();
		final AltaMecanicoGUI altaMecanico = new AltaMecanicoGUI();
		final AltaClienteGUI altaCliente = new AltaClienteGUI();
		// final GestionStockGUI gestionStock = new
		
		btnGestionarTareas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				listadoTareas.setVisible(true);
				dispose();
			}
		});

		btnGestionarStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				listadoTareas.setVisible(true);
				dispose();
			}
		});
		
		btnGestionarMecanicos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				altaMecanico.setVisible(true);
				//dispose();
			}
		});
		
		btnGestionarClientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				altaCliente.setVisible(true);
				dispose();
			}
		});
//		//btnGestionarListado.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(new JPanel(), "Modalidad a�n no implementada", " ",
//						JOptionPane.INFORMATION_MESSAGE);
//			}
//		});
//
//		//btnGestionarHabitacion.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				final GestionarHabitacion ventanaGH = new GestionarHabitacion();
//				 ventanaGH.setVisible(true);
//				 dispose();
//			}
//		});
//
//		btnGestionarFactura.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				final GestionarFactura ventanaGF = new GestionarFactura();
//				ventanaGF.setVisible(true);
//				dispose();
//				
//			}
//		});

	}

}

