package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dominio.Auto;
import dominio.Cliente;
import dto.AutoDTO;
import dto.MecanicoDTO;
import gestor.GestorAuto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class CargarAutoGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textPatente;
	private JTextField textModelo;

	GestorAuto gAuto = new GestorAuto();
	
	public CargarAutoGUI(Cliente clienteAux) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 320);
		setTitle("Generar Tarea");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dar de alta un auto para:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 11, 180, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblClienteNombre = new JLabel(clienteAux.getPersona().getNombre()+" "+clienteAux.getPersona().getApellido() );
		lblClienteNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblClienteNombre.setBounds(20, 36, 170, 14);
		contentPane.add(lblClienteNombre);
		
		JLabel lblNewLabel_1 = new JLabel("Marca:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(52, 80, 78, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Modelo:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(52, 170, 78, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Patente:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(52, 125, 78, 14);
		contentPane.add(lblNewLabel_3);
		
		textPatente = new JTextField();
		textPatente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textPatente.setBounds(140, 125, 141, 20);
		contentPane.add(textPatente);
		textPatente.setColumns(10);
		
		textModelo = new JTextField();
		textModelo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textModelo.setBounds(140, 170, 141, 20);
		contentPane.add(textModelo);
		textModelo.setColumns(10);
		
		JButton btnAgregarAuto = new JButton("Asignar Auto");
		btnAgregarAuto.setBounds(283, 245, 141, 23);
		contentPane.add(btnAgregarAuto);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 245, 89, 23);
		contentPane.add(btnCancelar);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(140, 77, 141, 22);
		comboBox.addItem("Toyota");
		comboBox.addItem("Volkswagen");
		comboBox.addItem("Fiat");
		comboBox.addItem("Renault");
		comboBox.addItem("Ford");
		comboBox.addItem("Chevrolet");
		comboBox.addItem("Peugeot");
		comboBox.addItem("Nissan");
		comboBox.addItem("Honda");
		comboBox.addItem("Chery");
		comboBox.addItem("BMW");
		comboBox.addItem("Ram");
		contentPane.add(comboBox);
		
		btnAgregarAuto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				List<JTextField> avalidar = new ArrayList<JTextField>();
				avalidar.add(textPatente);
				avalidar.add(textModelo);
	
				if (validarHayVacios(avalidar)) {
					JOptionPane.showMessageDialog(null, "Existen campos sin completar");
				}
				else {

					try {

						Boolean validarDatosAuto = gAuto.validarDatos(textPatente,textModelo);
						if (validarDatosAuto) {
							AutoDTO autodto = new AutoDTO();
							autodto.setMarca(comboBox.getSelectedItem().toString());
							autodto.setModelo(textModelo.getText().toString());
							autodto.setPatente(textPatente.getText().toString());
							autodto.setDnicliente(clienteAux.getPersona().getNumeroDocumento().toString());
							try {
								gAuto.darDeAltaAuto(autodto);
								JOptionPane.showMessageDialog(null, "Datos cargados correctamente");
								dispose();
							} catch (Exception e1) {
								JOptionPane.showMessageDialog(new JPanel(), e1.getMessage(), "Error",
										JOptionPane.ERROR_MESSAGE);
								throw e1;
							}
						}

					} catch (Exception e2) {
						JOptionPane.showMessageDialog(new JPanel(), e2.getMessage(), "Error",
								JOptionPane.ERROR_MESSAGE);
					}

				}

			}
		});
		
		
		
	}
	
	boolean validarHayVacios(List<JTextField> av) {
		boolean flag = false;
	for (JTextField j : av) {
		if (j.getText().isEmpty()) {
			flag=true;
			j.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
		}
		else {
			j.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
		}	
	}
		return flag;	
	}
}
