package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class GestionMecanicosGUI extends JFrame {

	private JPanel contentPane;

	public GestionMecanicosGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 150, 1280, 720);
		setResizable(false);
		setTitle("Gestion Mecanicos");
		setLocationRelativeTo(null); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnModificarMecanico = new JButton("Modificar Mecanico");
		btnModificarMecanico.setBounds(164, 81, 148, 23);
		contentPane.add(btnModificarMecanico);
		
		JButton btnAltaMecanico = new JButton("Dar Alta Mecanico");
		btnAltaMecanico.setBounds(164, 127, 148, 23);
		contentPane.add(btnAltaMecanico);
		
		JButton btnVolverPrincipal = new JButton("Volver");
		btnVolverPrincipal.setBounds(35, 619, 89, 23);
		contentPane.add(btnVolverPrincipal);
		
		
		AltaMecanicoGUI altaMecanico = new AltaMecanicoGUI();
		
		btnModificarMecanico.addActionListener(new ActionListener() {
			@Override
			
			public void actionPerformed(ActionEvent e) {
				
				final ListadoMecanicosGUI listaMec = new ListadoMecanicosGUI();
				listaMec.setVisible(true);
				dispose();
			}
		});
		btnAltaMecanico.addActionListener(new ActionListener() {
			@Override
			
			public void actionPerformed(ActionEvent e) {
				
				altaMecanico.setVisible(true);
				//dispose();
			}
		});
		btnVolverPrincipal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				final Principal ventanaP = new Principal();
				ventanaP.setVisible(true);
				dispose();
			}
		});
		
	
	}
}
