package app;

import java.awt.EventQueue;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Timer;
import java.util.TimerTask;

import gestor.GestorArranqueBD;
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
					boolean flag =true;
					GestorArranqueBD gBD = new GestorArranqueBD();
					
					if(gBD.localidadesCargadas()!=null) {
						MenuPrincipal menuP = new MenuPrincipal();
						menuP.setVisible(true);
					}
					else {
						System.out.println("no estan cargadas las provincias");
					}
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

