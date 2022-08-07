package tp.app;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import tp.clases.*;
import tp.db.*;
import tp.swing.ScreensManager;

public class App {
	private static ArrayList<Linea> lineas = new ArrayList<Linea>();
	
	public static void main(String[] args) {
		ScreensManager.PantallaPrincipal();
	}
	
	public static boolean hayLineas() {
		if(lineas.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
	
	public static void addLinea(String nombre, String color, int sentados, 
			int parados, boolean wifi, boolean aire, int tipo) {
		if(tipo == 1) {
			addEconomica(nombre, color, sentados, parados);
		} else {
			addSuperior(nombre, color, sentados, wifi, aire);
		}
	}
	
	private static void addEconomica(String nombre, String color, int sentados,
			int parados) {
		int id = 0;
		if(parados == -1) {
			lineas.add(new Economica(id + 1, nombre, color, sentados));
		} else {
			lineas.add(new Economica(id, nombre, color, sentados, parados));
		}
	}
	
	private static void addSuperior(String nombre, String color, int sentados,
			boolean wifi, boolean aire) {
		int id = 0;
		lineas.add(new Superior(id + 1, nombre, color, sentados, wifi, aire));
	}
}
