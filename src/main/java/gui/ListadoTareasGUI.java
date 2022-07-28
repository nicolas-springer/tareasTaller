package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dominio.Tarea;
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
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListadoTareasGUI extends JFrame {
	
	private JPanel contentPane;
	private JTable tableRespuestoUsados;
	private JTable tableTareas;
	private JTextField textField;
	DefaultTableModel model = new DefaultTableModel();
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
		scrollPane.setBounds(37, 42, 673, 287);
		panelIzquierdaAbajo.add(scrollPane);
		
		GestorTarea gTarea = new GestorTarea();
		
		List<Tarea> listaTareas =  gTarea.recuperarTareas();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Id");
		model.addColumn("Cliente");
		model.addColumn("Patente");
		model.addColumn("Mecanico");
		model.addColumn("FechaEntrega");
		if(!(listaTareas.size()==0)) {
			for(Tarea t : listaTareas) {
				model.addRow(new Object[] {t.getIdTarea().toString(),
						t.getCliente().getIdCliente().toString(),
						t.getAuto().getIdAuto().toString(),
						t.getMecanico().getPersona().getNumeroDocumento().toString(),
						t.getFechaEntrega().getDayOfMonth()+"/"+t.getFechaEntrega().getMonthValue()+"/"+t.getFechaEntrega().getYear()});
			}
		}
		else {
			model.addRow(new Object[] {"a","b","c","d","e"});
		}
		
		
		tableTareas = new JTable(model);
		tableTareas.setDefaultEditor(Object.class, null);
		scrollPane.setViewportView(tableTareas);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(37, 414, 89, 23);
		panelIzquierdaAbajo.add(btnVolver);
		
		JButton btnModificarTarea = new JButton("Modificar Tarea");
		btnModificarTarea.setBounds(571, 340, 139, 23);
		panelIzquierdaAbajo.add(btnModificarTarea);
		
		JButton btnActualizarTabla = new JButton("Actualizar");
		
		btnActualizarTabla.setBounds(621, 8, 89, 23);
		panelIzquierdaAbajo.add(btnActualizarTabla);
		
		JPanel panelIzquierdaArriba = new JPanel();
		splitPane_1.setLeftComponent(panelIzquierdaArriba);
		panelIzquierdaArriba.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Busqueda de tareas:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_8.setBounds(10, 11, 195, 14);
		panelIzquierdaArriba.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Filtrar por:");
		lblNewLabel_9.setBounds(10, 51, 65, 14);
		panelIzquierdaArriba.add(lblNewLabel_9);
		
		JComboBox comboBoxFiltros = new JComboBox();
		comboBoxFiltros.setBounds(85, 47, 120, 22);
		panelIzquierdaArriba.add(comboBoxFiltros);
		
		JLabel lblNewLabel_10 = new JLabel("Busqueda:");
		lblNewLabel_10.setBounds(10, 97, 76, 14);
		panelIzquierdaArriba.add(lblNewLabel_10);
		
		textField = new JTextField();
		textField.setBounds(85, 94, 161, 20);
		panelIzquierdaArriba.add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(10, 137, 89, 23);
		panelIzquierdaArriba.add(btnBuscar);
		
		JButton btnAgregarTarea = new JButton("AGREGAR TAREA");
		btnAgregarTarea.setBackground(SystemColor.activeCaption);
		btnAgregarTarea.setFont(new Font("Arial", Font.BOLD, 11));
		btnAgregarTarea.setBounds(516, 27, 181, 62);
		panelIzquierdaArriba.add(btnAgregarTarea);

		
		
		
		
		// PARTE DERECHA ##################
		
		JPanel panelDerecho = new JPanel();
		splitPane.setRightComponent(panelDerecho);
		panelDerecho.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cliente:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(20, 25, 76, 14);
		panelDerecho.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mecanico:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(20, 65, 76, 14);
		panelDerecho.add(lblNewLabel_1);
		
		JLabel lblCliente = new JLabel("");
		lblCliente.setBounds(106, 27, 111, 14);
		panelDerecho.add(lblCliente);
		
		JLabel lblMecanico = new JLabel("");
		lblMecanico.setBounds(106, 67, 111, 14);
		panelDerecho.add(lblMecanico);
		
		JLabel lblNewLabel_4 = new JLabel("Auto:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(20, 105, 76, 14);
		panelDerecho.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Descripcion problema:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(20, 155, 161, 23);
		panelDerecho.add(lblNewLabel_5);
		
		JTextArea textDescripcion = new JTextArea();
		textDescripcion.setEditable(false);
		textDescripcion.setWrapStyleWord(true);
		textDescripcion.setBounds(20, 189, 437, 133);
		panelDerecho.add(textDescripcion);
		
		JLabel lblAuto = new JLabel("");
		lblAuto.setBounds(89, 107, 92, 14);
		panelDerecho.add(lblAuto);
		
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
		
		btnFinalizarTarea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnFinalizarTarea.setBounds(346, 635, 111, 23);
		panelDerecho.add(btnFinalizarTarea);
		
		JButton btnCancelarTarea = new JButton("Cancelar tarea");
		btnCancelarTarea.setBounds(10, 635, 126, 23);
		panelDerecho.add(btnCancelarTarea);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 623, 447, 2);
		panelDerecho.add(separator);
		
		JLabel lblNewLabel_4_1 = new JLabel("Patente:");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1.setBounds(209, 105, 76, 14);
		panelDerecho.add(lblNewLabel_4_1);
		
		JLabel lblPatente = new JLabel("");
		lblPatente.setBounds(295, 107, 76, 14);
		panelDerecho.add(lblPatente);
		
		JButton btnAgregarRepuesto = new JButton("Agregar Repuesto");
		btnAgregarRepuesto.setBounds(324, 528, 133, 23);
		panelDerecho.add(btnAgregarRepuesto);
		
		
		
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal mp = new MenuPrincipal();
				mp.setVisible(true);
				dispose();
			}
		});
		
		
		btnAgregarTarea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final GenerarTareaGUI gt = new GenerarTareaGUI();
				gt.setVisible(true);
			}
		});
		
		btnActualizarTabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
		
		
		tableTareas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int select = tableTareas.rowAtPoint(e.getPoint());
				Integer idtar = Integer.parseInt(tableTareas.getValueAt(select, 0).toString());
				System.out.println("select : " + select);
				for(Tarea t :listaTareas) {
					if(t.getIdTarea() == idtar) {
						lblCliente.setText(t.getCliente().getPersona().getNombre()+" "+ t.getCliente().getPersona().getApellido());
						lblMecanico.setText(t.getMecanico().getPersona().getNombre()+" "+ t.getMecanico().getPersona().getApellido());
						textDescripcion.setText(t.getDescProblema().toString());
					}
				}
				lblCliente.repaint();
				lblMecanico.repaint();
				textDescripcion.repaint();
			}
		});
		
	}
}
