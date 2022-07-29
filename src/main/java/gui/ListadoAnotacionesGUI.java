package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dominio.Anotacion;
import gestor.GestorAnotacion;
import util.RenderListadoAnotaciones;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListadoAnotacionesGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textFieldBusqueda;
	List<Anotacion> lista;
	public ListadoAnotacionesGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 100, 500, 700);
		setTitle("Anotaciones");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(92, 11, 151, 22);
		comboBox.addItem("Palabra clave");
		comboBox.addItem("Entre fechas");
		comboBox.setSelectedIndex(0);
		
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Filtro");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 15, 72, 14);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 136, 464, 462);
		contentPane.add(scrollPane);
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Contenido");
		model.addColumn("Fecha");
		
		GestorAnotacion gAnotacion = new GestorAnotacion();
		lista = gAnotacion.recuperarAnotaciones();
		
		for(Anotacion a: lista) {
			JTextArea tx = new JTextArea(a.getContenido().toString());
			tx.setFont(new Font("Tahoma", Font.BOLD, 13));
			model.addRow(new Object[] {tx,a.getFechaCreacion().toString()});
		}
		
		
		table = new JTable(model);
		
		table.setDefaultRenderer(Object.class, new RenderListadoAnotaciones());
		
		table.setDefaultEditor(Object.class, null);
		table.getColumnModel().getColumn(0).setPreferredWidth(350);//contenido
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);//fecha
		table.setRowHeight(70);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("New label");
		scrollPane.setColumnHeaderView(label);
		
		JLabel lblNewLabel_1 = new JLabel("Anotaciones:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 111, 108, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnAgregarNota = new JButton("Agregar Nota");
		btnAgregarNota.setBounds(341, 627, 133, 23);
		contentPane.add(btnAgregarNota);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 627, 89, 23);
		contentPane.add(btnVolver);
		
		JLabel lblPalabreClave = new JLabel("Palabra Clave:");
		lblPalabreClave.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPalabreClave.setBounds(10, 54, 108, 14);
		contentPane.add(lblPalabreClave);
		
		textFieldBusqueda = new JTextField();
		textFieldBusqueda.setBounds(102, 52, 141, 20);
		contentPane.add(textFieldBusqueda);
		textFieldBusqueda.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(253, 51, 89, 23);
		contentPane.add(btnBuscar);
		
		btnBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex() == 0) {
					//palabra clave
					String palabra= textFieldBusqueda.getText().toString();
					if(palabra.length()==0) {
						JOptionPane.showMessageDialog(null, 
				                "Escriba una palabra clave.", 
				                "CUIDADO", 
				                JOptionPane.WARNING_MESSAGE);
					}
					else {
						lista = gAnotacion.recuperarAnotacionesPalabraClave(palabra);
						if(lista.size()!=0) {
							System.out.println("lista no nula");
							model.getDataVector().removeAllElements();
							model.fireTableDataChanged();
							
							for(Anotacion a: lista) {
								JTextArea tx = new JTextArea(a.getContenido().toString());
								tx.setFont(new Font("Tahoma", Font.BOLD, 13));
								model.addRow(new Object[] {tx,a.getFechaCreacion().toString()});
							}
							table.repaint();
						}
						else {
							JOptionPane.showMessageDialog(null, 
					                "No se encontraron anotaciones con la palabra clave: "+palabra.toUpperCase(), 
					                "CUIDADO", 
					                JOptionPane.WARNING_MESSAGE);
						}
					}
					
				}
				else {
					
				}
				
			}
		});
		

		
		
	}
}
