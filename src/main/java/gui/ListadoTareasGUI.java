package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dominio.Tarea;
import enumClasses.EstadoTarea;
import gestor.GestorTarea;

import java.awt.ComponentOrientation;
import java.awt.Cursor;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javax.swing.border.LineBorder;
import com.toedter.calendar.JDateChooser;

public class ListadoTareasGUI extends JFrame {
	
	private JPanel contentPane;
	private JTable tableRespuestoUsados;
	private JTable tableTareas;
	private JTextField textFieldBusqueda;
	List<Tarea> listaTareas;
	DefaultTableModel model = new DefaultTableModel();
	
	GestorTarea gTarea = new GestorTarea();
	
	int select;//fila de la tabla
	
	public ListadoTareasGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 150, 1280, 720);
		setResizable(false);
		setTitle("Gestion Tareas");
		setLocationRelativeTo(null); 
		generarListadoTareasGUI();

		
	}
	public void generarListadoTareasGUI() {
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		splitPane.setResizeWeight(0.6);
		splitPane.setDividerSize(1);
		contentPane.add(splitPane);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setEnabled(false);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setLeftComponent(splitPane_1);
		splitPane_1.setResizeWeight(0.3);
		
		JPanel panelIzquierdaAbajo = new JPanel();
		splitPane_1.setRightComponent(panelIzquierdaAbajo);
		panelIzquierdaAbajo.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 42, 673, 334);
		panelIzquierdaAbajo.add(scrollPane);
		
		listaTareas =  gTarea.recuperarTareas();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Id");
		model.addColumn("Cliente");
		model.addColumn("Patente");
		model.addColumn("Mecanico");
		model.addColumn("FechaEntrega");
		
		if(!(listaTareas.size()==0)) {
			for(Tarea t : listaTareas) {
				
				/*model.addRow(new Object[] {t.getIdTarea().toString(),
						t.getCliente().getIdCliente().toString(),
						t.getAuto().getIdAuto().toString(),
						t.getMecanico().getPersona().getNumeroDocumento().toString(),
						t.getFechaEntrega().getDayOfMonth()+"/"+t.getFechaEntrega().getMonthValue()+"/"+t.getFechaEntrega().getYear()});*/
				model.addRow(new Object[] {t.getIdTarea().toString(),
						t.getCliente().getPersona().getNombre()+" "+t.getCliente().getPersona().getApellido(),
						t.getAuto().getMarca()+" "+t.getAuto().getModelo(),
						t.getMecanico().getPersona().getNombre()+" "+t.getMecanico().getPersona().getApellido(),
						t.getFechaEntrega().getDayOfMonth()+"/"+t.getFechaEntrega().getMonthValue()+"/"+t.getFechaEntrega().getYear()
						});
			}
		}
		else {
			JOptionPane.showMessageDialog(null, 
	                "No se encontraron tareas cargadas.", 
	                "CUIDADO", 
	                JOptionPane.WARNING_MESSAGE);
		}
		
		
		tableTareas = new JTable(model);
		tableTareas.setDefaultEditor(Object.class, null);
		tableTareas.getColumnModel().getColumn(0).setPreferredWidth(15);//idtarea
		tableTareas.getColumnModel().getColumn(1).setPreferredWidth(80);//cliente
		tableTareas.getColumnModel().getColumn(2).setPreferredWidth(70);//auto
		tableTareas.getColumnModel().getColumn(3).setPreferredWidth(80);//mecanico
		//tableTareas.getColumnModel().getColumn(4).setPreferredWidth(120);//fechaentrega
		tableTareas.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);//fechaentrega
		
		
		scrollPane.setViewportView(tableTareas);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(37, 414, 89, 23);
		panelIzquierdaAbajo.add(btnVolver);
		
		JButton btnModificarTarea = new JButton("Modificar Tarea");
		btnModificarTarea.setBounds(571, 387, 139, 23);
		panelIzquierdaAbajo.add(btnModificarTarea);
		
		JButton btnActualizarTabla = new JButton("Actualizar");
		
		btnActualizarTabla.setBounds(598, 8, 112, 23);
		panelIzquierdaAbajo.add(btnActualizarTabla);
		
		JPanel panelIzquierdaArriba = new JPanel();
		splitPane_1.setLeftComponent(panelIzquierdaArriba);
		panelIzquierdaArriba.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Busqueda de tareas:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_8.setBounds(10, 11, 195, 14);
		panelIzquierdaArriba.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Filtrar por:");
		lblNewLabel_9.setBounds(10, 36, 65, 14);
		panelIzquierdaArriba.add(lblNewLabel_9);
		
		JComboBox<String> comboBoxFiltros = new JComboBox<String>();
		comboBoxFiltros.setBounds(85, 32, 120, 22);
		panelIzquierdaArriba.add(comboBoxFiltros);

		comboBoxFiltros.addItem("Cliente");
		comboBoxFiltros.addItem("Mecanico");
		comboBoxFiltros.addItem("Entre fechas");
		
		
		
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(320, 64, 89, 23);
		panelIzquierdaArriba.add(btnBuscar);
		
		JButton btnAgregarTarea = new JButton("AGREGAR TAREA");
		btnAgregarTarea.setBackground(SystemColor.activeCaption);
		btnAgregarTarea.setFont(new Font("Arial", Font.BOLD, 11));
		btnAgregarTarea.setBounds(516, 27, 181, 62);
		panelIzquierdaArriba.add(btnAgregarTarea);
		
		JButton btnMostrarPendientes = new JButton("Pendientes");
		btnMostrarPendientes.setBounds(140, 165, 106, 23);
		panelIzquierdaArriba.add(btnMostrarPendientes);
		
		JButton btnMostrarTodas = new JButton("Mostrar todas");
		btnMostrarTodas.setBounds(10, 165, 120, 23);
		panelIzquierdaArriba.add(btnMostrarTodas);
		
		JButton btnFinalizadas = new JButton("Finalizadas");
		btnFinalizadas.setBounds(256, 165, 106, 23);
		panelIzquierdaArriba.add(btnFinalizadas);
		
		JButton btnCanceladas = new JButton("Canceladas");
		btnCanceladas.setBounds(372, 165, 106, 23);
		panelIzquierdaArriba.add(btnCanceladas);
		
		JPanel panelBusquedaPalabra = new JPanel();
		panelBusquedaPalabra.setBounds(10, 61, 297, 77);
		panelIzquierdaArriba.add(panelBusquedaPalabra);
		panelBusquedaPalabra.setLayout(null);
		
		panelBusquedaPalabra.setVisible(true);
		
		JLabel lblNewLabel_10 = new JLabel("Busqueda:");
		lblNewLabel_10.setBounds(10, 32, 76, 14);
		panelBusquedaPalabra.add(lblNewLabel_10);
		
		textFieldBusqueda = new JTextField();
		textFieldBusqueda.setBounds(74, 29, 161, 20);
		panelBusquedaPalabra.add(textFieldBusqueda);
		textFieldBusqueda.setColumns(10);
		
		JPanel panelBusquedaFechas = new JPanel();
		panelBusquedaFechas.setLayout(null);
		panelBusquedaFechas.setBounds(10, 61, 297, 77);
		panelIzquierdaArriba.add(panelBusquedaFechas);
		panelBusquedaFechas.setVisible(false);
		
		JDateChooser dateChooserDesde = new JDateChooser();
		dateChooserDesde.setBounds(115, 11, 138, 20);
		panelBusquedaFechas.add(dateChooserDesde);
		
		JDateChooser dateChooserHasta = new JDateChooser();
		dateChooserHasta.setBounds(115, 42, 138, 20);
		panelBusquedaFechas.add(dateChooserHasta);
		
		JLabel lblNewLabel_3 = new JLabel("Desde");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(10, 11, 59, 20);
		panelBusquedaFechas.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Hasta");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_1.setBounds(10, 42, 59, 20);
		panelBusquedaFechas.add(lblNewLabel_3_1);

		
		
		
		
		// PARTE DERECHA ##################
		
		JPanel panelDerecho = new JPanel();
		splitPane.setRightComponent(panelDerecho);
		panelDerecho.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cliente:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(20, 107, 76, 23);
		panelDerecho.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mecanico:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(20, 147, 76, 23);
		panelDerecho.add(lblNewLabel_1);
		
		JLabel lblCliente = new JLabel("");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCliente.setBounds(86, 107, 228, 23);
		panelDerecho.add(lblCliente);
		
		JLabel lblNewLabel_4 = new JLabel("Auto:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(20, 187, 76, 23);
		panelDerecho.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Descripcion problema:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(20, 227, 161, 23);
		panelDerecho.add(lblNewLabel_5);
		
		JTextArea textDescripcion = new JTextArea();
		textDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textDescripcion.setBorder(new LineBorder(Color.GRAY));
		textDescripcion.setEditable(false);
		textDescripcion.setWrapStyleWord(true);
		textDescripcion.setBounds(20, 254, 437, 68);
		panelDerecho.add(textDescripcion);
		
		JLabel lblNewLabel_7 = new JLabel("Respuestos usados:");
		lblNewLabel_7.setBounds(20, 333, 161, 14);
		panelDerecho.add(lblNewLabel_7);
		
		String[] colRespuestos = {"Id","Descripcion","Cantidad"};
		Object[][] datosFilaRespuestos = {};
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 358, 437, 159);
		panelDerecho.add(scrollPane_1);
		tableRespuestoUsados = new JTable(datosFilaRespuestos, colRespuestos);
		scrollPane_1.setViewportView(tableRespuestoUsados);
		
		JButton btnFinalizarTarea = new JButton("Finalizar Tarea");
		
		
		
		btnFinalizarTarea.setBounds(324, 635, 133, 23);
		panelDerecho.add(btnFinalizarTarea);
		
		JButton btnCancelarTarea = new JButton("Cancelar tarea");
		btnCancelarTarea.setBounds(10, 635, 133, 23);
		panelDerecho.add(btnCancelarTarea);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 623, 447, 2);
		panelDerecho.add(separator);
		
		JLabel lblNewLabel_4_1 = new JLabel("Patente:");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_1.setBounds(301, 187, 76, 23);
		panelDerecho.add(lblNewLabel_4_1);
		
		JButton btnAgregarRepuesto = new JButton("Agregar Repuesto");
		btnAgregarRepuesto.setBounds(301, 528, 156, 23);
		panelDerecho.add(btnAgregarRepuesto);
		
		JLabel lblNewLabel_2 = new JLabel("Tarea:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(20, 27, 46, 23);
		panelDerecho.add(lblNewLabel_2);
		
		JLabel lblEstadoax = new JLabel("Estado:");
		lblEstadoax.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEstadoax.setBounds(165, 27, 76, 23);
		panelDerecho.add(lblEstadoax);
		
		JLabel lblFechaCreacionax = new JLabel("Fecha creacion:");
		lblFechaCreacionax.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFechaCreacionax.setBounds(20, 67, 111, 23);
		panelDerecho.add(lblFechaCreacionax);
		
		JLabel lblFechaEntregaax = new JLabel("Fecha entrega:");
		lblFechaEntregaax.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaEntregaax.setBounds(238, 67, 111, 23);
		panelDerecho.add(lblFechaEntregaax);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDni.setBounds(324, 107, 36, 23);
		panelDerecho.add(lblDni);
		
		JLabel lblDNIcliente = new JLabel("");
		lblDNIcliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDNIcliente.setBounds(368, 107, 89, 23);
		panelDerecho.add(lblDNIcliente);
		
		JLabel lblFechaEntrega = new JLabel("");
		lblFechaEntrega.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFechaEntrega.setBounds(359, 67, 116, 23);
		panelDerecho.add(lblFechaEntrega);
		
		JLabel lblFechaCreacion = new JLabel("");
		lblFechaCreacion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFechaCreacion.setBounds(128, 67, 102, 23);
		panelDerecho.add(lblFechaCreacion);
		
		JLabel lblMecanico = new JLabel("");
		lblMecanico.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMecanico.setBounds(106, 147, 271, 23);
		panelDerecho.add(lblMecanico);
		
		JLabel lblEstadoTarea = new JLabel("");
		lblEstadoTarea.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEstadoTarea.setBounds(238, 27, 161, 23);
		panelDerecho.add(lblEstadoTarea);
		
		JLabel lblIdTarea = new JLabel("");
		lblIdTarea.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdTarea.setBounds(62, 27, 89, 23);
		panelDerecho.add(lblIdTarea);
		
		JLabel lblAuto = new JLabel("");
		lblAuto.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAuto.setBounds(92, 189, 183, 23);
		panelDerecho.add(lblAuto);
		
		JLabel lblPatente = new JLabel("");
		lblPatente.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPatente.setBounds(368, 187, 89, 23);
		panelDerecho.add(lblPatente);
		
		btnActualizarTabla.setVisible(false);
		btnActualizarTabla.setEnabled(false);
		
		comboBoxFiltros.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				if (e.getStateChange() == ItemEvent.SELECTED) {

					if(comboBoxFiltros.getSelectedIndex()==0 || comboBoxFiltros.getSelectedIndex()==1) {
						panelBusquedaPalabra.setVisible(true);
						panelBusquedaFechas.setVisible(false);
					}
					else {
						panelBusquedaPalabra.setVisible(false);
						panelBusquedaFechas.setVisible(true);
					}

				}

			}
		});
		
		
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal mp = new MenuPrincipal();
				mp.setVisible(true);
				dispose();
			}
		});
		
		btnFinalizarTarea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer idtar = Integer.parseInt(tableTareas.getValueAt(select, 0).toString());
				System.out.println("finalizar:"+idtar);
				gTarea.finalizarTarea(idtar);
				
			}
		});
		
		btnCancelarTarea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer idtar = Integer.parseInt(tableTareas.getValueAt(select, 0).toString());
				System.out.println("cancelar:"+idtar);
				gTarea.cancelarTarea(idtar);
				
			}
		});
		
		btnAgregarTarea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final GenerarTareaGUI gt = new GenerarTareaGUI();
				gt.setVisible(true);
				
				//actualizar tabla
				model.getDataVector().removeAllElements();
				model.fireTableDataChanged();
				List<Tarea> actualizada =  gTarea.recuperarTareas();
				for(Tarea t : actualizada) {
					model.addRow(new Object[] {t.getIdTarea().toString(),
							t.getCliente().getIdCliente().toString(),
							t.getAuto().getIdAuto().toString(),
							t.getMecanico().getPersona().getNumeroDocumento().toString(),
							t.getFechaEntrega().toString()});
				}
				tableTareas.repaint();
			}
		});
		
		/*btnActualizarTabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model.getDataVector().removeAllElements();
				model.fireTableDataChanged();
				List<Tarea> actualizada =  gTarea.recuperarTareas();
				for(Tarea t : actualizada) {
					model.addRow(new Object[] {t.getIdTarea().toString(),
							t.getCliente().getPersona().getNombre()+" "+t.getCliente().getPersona().getApellido(),
							t.getAuto().getMarca()+" "+t.getAuto().getModelo(),
							t.getMecanico().getPersona().getNombre()+" "+t.getMecanico().getPersona().getApellido(),
							t.getFechaEntrega().getDayOfMonth()+"/"+t.getFechaEntrega().getMonthValue()+"/"+t.getFechaEntrega().getYear()
							});
				}
				tableTareas.repaint();
			}
		});*/
		
		btnMostrarTodas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.getDataVector().removeAllElements();
				model.fireTableDataChanged();
				List<Tarea> actualizada =  gTarea.recuperarTareas();
				for(Tarea t : actualizada) {
					model.addRow(new Object[] {t.getIdTarea().toString(),
							t.getCliente().getPersona().getNombre()+" "+t.getCliente().getPersona().getApellido(),
							t.getAuto().getMarca()+" "+t.getAuto().getModelo(),
							t.getMecanico().getPersona().getNombre()+" "+t.getMecanico().getPersona().getApellido(),
							t.getFechaEntrega().getDayOfMonth()+"/"+t.getFechaEntrega().getMonthValue()+"/"+t.getFechaEntrega().getYear()
							});
				}
				tableTareas.repaint();
			}
		});
		
		btnMostrarPendientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.getDataVector().removeAllElements();
				model.fireTableDataChanged();
				List<Tarea> actualizada =  gTarea.recuperarTareas();
				boolean hayPendientes=false;
				for(Tarea t : actualizada) {
					if(t.getEstado().equals(EstadoTarea.PENDIENTE)) {//
						hayPendientes=true;
						model.addRow(new Object[] {t.getIdTarea().toString(),
								t.getCliente().getPersona().getNombre()+" "+t.getCliente().getPersona().getApellido(),
								t.getAuto().getMarca()+" "+t.getAuto().getModelo(),
								t.getMecanico().getPersona().getNombre()+" "+t.getMecanico().getPersona().getApellido(),
								t.getFechaEntrega().getDayOfMonth()+"/"+t.getFechaEntrega().getMonthValue()+"/"+t.getFechaEntrega().getYear()
								});
					}
				}
				if(hayPendientes) {
					tableTareas.repaint();
				}
				else {
					JOptionPane.showMessageDialog(null, 
			                "No se encontraron tareas pendientes.", 
			                "CUIDADO", 
			                JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		btnFinalizadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.getDataVector().removeAllElements();
				model.fireTableDataChanged();
				List<Tarea> actualizada =  gTarea.recuperarTareas();
				boolean hayPendientes=false;
				for(Tarea t : actualizada) {
					if(t.getEstado().equals(EstadoTarea.FINALIZADA)) {//
						hayPendientes=true;
						model.addRow(new Object[] {t.getIdTarea().toString(),
								t.getCliente().getPersona().getNombre()+" "+t.getCliente().getPersona().getApellido(),
								t.getAuto().getMarca()+" "+t.getAuto().getModelo(),
								t.getMecanico().getPersona().getNombre()+" "+t.getMecanico().getPersona().getApellido(),
								t.getFechaEntrega().getDayOfMonth()+"/"+t.getFechaEntrega().getMonthValue()+"/"+t.getFechaEntrega().getYear()
								});
						
					}
				}
				if(hayPendientes) {
					tableTareas.repaint();
				}
				else {
					JOptionPane.showMessageDialog(null, 
			                "No se encontraron tareas finalizadas.", 
			                "CUIDADO", 
			                JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		btnCanceladas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.getDataVector().removeAllElements();
				model.fireTableDataChanged();
				List<Tarea> actualizada =  gTarea.recuperarTareas();
				boolean hayPendientes=false;
				for(Tarea t : actualizada) {
					if(t.getEstado().equals(EstadoTarea.CANCELADA)) {//
						hayPendientes=true;
						model.addRow(new Object[] {t.getIdTarea().toString(),
								t.getCliente().getPersona().getNombre()+" "+t.getCliente().getPersona().getApellido(),
								t.getAuto().getMarca()+" "+t.getAuto().getModelo(),
								t.getMecanico().getPersona().getNombre()+" "+t.getMecanico().getPersona().getApellido(),
								t.getFechaEntrega().getDayOfMonth()+"/"+t.getFechaEntrega().getMonthValue()+"/"+t.getFechaEntrega().getYear()
								});
					}
				}
				if(hayPendientes) {
					tableTareas.repaint();
				}
				else {
					JOptionPane.showMessageDialog(null, 
			                "No se encontraron tareas canceladas.", 
			                "CUIDADO", 
			                JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		tableTareas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				select = tableTareas.rowAtPoint(e.getPoint());
				Integer idtar = Integer.parseInt(tableTareas.getValueAt(select, 0).toString());
				//System.out.println("select : " + select);
				for(Tarea t :listaTareas) {
					if(t.getIdTarea() == idtar) {
						lblIdTarea.setText(t.getIdTarea().toString());
						lblEstadoTarea.setText(t.getEstado().toString());
						lblFechaCreacion.setText(t.getFechaCreacion().toString());
						lblFechaEntrega.setText(t.getFechaEntrega().toString());						
						lblCliente.setText(t.getCliente().getPersona().getNombre()+" "+ t.getCliente().getPersona().getApellido());
						lblDNIcliente.setText(t.getCliente().getPersona().getNumeroDocumento().toString());
						lblMecanico.setText(t.getMecanico().getPersona().getNombre()+" "+ t.getMecanico().getPersona().getApellido());
						lblAuto.setText(t.getAuto().getMarca()+" "+t.getAuto().getModelo());
						lblPatente.setText(t.getAuto().getPatente().toString());
						textDescripcion.setText(t.getDescProblema().toString());
					break;
					}
				}
				if(lblEstadoTarea.getText().toString().equals(EstadoTarea.FINALIZADA.toString())
					||lblEstadoTarea.getText().toString().equals(EstadoTarea.CANCELADA.toString()) ) {
					btnCancelarTarea.setEnabled(false);
					btnFinalizarTarea.setEnabled(false);
				}
				else {
					btnCancelarTarea.setEnabled(true);
					btnFinalizarTarea.setEnabled(true);
				}
				lblIdTarea.repaint();
				lblEstadoTarea.repaint();
				lblFechaCreacion.repaint();
				lblFechaEntrega.repaint();						
				lblCliente.repaint();
				lblDNIcliente.repaint();
				lblMecanico.repaint();
				lblAuto.repaint();
				lblPatente.repaint();
				textDescripcion.repaint();
			}
		});
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Tarea> actualizada =  gTarea.recuperarTareas();
				boolean hay=false;
				
				
				if(comboBoxFiltros.getSelectedIndex()==0) {
					if(!textFieldBusqueda.getText().toString().isEmpty()) {
					model.getDataVector().removeAllElements();
					model.fireTableDataChanged();
					for(Tarea t : actualizada) {
						String nomcompleto=t.getCliente().getPersona().getNombre()+" "+t.getCliente().getPersona().getApellido();
						if(nomcompleto.toLowerCase().contains(textFieldBusqueda.getText().toString().toLowerCase())) {//
							hay=true;
							model.addRow(new Object[] {t.getIdTarea().toString(),
									t.getCliente().getPersona().getNombre()+" "+t.getCliente().getPersona().getApellido(),
									t.getAuto().getMarca()+" "+t.getAuto().getModelo(),
									t.getMecanico().getPersona().getNombre()+" "+t.getMecanico().getPersona().getApellido(),
									t.getFechaEntrega().getDayOfMonth()+"/"+t.getFechaEntrega().getMonthValue()+"/"+t.getFechaEntrega().getYear()
									});
						}
					}
					if(hay) {
						tableTareas.repaint();
					}
					else {
						JOptionPane.showMessageDialog(null, 
				                "No se encontraron cliente con: "+textFieldBusqueda.getText().toString().toUpperCase(), 
				                "CUIDADO", 
				                JOptionPane.WARNING_MESSAGE);
					}
					}
					else {
						JOptionPane.showMessageDialog(null, 
				                "Ingrese una busqueda.", 
				                "CUIDADO", 
				                JOptionPane.WARNING_MESSAGE);
					}
				}
				else if (comboBoxFiltros.getSelectedIndex()==1){
					if(!textFieldBusqueda.getText().toString().isEmpty()) {
					model.getDataVector().removeAllElements();
					model.fireTableDataChanged();
					for(Tarea t : actualizada) {
						String nomcompleto=t.getMecanico().getPersona().getNombre()+" "+t.getMecanico().getPersona().getApellido();
						if(nomcompleto.toLowerCase().contains(textFieldBusqueda.getText().toString().toLowerCase())) {//
							hay=true;
							model.addRow(new Object[] {t.getIdTarea().toString(),
									t.getCliente().getPersona().getNombre()+" "+t.getCliente().getPersona().getApellido(),
									t.getAuto().getMarca()+" "+t.getAuto().getModelo(),
									t.getMecanico().getPersona().getNombre()+" "+t.getMecanico().getPersona().getApellido(),
									t.getFechaEntrega().getDayOfMonth()+"/"+t.getFechaEntrega().getMonthValue()+"/"+t.getFechaEntrega().getYear()
									});
						}
					}
					if(hay) {
						tableTareas.repaint();
					}
					else {
						JOptionPane.showMessageDialog(null, 
				                "No se encontraron mecanicos con: "+textFieldBusqueda.getText().toString().toUpperCase(), 
				                "CUIDADO", 
				                JOptionPane.WARNING_MESSAGE);
					}
					}
					else {
						JOptionPane.showMessageDialog(null, 
								"Ingrese una busqueda",
								"CUIDADO", 
				                JOptionPane.WARNING_MESSAGE);
					}
				}
				else {
					
					if((dateChooserDesde.getDate()!=null && dateChooserHasta.getDate()!=null)) {
					
					LocalDate desde = dateChooserDesde.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
					LocalDate hasta = dateChooserHasta.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
					
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					desde.format(dtf);
					hasta.format(dtf);
					
					if(desde.isBefore(hasta)) {
						model.getDataVector().removeAllElements();
						model.fireTableDataChanged();
						for(Tarea t : actualizada) {
							if(t.getFechaEntrega().isAfter(desde.minusDays(1)) && t.getFechaEntrega().isBefore(hasta.plusDays(1))) {//
								hay=true;
								model.addRow(new Object[] {t.getIdTarea().toString(),
										t.getCliente().getPersona().getNombre()+" "+t.getCliente().getPersona().getApellido(),
										t.getAuto().getMarca()+" "+t.getAuto().getModelo(),
										t.getMecanico().getPersona().getNombre()+" "+t.getMecanico().getPersona().getApellido(),
										t.getFechaEntrega().getDayOfMonth()+"/"+t.getFechaEntrega().getMonthValue()+"/"+t.getFechaEntrega().getYear()
										});
							}
						}
						if(hay) {
							tableTareas.repaint();
						}
						else {
							JOptionPane.showMessageDialog(null, 
					                "No se encontraron tareas desde:"+dateChooserDesde.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString()
					               +" hasta: "+dateChooserHasta.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), 
					                "CUIDADO", 
					                JOptionPane.WARNING_MESSAGE);
						}
					}
					else {
						JOptionPane.showMessageDialog(null, 
								"La fecha 'desde' debe ser anterior a 'hasta'",
				                "CUIDADO", 
				                JOptionPane.WARNING_MESSAGE);
					}
					}
					else {
						JOptionPane.showMessageDialog(null, 
								"Seleccione las fechas.",
				                "CUIDADO", 
				                JOptionPane.WARNING_MESSAGE);
					}
					
				}
			}
		});
		
	}
}
