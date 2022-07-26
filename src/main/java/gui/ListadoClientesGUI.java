package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dominio.Cliente;
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

	public ListadoClientesGUI() {

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
			List<Cliente> listaClientes = gCliente.recuperarClientes();
			final GestorDireccion gDireccion = new GestorDireccion();
			final GestorLocalidad gLocalidad = new GestorLocalidad();
			
			for (String s : colTareas) model.addColumn(s);

			for(Cliente c : listaClientes) {
				Direccion d = gDireccion.recuperarDireccion(c.getPersona().getDireccion().getId_Direccion());
				Localidad l = gLocalidad.recuperarLocalidadID(d.getLocalidad().getIdLocalidad());
				model.addRow(new Object[]{c.getPersona().getApellido(),c.getPersona().getNombre(),
						c.getPersona().getNumeroDocumento(),c.getPersona().getTelefono(),
						d.getCalle(),d.getNumero(),d.getPiso(),d.getPiso(),l.getNombre()});
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
					AltaMecanicoGUI altaMecanico = new AltaMecanicoGUI();
					altaMecanico.setVisible(true);
					//dispose();
				}
			});
	}

}
