package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.SystemColor;
import javax.swing.border.LineBorder;

import gestor.GestorAnotacion;

import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class MenuPrincipal extends JFrame {

	private JPanel contentPane;

	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 1280, 720);
		setResizable(false);
		setTitle("Gestiones");
		setLocationRelativeTo(null); 
		//cargar localidades y provincias sql
		//GestorProvincia gp = new GestorProvincia();
		//GestorLocalidad gl = new GestorLocalidad();
		//gp.cargarProvinciasBD();
		//gl.cargarLocalidadesBD();
		generarMenuPrincipal();

	}

	public void generarMenuPrincipal() {

		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(SystemColor.activeCaptionBorder);
		separator.setBounds(316, 30, 3, 620);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBackground(SystemColor.activeCaptionBorder);
		separator_1.setBounds(632, 30, 3, 620);
		contentPane.add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1.setBackground(SystemColor.activeCaptionBorder);
		separator_1_1.setBounds(948, 30, 3, 620);
		contentPane.add(separator_1_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 10, 1264, 2);
		contentPane.add(separator_2);
		
		JLabel lblNewLabel = new JLabel("GESTION FACTURAS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 30, 297, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblGestionStock = new JLabel("GESTION STOCK");
		lblGestionStock.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionStock.setHorizontalTextPosition(SwingConstants.CENTER);
		lblGestionStock.setFont(new Font("Arial", Font.BOLD, 20));
		lblGestionStock.setBounds(10, 370, 296, 31);
		contentPane.add(lblGestionStock);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(0, 340, 1264, 3);
		contentPane.add(separator_2_1);
		
		JSeparator separator_2_2 = new JSeparator();
		separator_2_2.setBounds(0, 671, 1264, 2);
		contentPane.add(separator_2_2);
		
		JLabel lblGestionTareas = new JLabel("GESTION TAREAS");
		lblGestionTareas.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionTareas.setFont(new Font("Arial", Font.BOLD, 20));
		lblGestionTareas.setBounds(329, 30, 293, 31);
		contentPane.add(lblGestionTareas);
		
		JLabel lblNewLabel_1_1 = new JLabel("GESTION CLIENTES");
		lblNewLabel_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(645, 30, 293, 31);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("GESTION MECANICOS");
		lblNewLabel_1_1_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1_1_2.setBounds(329, 370, 293, 31);
		contentPane.add(lblNewLabel_1_1_2);
		
		JButton btnListadoTarea = new JButton("Listado de tareas");
		btnListadoTarea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnListadoTarea.setBounds(364, 100, 220, 40);
		contentPane.add(btnListadoTarea);
		
		JButton btnAgregarTarea = new JButton("Agregar tarea");
		btnAgregarTarea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAgregarTarea.setBounds(364, 170, 220, 40);
		contentPane.add(btnAgregarTarea);
		
		JButton btnListadoDeClientes = new JButton("Listado de clientes");
		btnListadoDeClientes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnListadoDeClientes.setBounds(680, 100, 220, 40);
		contentPane.add(btnListadoDeClientes);
		
		JButton btnCargarNuevoCliente = new JButton("Cargar nuevo cliente");
		btnCargarNuevoCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCargarNuevoCliente.setBounds(680, 170, 220, 40);
		contentPane.add(btnCargarNuevoCliente);
		
		JButton btnCargarNuevoMecanico = new JButton("Cargar nuevo mecanico");
		btnCargarNuevoMecanico.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCargarNuevoMecanico.setBounds(364, 510, 220, 40);
		contentPane.add(btnCargarNuevoMecanico);
		
		JButton btnListadoDeMecanicos = new JButton("Listado de mecanicos");
		btnListadoDeMecanicos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnListadoDeMecanicos.setBounds(364, 440, 220, 40);
		contentPane.add(btnListadoDeMecanicos);
		
		JLabel lblNewLabel_1 = new JLabel("enlace a explorador google");
		lblNewLabel_1.setBounds(991, 196, 200, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("encale a bandeja de correo");
		lblNewLabel_2.setBounds(991, 227, 207, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Anotaciones:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(959, 349, 125, 31);
		contentPane.add(lblNewLabel_3);
		
		JButton btnGuardarNota = new JButton("Guardar Nota");
		btnGuardarNota.setBounds(1142, 627, 112, 23);
		contentPane.add(btnGuardarNota);
		
		JButton btnVerNotas = new JButton("Ver Notas");
		btnVerNotas.setBounds(961, 627, 112, 23);
		contentPane.add(btnVerNotas);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBorder(new LineBorder(Color.GRAY));
		textArea.setBounds(961, 391, 293, 225);
		textArea.setText("");
		contentPane.add(textArea);
		
		JButton btnConsultarStock = new JButton("Listado Stock");
		btnConsultarStock.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConsultarStock.setBounds(48, 440, 220, 40);
		contentPane.add(btnConsultarStock);
		
		JButton btnAgregarInsumo = new JButton("Agregar Insumo");
		btnAgregarInsumo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAgregarInsumo.setBounds(48, 510, 220, 40);
		contentPane.add(btnAgregarInsumo);
		
		JButton btnListadoDeFacturas = new JButton("Listado de facturas");
		btnListadoDeFacturas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnListadoDeFacturas.setBounds(48, 100, 220, 40);
		contentPane.add(btnListadoDeFacturas);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Hora actual:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(1123, 30, 131, 62);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblReloj = new JLabel("");
		lblReloj.setBounds(10, 11, 111, 40);
		panel.add(lblReloj);
		lblReloj.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		JLabel lblNewLabel_1_2 = new JLabel("Gadgets");
		lblNewLabel_1_2.setBounds(991, 160, 200, 14);
		contentPane.add(lblNewLabel_1_2);
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
            	String lt = LocalTime.now().format(formatter);
            	lblReloj.setText(lt);
            }
        }, 0, 1000);
		
	
		btnListadoDeMecanicos.addActionListener(new ActionListener() {
			@Override
			
			public void actionPerformed(ActionEvent e) {
				
				final ListadoMecanicosGUI listaMec = new ListadoMecanicosGUI();
				listaMec.setVisible(true);
				dispose();
			}
		});
		btnCargarNuevoMecanico.addActionListener(new ActionListener() {
			@Override
			
			public void actionPerformed(ActionEvent e) {
				AltaMecanicoGUI altaMecanico = new AltaMecanicoGUI();
				altaMecanico.setVisible(true);
				//dispose();
			}
		});
		
		btnListadoTarea.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				final ListadoTareasGUI listadoTareas = new ListadoTareasGUI();
				listadoTareas.setVisible(true);
				dispose();
			}
		});
		btnAgregarTarea.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("test");
			}
		});
		
		btnListadoDeClientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				final ListadoClientesGUI listado = new ListadoClientesGUI();
				listado.setVisible(true);
				dispose();
			}
		});
		
		
		
		btnCargarNuevoCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				final AltaClienteGUI altaCliente = new AltaClienteGUI();
				altaCliente.setVisible(true);
			}
		});
		
		btnGuardarNota.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				GestorAnotacion gAnotacion = new GestorAnotacion();
				if(textArea.getText().toString().length()==0) {
					JOptionPane.showMessageDialog(null, 
			                "No se pueden guardar notas vacias.", 
			                "CUIDADO", 
			                JOptionPane.WARNING_MESSAGE);
				}
				else{
					gAnotacion.darAltaNota(textArea.getText());
					textArea.setText("");	
				}
				
			}
		});
		btnVerNotas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//ventana de notas
				final ListadoAnotacionesGUI la = new ListadoAnotacionesGUI();
				la.setLocationRelativeTo(null);
				la.setVisible(true);
			}
		});

		btnAgregarTarea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GenerarTareaGUI generarTarea = new GenerarTareaGUI();
				generarTarea.setLocationRelativeTo(null);
				generarTarea.setVisible(true);
			}
		});
		
	}
}

