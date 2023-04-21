package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextPane;
import javax.swing.JButton;

public class SoporteGUI extends JFrame {

	private JPanel contentPane;

	public SoporteGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 320);
		setTitle("Ayuda y soporte");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("En caso de problemas técnicos, contactarse al siguiente");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(27, 57, 397, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblEmailDevnicospringergmailcom = new JLabel("email:");
		lblEmailDevnicospringergmailcom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmailDevnicospringergmailcom.setBounds(27, 102, 51, 34);
		contentPane.add(lblEmailDevnicospringergmailcom);
		
		JLabel lblDetallandoNumeroDe = new JLabel("Detallando su número de cliente y problema.");
		lblDetallandoNumeroDe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDetallandoNumeroDe.setBounds(27, 147, 397, 34);
		contentPane.add(lblDetallandoNumeroDe);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(165, 247, 89, 23);
		contentPane.add(btnCerrar);
		
		JTextPane txtpnDevnicospringergmailcom = new JTextPane();
		txtpnDevnicospringergmailcom.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnDevnicospringergmailcom.setText("dev.nicospringer@gmail.com");
		txtpnDevnicospringergmailcom.setBounds(79, 107, 299, 23);
		txtpnDevnicospringergmailcom.setEditable(false);
		contentPane.add(txtpnDevnicospringergmailcom);
		
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
