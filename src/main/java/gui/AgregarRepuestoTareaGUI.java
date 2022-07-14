package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class AgregarRepuestoTareaGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable tablaRepuestos;

	public AgregarRepuestoTareaGUI() {
		setTitle("Agregar repuesto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		generarAgregarRepuestoTareaGUI();
	}
	public void generarAgregarRepuestoTareaGUI() {
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 69, 293, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(79, 27, 132, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Filtrar por:");
		lblNewLabel.setBounds(10, 31, 85, 14);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 123, 453, 181);
		contentPane.add(scrollPane);
		
		tablaRepuestos = new JTable();
		scrollPane.setViewportView(tablaRepuestos);
		
		JButton btnAgregaRepuesto = new JButton("Agregar repuesto");
		btnAgregaRepuesto.setBounds(330, 327, 132, 23);
		contentPane.add(btnAgregaRepuesto);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 427, 89, 23);
		contentPane.add(btnCancelar);
		
		
		
	}
}
