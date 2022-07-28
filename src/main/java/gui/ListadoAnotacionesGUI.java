package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dominio.Anotacion;
import gestor.GestorAnotacion;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

public class ListadoAnotacionesGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public ListadoAnotacionesGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 100, 500, 700);
		setTitle("Anotaciones");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(92, 11, 133, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Filtro");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 15, 72, 14);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 96, 464, 502);
		contentPane.add(scrollPane);
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Contenido");
		model.addColumn("Fecha");
		
		GestorAnotacion gAnotacion = new GestorAnotacion();
		List<Anotacion> lista = gAnotacion.recuperarAnotaciones();
		for(Anotacion a: lista) {
			model.addRow(new Object[] {a.getContenido().toString(),a.getFechaCreacion().toString()});
		}
		
		
		table = new JTable(model);
		table.setDefaultEditor(Object.class, null);
		table.getColumnModel().getColumn(0).setPreferredWidth(350);//contenido
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);//fecha
		table.setRowHeight(60);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("New label");
		scrollPane.setColumnHeaderView(label);
		
		JLabel lblNewLabel_1 = new JLabel("Anotaciones:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 67, 108, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnAgregarNota = new JButton("Agregar Nota");
		btnAgregarNota.setBounds(341, 627, 133, 23);
		contentPane.add(btnAgregarNota);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 627, 89, 23);
		contentPane.add(btnVolver);
		
		
		btnVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
	}

}
