package app;

import java.awt.EventQueue;

import gui.Principal;
import util.ConnectionBD;

public class App {

	//taler 
	public static void main(String[] args) {	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {	
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/*public static void main(String[] args) {
		

		ConnectionBD bd = new ConnectionBD();
		System.out.println(ConnectionBD.conectar());
	}*/
}

