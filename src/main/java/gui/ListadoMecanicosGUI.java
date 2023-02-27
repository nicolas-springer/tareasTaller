package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dominio.Anotacion;
import dominio.Direccion;
import dominio.Localidad;
import dominio.Mecanico;
import gestor.GestorDireccion;
import gestor.GestorLocalidad;
import gestor.GestorMecanico;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Pattern;
import java.awt.Font;
import javax.swing.JScrollPane;

public class ListadoMecanicosGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldBusqueda;
	private JTable table;
	List<Mecanico> listaMec;
	public ListadoMecanicosGUI() {

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(300, 150, 1280, 720);
			setResizable(false);
			setTitle("Gestion Mecanicos");
			setLocationRelativeTo(null); 
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Filtrar por:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNewLabel.setBounds(34, 46, 89, 14);
			contentPane.add(lblNewLabel);
			
			JComboBox<String> comboBox = new JComboBox<String>();
			comboBox.setBounds(135, 42, 146, 22);
			contentPane.add(comboBox);
			
			comboBox.addItem("Nombre");
			comboBox.addItem("Apellido");
			comboBox.addItem("DNI");
			comboBox.addItem("Especialidad");
			
			
			
			JLabel lblNewLabel_1 = new JLabel("Busqueda:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNewLabel_1.setBounds(34, 85, 89, 14);
			contentPane.add(lblNewLabel_1);
			
			textFieldBusqueda = new JTextField();
			textFieldBusqueda.setBounds(135, 82, 146, 20);
			contentPane.add(textFieldBusqueda);
			textFieldBusqueda.setColumns(10);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(34, 155, 1188, 299);
			contentPane.add(scrollPane);
			
			String[] colTareas= {"Apellido", "Nombre", "DNI","Telefono", "Calle" , "Numero", "Piso", "Depto","Localidad","Especialidad"};			
			DefaultTableModel model = new DefaultTableModel();
			
			final GestorMecanico gMecanico= new GestorMecanico();
			listaMec = gMecanico.recuperarMecanicos();
			final GestorDireccion gDireccion = new GestorDireccion();
			final GestorLocalidad gLocalidad = new GestorLocalidad();
			
			for (String s : colTareas) model.addColumn(s);

			// DEBERIA TRAER TODAS LA DIRECCIONES ANTES
			// guardar direcciones como strings y listo
			for(Mecanico m : listaMec) {
				
				//Direccion d = m.getPersona().getDireccion();	
				//Localidad l = d.getLocalidad();
				Direccion d = gDireccion.recuperarDireccion(m.getPersona().getDireccion().getId_Direccion());
				Localidad l = gLocalidad.recuperarLocalidadID(d.getLocalidad().getIdLocalidad());
				//System.out.println(m.getPersona().getDireccion().getCalle());
				model.addRow(new Object[]{m.getPersona().getApellido(),m.getPersona().getNombre(),
						m.getPersona().getNumeroDocumento(),m.getPersona().getTelefono(),
						d.getCalle(),d.getNumero(),d.getPiso(),d.getPiso(),l.getNombre(),
						m.getEspecialidad().toString()});
			}
			
			table = new JTable(model);
			table.setDefaultEditor(Object.class, null);
			table.getColumnModel().getColumn(0).setPreferredWidth(100);//nombre
			table.getColumnModel().getColumn(1).setPreferredWidth(100);//apelllido
			table.getColumnModel().getColumn(2).setPreferredWidth(70);//dni
			table.getColumnModel().getColumn(3).setPreferredWidth(70);//telefono
			table.getColumnModel().getColumn(4).setPreferredWidth(120);//calle
			table.getColumnModel().getColumn(5).setPreferredWidth(40);//numero
			table.getColumnModel().getColumn(6).setPreferredWidth(20);//piso
			table.getColumnModel().getColumn(7).setPreferredWidth(20);//depto
			table.getColumnModel().getColumn(8).setPreferredWidth(50);//localidad
			table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);//especialidad
			scrollPane.setViewportView(table);
			
			JButton btnVolver = new JButton("Volver");
			btnVolver.setBounds(34, 628, 89, 23);
			contentPane.add(btnVolver);
			
			JButton btnAltaMecanico = new JButton("Alta Mecanico");
			btnAltaMecanico.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnAltaMecanico.setBackground(SystemColor.activeCaption);
			btnAltaMecanico.setBounds(1044, 46, 178, 52);
			contentPane.add(btnAltaMecanico);
			
			JLabel lblNewLabel_2 = new JLabel("Listado de mecanicos");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_2.setBounds(34, 128, 146, 14);
			contentPane.add(lblNewLabel_2);
			
			JButton btnBuscar = new JButton("Buscar");
			btnBuscar.setBounds(304, 82, 89, 23);
			contentPane.add(btnBuscar);
			
			JButton btnMostrarTodos = new JButton("Mostrar Todos");
			btnMostrarTodos.setBounds(192, 125, 135, 23);
			contentPane.add(btnMostrarTodos);
			
			
			btnVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MenuPrincipal mp = new MenuPrincipal();
					mp.setVisible(true);
					dispose();
				}
			});
			btnAltaMecanico.addActionListener(new ActionListener() {
				@Override
				
				public void actionPerformed(ActionEvent e) {
					AltaMecanicoGUI altaMecanico = new AltaMecanicoGUI();
					altaMecanico.setVisible(true);
					//dispose();
				}
			});
			
			
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int key = comboBox.getSelectedIndex();
					List<Mecanico> lista;
					boolean existe = false;
					Direccion d;
					Localidad l;
					switch (key) {
					case 0:
						
						String nombre= textFieldBusqueda.getText().toString();
						if(nombre.length()==0) {
							JOptionPane.showMessageDialog(null, 
					                "Escriba un nombre.", 
					                "CUIDADO", 
					                JOptionPane.WARNING_MESSAGE);
						}
						else {
								model.getDataVector().removeAllElements();
								model.fireTableDataChanged();
								for(Mecanico m : listaMec) {
									if(m.getPersona().getNombre().toString().toLowerCase().equals(nombre.toLowerCase())) {
										existe=true;
										d = gDireccion.recuperarDireccion(m.getPersona().getDireccion().getId_Direccion());
										l = gLocalidad.recuperarLocalidadID(d.getLocalidad().getIdLocalidad());
										model.addRow(new Object[]{m.getPersona().getApellido(),m.getPersona().getNombre(),
												m.getPersona().getNumeroDocumento(),m.getPersona().getTelefono(),
												d.getCalle(),d.getNumero(),d.getPiso(),d.getPiso(),l.getNombre(),
												m.getEspecialidad().toString()});
									}
									
								}
								if(existe)
									
									{
									table.repaint();
									}
								else {
									JOptionPane.showMessageDialog(null, 
							                "No se encontraron mecanicos con el nombre: "+nombre.toUpperCase(), 
							                "CUIDADO", 
							                JOptionPane.WARNING_MESSAGE);
								}
							}
						
						break;	
						case 1:
						
						String apellido= textFieldBusqueda.getText().toString();
						if(apellido.length()==0) {
							JOptionPane.showMessageDialog(null, 
					                "Escriba un apellido.", 
					                "CUIDADO", 
					                JOptionPane.WARNING_MESSAGE);
						}
						else {
								model.getDataVector().removeAllElements();
								model.fireTableDataChanged();
								for(Mecanico m : listaMec) {
									if(m.getPersona().getApellido().toString().toLowerCase().equals(apellido.toLowerCase())) {
										existe=true;
										d = gDireccion.recuperarDireccion(m.getPersona().getDireccion().getId_Direccion());
										l = gLocalidad.recuperarLocalidadID(d.getLocalidad().getIdLocalidad());
										model.addRow(new Object[]{m.getPersona().getApellido(),m.getPersona().getNombre(),
												m.getPersona().getNumeroDocumento(),m.getPersona().getTelefono(),
												d.getCalle(),d.getNumero(),d.getPiso(),d.getPiso(),l.getNombre(),
												m.getEspecialidad().toString()});
									}
									
								}
								if(existe)
									
									{
									table.repaint();
									}
								else {
									JOptionPane.showMessageDialog(null, 
							                "No se encontraron mecanicos con el apellido: "+apellido.toUpperCase(), 
							                "CUIDADO", 
							                JOptionPane.WARNING_MESSAGE);
								}
							}
						
						break;
						case 2:
							
							String expDNI = "[1-9][0-9]+";
							Pattern formatoDNI = Pattern.compile(expDNI);
							
							String dni= textFieldBusqueda.getText().toString();
							if(dni.length()==0) {
								JOptionPane.showMessageDialog(null, 
						                "Escriba un numero DNI.", 
						                "CUIDADO", 
						                JOptionPane.WARNING_MESSAGE);
							}	
							else {
								
								if(!formatoDNI.matcher((CharSequence) dni).matches()) {
									JOptionPane.showMessageDialog(null, 
											"El DNI solo debe contener NUMEROS", 
							                "CUIDADO", 
							                JOptionPane.WARNING_MESSAGE);
								}
								else if (dni.length() != 8
										&& dni.length() != 7) {
									JOptionPane.showMessageDialog(null, 
											"DNI (Longitud de 8 o 7 numeros)", 
							                "CUIDADO", 
							                JOptionPane.WARNING_MESSAGE);
								}
									else {//dni valido
									
									model.getDataVector().removeAllElements();
									model.fireTableDataChanged();
									for(Mecanico m : listaMec) {
										if(m.getPersona().getNumeroDocumento().toString().equals(dni)) {
											existe=true;
											d = gDireccion.recuperarDireccion(m.getPersona().getDireccion().getId_Direccion());
											l = gLocalidad.recuperarLocalidadID(d.getLocalidad().getIdLocalidad());
											model.addRow(new Object[]{m.getPersona().getApellido(),m.getPersona().getNombre(),
													m.getPersona().getNumeroDocumento(),m.getPersona().getTelefono(),
													d.getCalle(),d.getNumero(),d.getPiso(),d.getPiso(),l.getNombre(),
													m.getEspecialidad().toString()});
										}
										
									}
									if(existe)
										
										{
										table.repaint();
										}
									else {
										JOptionPane.showMessageDialog(null, 
								                "No se encontraron mecanicos con el numero DNI: "+dni.toUpperCase(), 
								                "CUIDADO", 
								                JOptionPane.WARNING_MESSAGE);
									}
								}
									
								}
							
							break;
							case 3:
							
							String especialidad= textFieldBusqueda.getText().toString();
							if(especialidad.length()==0) {
								JOptionPane.showMessageDialog(null, 
						                "Escriba una especialidad.", 
						                "CUIDADO", 
						                JOptionPane.WARNING_MESSAGE);
							}
							else {
									model.getDataVector().removeAllElements();
									model.fireTableDataChanged();
									for(Mecanico m : listaMec) {
										if(m.getEspecialidad().contains(especialidad)) {
											existe=true;
											d = gDireccion.recuperarDireccion(m.getPersona().getDireccion().getId_Direccion());
											l = gLocalidad.recuperarLocalidadID(d.getLocalidad().getIdLocalidad());
											model.addRow(new Object[]{m.getPersona().getApellido(),m.getPersona().getNombre(),
													m.getPersona().getNumeroDocumento(),m.getPersona().getTelefono(),
													d.getCalle(),d.getNumero(),d.getPiso(),d.getPiso(),l.getNombre(),
													m.getEspecialidad().toString()});
										}
										
									}
									if(existe)
										
										{
										table.repaint();
										}
									else {
										JOptionPane.showMessageDialog(null, 
								                "No se encontraron mecanicos con la especialidad: "+especialidad.toUpperCase(), 
								                "CUIDADO", 
								                JOptionPane.WARNING_MESSAGE);
									}
								}
							
							break;
							}//end switch
						}
					
			});
			
			
			btnMostrarTodos.addActionListener(new ActionListener() {
				@Override
				
				public void actionPerformed(ActionEvent e) {
					model.getDataVector().removeAllElements();
					model.fireTableDataChanged();
					for(Mecanico m : listaMec) {
						Direccion d = gDireccion.recuperarDireccion(m.getPersona().getDireccion().getId_Direccion());
						Localidad l = gLocalidad.recuperarLocalidadID(d.getLocalidad().getIdLocalidad());
						model.addRow(new Object[]{m.getPersona().getApellido(),m.getPersona().getNombre(),
								m.getPersona().getNumeroDocumento(),m.getPersona().getTelefono(),
								d.getCalle(),d.getNumero(),d.getPiso(),d.getPiso(),l.getNombre(),
								m.getEspecialidad().toString()});
					}
					table.repaint();
				}
			});
	}
}
	
