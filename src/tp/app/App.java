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
import tp.swing.EventoBotonPulsado;
import tp.swing.ScreensManager;

public class App {
	public static void main(String[] args) {
		App.PantallaPrincipal();
	}
	
	public static void PantallaPrincipal() {
		JFrame ventana = new JFrame("Gestión de Transporte");
		JPanel botonera = new JPanel();
		JButton lineas = new JButton("Líneas");
		JButton paradas = new JButton("Paradas");
		JButton caminos = new JButton("Caminos");
		JButton incidencias = new JButton("Incidencias");
		JLabel texto = new JLabel("<html><div style='text-align: center;'>Bienvenido al "
		+"Sistema de Gestión de Transporte <br> Público</div></html>"
				, SwingConstants.CENTER);
		lineas.addActionListener(new EventoBotonPulsado());
		GridLayout gl1 = new GridLayout(2,0);
		gl1.setVgap(5);
		GridLayout glb = new GridLayout(2,2);
		glb.setHgap(10);
		glb.setVgap(15);
		Container c = ventana.getContentPane();
		c.setLayout(gl1);
		botonera.setLayout(glb);
		botonera.add(lineas);
		botonera.add(paradas);
		botonera.add(caminos);
		botonera.add(incidencias);
		c.add(texto);
		c.add(botonera);
		ventana.setSize(305, 200);
		ventana.setVisible(true);
	}
	
	public static void a() {
		JFrame ventana = new JFrame("A");
		ventana.setSize(305, 200);
		ventana.setVisible(true);
	}
}
