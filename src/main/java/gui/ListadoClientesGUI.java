package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dominio.Cliente;
import dominio.ClienteDireccion;
import dominio.Direccion;
import dominio.Localidad;
import dominio.Mecanico;
import gestor.GestorCliente;
import gestor.GestorDireccion;
import gestor.GestorLocalidad;
import gestor.GestorMecanico;

public class ListadoClientesGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldBusqueda;
	private JTable table;
	//List<Cliente> listaClientes;
	ClienteDireccion cd;
	public ListadoClientesGUI() {

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(300, 150, 1280, 720);
			setResizable(false);
			setTitle("Gestion Clientes");
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
			comboBox.setBounds(135, 42, 110, 22);
			contentPane.add(comboBox);
			
			comboBox.addItem("Nombre");
			comboBox.addItem("Apellido");
			comboBox.addItem("DNI");
			
			
			JLabel lblNewLabel_1 = new JLabel("Busqueda:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNewLabel_1.setBounds(34, 85, 89, 14);
			contentPane.add(lblNewLabel_1);
			
			textFieldBusqueda = new JTextField();
			textFieldBusqueda.setBounds(135, 82, 110, 20);
			contentPane.add(textFieldBusqueda);
			textFieldBusqueda.setColumns(10);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(34, 155, 1188, 299);
			contentPane.add(scrollPane);
			
			String[] colTareas= {"Apellido", "Nombre", "DNI","Telefono", "Calle" , "Numero", "Piso", "Depto","Localidad"};
			//Object[][] datosFilaMecanicos = { };
			
			DefaultTableModel model = new DefaultTableModel();
			
			final GestorCliente gCliente= new GestorCliente();
			//listaClientes = gCliente.recuperarClientes();
			//final GestorDireccion gDireccion = new GestorDireccion();
			//final GestorLocalidad gLocalidad = new GestorLocalidad();
			
			cd = gCliente.getClientesDirecciones();
			
			for (String s : colTareas) model.addColumn(s);

			for(Cliente c : cd.getClientes()) {
				//Direccion d = gDireccion.recuperarDireccion(c.getPersona().getDireccion().getId_Direccion());
				//Localidad l = gLocalidad.recuperarLocalidadID(d.getLocalidad().getIdLocalidad());
				String calle="";
				String numero="";
				String piso="";
				String dpto ="";
				String localidad ="";
				for(Direccion d : cd.getDirecciones()) {	
					if(d.getId_Direccion() == c.getPersona().getDireccion().getId_Direccion()) {
						System.out.println(d.getId_Direccion());
						calle=d.getCalle();
						numero=d.getNumero().toString();
						piso=d.getPiso().toString();
						dpto= d.getDto().toString();
						localidad=d.getLocalidad();
						break;
					}	
				}
				
				model.addRow(new Object[]{c.getPersona().getApellido(),c.getPersona().getNombre(),
						c.getPersona().getNumeroDocumento(),c.getPersona().getTelefono(),
						calle,numero,piso,dpto,localidad});
			}
			
			table = new JTable(model);
			table.setDefaultEditor(Object.class, null);
			table.getColumnModel().getColumn(0).setPreferredWidth(100);//nombre
			table.getColumnModel().getColumn(1).setPreferredWidth(100);//apelllido
			table.getColumnModel().getColumn(2).setPreferredWidth(70);//dni
			table.getColumnModel().getColumn(3).setPreferredWidth(70);//telefono
			table.getColumnModel().getColumn(4).setPreferredWidth(140);//calle
			table.getColumnModel().getColumn(5).setPreferredWidth(40);//numero
			table.getColumnModel().getColumn(6).setPreferredWidth(30);//piso
			table.getColumnModel().getColumn(7).setPreferredWidth(30);//depto
			table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);//localidad
			scrollPane.setViewportView(table);
			
			JButton btnVolver = new JButton("Volver");
			btnVolver.setBounds(34, 628, 89, 23);
			contentPane.add(btnVolver);
			
			JButton btnAltaCliente = new JButton("Alta Cliente");
			btnAltaCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnAltaCliente.setBackground(SystemColor.activeCaption);
			btnAltaCliente.setBounds(1044, 46, 178, 52);
			contentPane.add(btnAltaCliente);
			
			JLabel lblNewLabel_2 = new JLabel("Listado de clientes");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNewLabel_2.setBounds(34, 128, 146, 14);
			contentPane.add(lblNewLabel_2);
			
			JButton btnBuscar = new JButton("Buscar");
			btnBuscar.setBounds(286, 82, 89, 23);
			contentPane.add(btnBuscar);
			
			JButton btnMostrarTodos = new JButton("Mostrar todos");
			btnMostrarTodos.setBounds(167, 125, 138, 23);
			contentPane.add(btnMostrarTodos);
			
			
			btnVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MenuPrincipal mp = new MenuPrincipal();
					mp.setVisible(true);
					dispose();
				}
			});
			btnAltaCliente.addActionListener(new ActionListener() {
				@Override
				
				public void actionPerformed(ActionEvent e) {
					AltaClienteGUI ac = new AltaClienteGUI();
					ac.setVisible(true);
				}
			});
			
			btnMostrarTodos.addActionListener(new ActionListener() {
				@Override
				
				public void actionPerformed(ActionEvent e) {
					model.getDataVector().removeAllElements();
					model.fireTableDataChanged();
					cd = gCliente.getClientesDirecciones();
					/*for(Cliente c : cd.getClientes()) {
						Direccion d = gDireccion.recuperarDireccion(c.getPersona().getDireccion().getId_Direccion());
						//Localidad l = gLocalidad.recuperarLocalidadID(d.getLocalidad().getIdLocalidad());
						model.addRow(new Object[]{c.getPersona().getApellido(),c.getPersona().getNombre(),
								c.getPersona().getNumeroDocumento(),c.getPersona().getTelefono(),
								d.getCalle(),d.getNumero(),d.getPiso(),d.getDto(),d.getLocalidad()});
					}*/
					for(Cliente c : cd.getClientes()) {
						//Direccion d = gDireccion.recuperarDireccion(c.getPersona().getDireccion().getId_Direccion());
						//Localidad l = gLocalidad.recuperarLocalidadID(d.getLocalidad().getIdLocalidad());
						String calle="";
						String numero="";
						String piso="";
						String dpto ="";
						String localidad ="";
						for(Direccion d : cd.getDirecciones()) {	
							if(d.getId_Direccion() == c.getPersona().getDireccion().getId_Direccion()) {
								System.out.println(d.getId_Direccion());
								calle=d.getCalle();
								numero=d.getNumero().toString();
								piso=d.getPiso().toString();
								dpto= d.getDto().toString();
								localidad=d.getLocalidad();
								break;
							}	
						}
						
						model.addRow(new Object[]{c.getPersona().getApellido(),c.getPersona().getNombre(),
								c.getPersona().getNumeroDocumento(),c.getPersona().getTelefono(),
								calle,numero,piso,dpto,localidad});
					}
					table.repaint();
				}
			});
			
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int key = comboBox.getSelectedIndex();
					//List<Mecanico> lista;
					boolean existe = false;
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
								for(Cliente c : cd.getClientes()) {
									if(c.getPersona().getNombre().toString().toLowerCase().equals(nombre.toLowerCase()))
									{
										existe=true;
										String calle="";
										String numero="";
										String piso="";
										String dpto ="";
										String localidad ="";
										for(Direccion dx : cd.getDirecciones()) {	
											if(dx.getId_Direccion() == c.getPersona().getDireccion().getId_Direccion()) {
												//System.out.println(dx.getId_Direccion());
												calle=dx.getCalle();
												numero=dx.getNumero().toString();
												piso=dx.getPiso().toString();
												dpto= dx.getDto().toString();
												localidad=dx.getLocalidad();
												break;
											}	
										}
										
										model.addRow(new Object[]{c.getPersona().getApellido(),c.getPersona().getNombre(),
												c.getPersona().getNumeroDocumento(),c.getPersona().getTelefono(),
												calle,numero,piso,dpto,localidad});
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
								for(Cliente c : cd.getClientes()) {
									if(c.getPersona().getNombre().toString().toLowerCase().equals(apellido.toLowerCase()))
									{
										existe=true;
										String calle="";
										String numero="";
										String piso="";
										String dpto ="";
										String localidad ="";
										for(Direccion dx : cd.getDirecciones()) {	
											if(dx.getId_Direccion() == c.getPersona().getDireccion().getId_Direccion()) {
												//System.out.println(dx.getId_Direccion());
												calle=dx.getCalle();
												numero=dx.getNumero().toString();
												piso=dx.getPiso().toString();
												dpto= dx.getDto().toString();
												localidad=dx.getLocalidad();
												break;
											}	
										}
										
										model.addRow(new Object[]{c.getPersona().getApellido(),c.getPersona().getNombre(),
												c.getPersona().getNumeroDocumento(),c.getPersona().getTelefono(),
												calle,numero,piso,dpto,localidad});
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
								
								else{ 
									model.getDataVector().removeAllElements();
								
									model.fireTableDataChanged();
									for(Cliente c : cd.getClientes()) {
										if(c.getPersona().getNombre().toString().toLowerCase().equals(dni))
										{
											existe=true;
											String calle="";
											String numero="";
											String piso="";
											String dpto ="";
											String localidad ="";
											for(Direccion dx : cd.getDirecciones()) {	
												if(dx.getId_Direccion() == c.getPersona().getDireccion().getId_Direccion()) {
													//System.out.println(dx.getId_Direccion());
													calle=dx.getCalle();
													numero=dx.getNumero().toString();
													piso=dx.getPiso().toString();
													dpto= dx.getDto().toString();
													localidad=dx.getLocalidad();
													break;
												}	
											}
											
											model.addRow(new Object[]{c.getPersona().getApellido(),c.getPersona().getNombre(),
													c.getPersona().getNumeroDocumento(),c.getPersona().getTelefono(),
													calle,numero,piso,dpto,localidad});
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
							}//end switch
						}
					
			});
			
			
	}
}
