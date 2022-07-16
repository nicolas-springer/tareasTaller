package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
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
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class ListadoTareasGUI extends JFrame {
	
	private JPanel contentPane;
	private JTable tableRespuestoUsados;
	private JTable tableTareas;
	
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
		
		JPanel panel_1 = new JPanel();
		splitPane_1.setRightComponent(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 42, 716, 287);
		panel_1.add(scrollPane);
		
		
		String[] colTareas= {"Id","Cliente", "Mecanico", "Fecha entrega"};
		Object[][] datosFilaTareas = { };
		
		
		
		tableTareas = new JTable(datosFilaTareas,colTareas);
		scrollPane.setViewportView(tableTareas);
		
		JButton btnVolverAtras = new JButton("Atras");
		btnVolverAtras.setBounds(37, 414, 89, 23);
		panel_1.add(btnVolverAtras);
		
		JButton btnNewButton = new JButton("AGREGAR TAREA");
		btnNewButton.setBounds(606, 340, 147, 33);
		panel_1.add(btnNewButton);

		
		
		
		
		// PARTE DERECHA ##################
		
		JPanel panel = new JPanel();
		splitPane.setRightComponent(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cliente:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(20, 23, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mecanico:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(20, 57, 76, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(100, 25, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(100, 59, 46, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Auto:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(20, 82, 46, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Descripcion problema:");
		lblNewLabel_5.setBounds(20, 139, 105, 14);
		panel.add(lblNewLabel_5);
		
		JTextArea txtrTest = new JTextArea();
		txtrTest.setBounds(20, 164, 437, 133);
		panel.add(txtrTest);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(100, 84, 46, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Respuestos usados:");
		lblNewLabel_7.setBounds(20, 333, 105, 14);
		panel.add(lblNewLabel_7);
		
		String[] colRespuestos = {"Id","Actividad", "Tiempo Req", "Predec"};
		Object[][] datosFilaRespuestos = { 
				{"A","EncuestaMercado",3,null},
				{"B","IconosGraficos",4,"A"},
				{"C","DiagFlujo",2,"A"},
				{"D","Diseño Entradas/Salidas",6,"B,C"},
				{"E","Modulo1",5,"C"},
				{"F","Modulo2",6,"C"},
				{"G","Modulo3",7,"E"},
				{"H","Modulo4",5,"E,F"},
				{"I","FusioonModulos",8,"D,G,H"},
		};
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 358, 437, 159);
		panel.add(scrollPane_1);
		tableRespuestoUsados = new JTable(datosFilaRespuestos, colRespuestos);
		scrollPane_1.setViewportView(tableRespuestoUsados);
		
		JButton btnFinalizar = new JButton("Finalizar Tarea");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnFinalizar.setBounds(346, 635, 111, 23);
		panel.add(btnFinalizar);
		
		JButton btnCancelarTarea = new JButton("Cancelar tarea");
		btnCancelarTarea.setBounds(10, 635, 126, 23);
		panel.add(btnCancelarTarea);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 623, 447, 2);
		panel.add(separator);
		
		
		
		
	}
}
