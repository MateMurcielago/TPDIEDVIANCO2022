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
}
