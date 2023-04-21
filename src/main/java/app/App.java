package app;

import java.awt.EventQueue;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.persistence.EntityManager;

import dominio.Anotacion;
import gestor.GestorArranqueBD;
import gui.MenuPrincipal;
import gui.Principal;
import util.ConnectionBD;

public class App {

	public static void main(String[] args) {	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				MenuPrincipal menuP = new MenuPrincipal();
				//menuP.setVisible(true);
				try {	
					GestorArranqueBD gBD = new GestorArranqueBD();
					if(gBD.localidadesCargadas()!=null) {
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

