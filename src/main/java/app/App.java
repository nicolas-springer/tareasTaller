package app;

import java.awt.EventQueue;

import gui.MenuPrincipal;
import gui.Principal;
import util.ConnectionBD;

public class App {

	//taler 
	public static void main(String[] args) {	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {	
					//chequear provincias y localidades cargadas
					
					//Principal frame = new Principal();
					//frame.setVisible(true);
					//dni test: 30598741
					
					MenuPrincipal menuP = new MenuPrincipal();
					menuP.setVisible(true);
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

