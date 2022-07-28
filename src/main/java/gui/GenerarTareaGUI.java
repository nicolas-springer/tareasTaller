package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import dominio.Auto;
import dominio.Cliente;
import dominio.Mecanico;
import dominio.Persona;
import dominio.Tarea;
import gestor.GestorAuto;
import gestor.GestorCliente;
import gestor.GestorMecanico;
import gestor.GestorPersona;
import gestor.GestorTarea;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import com.toedter.calendar.JDateChooser;

public class GenerarTareaGUI extends JFrame {

	private JPanel contentPane;
	private JTable tableAutos;
	private JTextField textFieldDNI;
	private GestorMecanico gMecanico =  new GestorMecanico();
	private GestorCliente gCliente = new GestorCliente();
	private GestorAuto gAuto = new GestorAuto();
	private GestorTarea gTarea = new GestorTarea();
	List<Mecanico> listaMecanicos = gMecanico.recuperarMecanicos();
	
	Cliente clienteAux;
	Auto autoTarea;
	Mecanico mecanicoAsignado;
	
	Integer filaAutoTabla;
	
	public GenerarTareaGUI() {
		setTitle("Dar alta cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 550);
		generarFrame();
	}

	void generarFrame() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DNI Cliente");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 27, 80, 14);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 87, 453, 95);
		contentPane.add(scrollPane);
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Patente");
		model.addColumn("Marca");
		model.addColumn("Modelo");
		tableAutos = new JTable(model);
		
		tableAutos.setDefaultEditor(Object.class, null);
		scrollPane.setViewportView(tableAutos);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldDNI.setBounds(100, 24, 112, 20);
		contentPane.add(textFieldDNI);
		textFieldDNI.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Autos de: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 63, 66, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnCargarTarea = new JButton("Cargar tarea");
		btnCargarTarea.setBounds(351, 470, 112, 23);
		contentPane.add(btnCargarTarea);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 470, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblNewLabel_2 = new JLabel("Mecanico a cargo:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 244, 112, 23);
		contentPane.add(lblNewLabel_2);
		
		
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setBounds(132, 242, 331, 27);
		contentPane.add(comboBox);
		
		for(Mecanico m : listaMecanicos) {
			comboBox.addItem(m.getPersona().getNombre()+" "+m.getPersona().getApellido()+" | "+m.getPersona().getNumeroDocumento());
		}
		
		JLabel lblNewLabel_3 = new JLabel("Descripcion para la tarea:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(10, 354, 169, 20);
		contentPane.add(lblNewLabel_3);
		
		JTextPane textPaneDescripcion = new JTextPane();
		textPaneDescripcion.setBorder(new LineBorder(Color.GRAY));
		textPaneDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textPaneDescripcion.setBounds(10, 385, 453, 50);
		contentPane.add(textPaneDescripcion);
		
		JButton btnAgregarAuto = new JButton("Agregar Auto");
		btnAgregarAuto.setEnabled(false);
		btnAgregarAuto.setBounds(351, 193, 112, 23);
		contentPane.add(btnAgregarAuto);
		
		JButton btnVerificarDNI = new JButton("Verificar DNI");
		btnVerificarDNI.setBounds(237, 22, 112, 23);
		contentPane.add(btnVerificarDNI);
		
		JLabel lblNewLabel_4 = new JLabel();
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(75, 62, 388, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha entrega:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(10, 304, 101, 20);
		contentPane.add(lblNewLabel_5);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd-MM-yyyy");
		dateChooser.setBounds(121, 304, 200, 20);
		contentPane.add(dateChooser);
		
		
		btnVerificarDNI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//boolean existe = gCliente.verificarDNI(textFieldDNI.getText());
				clienteAux = gCliente.recuperarClienteDNI(textFieldDNI.getText());
				System.out.println("id: "+clienteAux.getIdCliente().toString());
				if(clienteAux!=null) {
					btnAgregarAuto.setEnabled(true);
					lblNewLabel_4.setText(clienteAux.getPersona().getNombre()+" "+ clienteAux.getPersona().getApellido());
					List<Auto> listaAutos = gCliente.recuperarAutosClienteDNI(textFieldDNI.getText());	
					if(!(listaAutos.size()==0)) {				
						model.getDataVector().removeAllElements();
						model.fireTableDataChanged();
						for(Auto a : listaAutos) {
							model.addRow(new Object[] {
									a.getPatente().toString(),
									a.getMarca().toString(),
									a.getModelo().toString()
							});
						}
					}
					else {
						
						model.addRow(new Object[] {
							"no tiene autos registrado","",""	
						});
					}
				}
				else {
					btnAgregarAuto.setEnabled(false);
					JOptionPane.showMessageDialog(null, 
                            "No existe un cliente con este DNI", 
                            "CUIDADO", 
                            JOptionPane.WARNING_MESSAGE);
					}
				tableAutos.repaint();
			}
	
		});
		

		btnAgregarAuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			if(btnAgregarAuto.isEnabled()) { 
				CargarAutoGUI carga = new CargarAutoGUI(clienteAux);
				carga.setVisible(true);
				}
			}
		});
		
		tableAutos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				filaAutoTabla = tableAutos.rowAtPoint(e.getPoint());
				
			}
		});
		
		btnCargarTarea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			if(btnAgregarAuto.isEnabled()) { //si esta enabled es porq el dni ingreado es correcto
					if(filaAutoTabla!=null) {
						GestorAuto gAuto = new GestorAuto();
						String pat = tableAutos.getValueAt(filaAutoTabla, 0).toString();
						System.out.println(pat);
						autoTarea = gAuto.recuperarAutoConPatente(pat);
						GestorMecanico gMecanico = new GestorMecanico();
						String dniAsignado= comboBox.getSelectedItem().toString().replaceAll("[^0-9]", "");
						System.out.println(dniAsignado);
						
						mecanicoAsignado=gMecanico.recuperarMecanicoDNI(dniAsignado);
						
						GestorTarea gTarea = new GestorTarea();
						
						Date dcdate = dateChooser.getDate();
						
						String descripcionProblema = textPaneDescripcion.getText().toString();
						
						
						
						boolean hayvacios = verificarvacios(clienteAux,autoTarea,mecanicoAsignado,descripcionProblema,dcdate);
						
						if(!hayvacios) {
							
							try {
								
								LocalDate fe = dcdate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();;
								DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
								fe.format(dtf);
								
								gTarea.generarTarea(clienteAux, autoTarea, mecanicoAsignado, descripcionProblema, fe);
								JOptionPane.showMessageDialog(null, "Datos cargados correctamente");
								dispose();
							} catch (Exception e2) {
								JOptionPane.showMessageDialog(new JPanel(), e2.getMessage(), "Error",
										JOptionPane.ERROR_MESSAGE);
								throw e2;
							}
						}
					}
					else{
						JOptionPane.showMessageDialog(null, 
		                        "Seleccione un auto de la tabla.", 
		                        "CUIDADO", 
		                        JOptionPane.WARNING_MESSAGE);
						}
				}
			else {
				JOptionPane.showMessageDialog(null, 
                        "Elegir un DNI y cliente.", 
                        "CUIDADO", 
                        JOptionPane.WARNING_MESSAGE);
			}
			}
		});
		
		
	}

	protected boolean verificarvacios(Cliente clienteAux2, Auto autoTarea2, Mecanico mecanicoAsignado2,
			String descripcionProblema, Date dcdate) {
		// TODO Auto-generated method stub
		String mensajeerror="";
		boolean flag=false;
		if(clienteAux2==null) {
			mensajeerror+="Ingrese el DNI del cliente";
			flag=true;
		}
		if(autoTarea2==null) {
			mensajeerror+="Seleccione un auto.";
			flag=true;
		}
		if(mecanicoAsignado2==null) {
			mensajeerror+="Seleccione un mecanico.";
			flag=true;
		}
		if(dcdate==null) {
			mensajeerror+="Seleccione una fecha de entrega.";
			flag=true;
		}

		if(flag) {
			JOptionPane.showMessageDialog(null, 
                mensajeerror, 
                "CUIDADO", 
                JOptionPane.WARNING_MESSAGE);
			}
		
		return flag;
	}
}
