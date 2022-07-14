package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

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
		panelCentral.setBackground(new Color(102, 204, 255));
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);

		JButton btnGestionarTareas = new JButton("Gestionar Tareas");
		btnGestionarTareas.setBackground(Color.WHITE);
		btnGestionarTareas.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnGestionarTareas.setBounds(362, 196, 250, 80);
		panelCentral.add(btnGestionarTareas);

		JButton btnGestionarStock = new JButton("Gestionar Stock");
		btnGestionarStock.setBackground(Color.WHITE);
		btnGestionarStock.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnGestionarStock.setBounds(362, 372, 250, 80);
		panelCentral.add(btnGestionarStock);


		final ListadoTareasGUI listadoTareas = new ListadoTareasGUI();

		btnGestionarTareas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				listadoTareas.setVisible(true);
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

