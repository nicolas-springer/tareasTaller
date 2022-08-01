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

	public static void main(String[] args) {	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {	
					GestorArranqueBD gBD = new GestorArranqueBD();
					if(gBD.localidadesCargadas()!=null) {
						MenuPrincipal menuP = new MenuPrincipal();
						menuP.setVisible(true);
					}
					else {
						System.out.println("no estan cargadas las provincias");
						gBD.cargarProvinciasYLocalidades();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

