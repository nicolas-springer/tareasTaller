package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dominio.Anotacion;
import dominio.Localidad;
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
import com.toedter.calendar.JDateChooser;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

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
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 627, 89, 23);
		contentPane.add(btnVolver);
		
		JButton btnMostrarTodas = new JButton("Mostrar Todas");
		btnMostrarTodas.setBounds(341, 109, 133, 23);
		contentPane.add(btnMostrarTodas);
		
		JPanel panelBusquedaFechas = new JPanel();
		panelBusquedaFechas.setVisible(false);
		
		JPanel panelBusquedaPalabraClave = new JPanel();
		panelBusquedaPalabraClave.setBounds(10, 44, 253, 60);
		contentPane.add(panelBusquedaPalabraClave);
		panelBusquedaPalabraClave.setLayout(null);
		
		JLabel lblPalabreClave = new JLabel("Palabra Clave:");
		lblPalabreClave.setBounds(10, 17, 83, 16);
		panelBusquedaPalabraClave.add(lblPalabreClave);
		lblPalabreClave.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textFieldBusqueda = new JTextField();
		textFieldBusqueda.setBounds(103, 16, 144, 20);
		panelBusquedaPalabraClave.add(textFieldBusqueda);
		textFieldBusqueda.setColumns(10);
		panelBusquedaFechas.setBounds(10, 44, 248, 60);
		contentPane.add(panelBusquedaFechas);
		panelBusquedaFechas.setLayout(null);
		
		JLabel lblPalabreClave_1 = new JLabel("Desde:");
		lblPalabreClave_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPalabreClave_1.setBounds(10, 11, 83, 16);
		panelBusquedaFechas.add(lblPalabreClave_1);
		
		JLabel lblPalabreClave_1_1 = new JLabel("Hasta:");
		lblPalabreClave_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPalabreClave_1_1.setBounds(10, 38, 83, 16);
		panelBusquedaFechas.add(lblPalabreClave_1_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(75, 11, 163, 20);
		panelBusquedaFechas.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(75, 40, 163, 20);
		panelBusquedaFechas.add(dateChooser_1);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(269, 58, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnBorrarTodas = new JButton("Borrar todas");
		btnBorrarTodas.setBounds(366, 609, 108, 23);
		contentPane.add(btnBorrarTodas);
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				if (e.getStateChange() == ItemEvent.SELECTED) {

					if(comboBox.getSelectedIndex()==0) {
						panelBusquedaPalabraClave.setVisible(true);
						panelBusquedaFechas.setVisible(false);
					}
					else {
						panelBusquedaPalabraClave.setVisible(false);
						panelBusquedaFechas.setVisible(true);
					}

				}

			}
		});
		
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
		

		btnMostrarTodas.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					lista = gAnotacion.recuperarAnotaciones();
					model.getDataVector().removeAllElements();
					model.fireTableDataChanged();
					
					for(Anotacion a: lista) {
						JTextArea tx = new JTextArea(a.getContenido().toString());
						tx.setFont(new Font("Tahoma", Font.BOLD, 13));
						model.addRow(new Object[] {tx,a.getFechaCreacion().toString()});
					}
					table.repaint();

				}
			});
			
		}
	
	
	}
