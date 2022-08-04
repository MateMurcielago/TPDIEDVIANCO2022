package tp.swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ScreensManager {
	//Fuente de menú
	private static Font fuente = new Font("Audiowide", Font.PLAIN, 18);
	
	//Eventos
	private static EventoBotonLineasPulsado eventoBotonLineasPulsado = 
			new EventoBotonLineasPulsado();
	private static EventoCancelar eventoCancelar = new EventoCancelar();
	private static EventoGuardarLinea eventoGuardarLinea = new EventoGuardarLinea();
	private static EventoNuevaLinea eventoNuevaLinea = new EventoNuevaLinea();
	private static EventoVerLineas eventoVerLineas = new EventoVerLineas();
	
	public static void PantallaPrincipal() {
		JFrame ventana = new JFrame("Gestión de Transporte");
		JPanel botonera = new JPanel();
		JButton lineas = new JButton("Líneas");
		JButton paradas = new JButton("Paradas");
		JButton caminos = new JButton("Caminos");
		JButton incidencias = new JButton("Incidencias");
		JLabel texto = new JLabel("<html><div style='text-align: center;'>Bienvenido al "
		+"Sistema de Gestión de Transporte Público</div></html>"
				, SwingConstants.CENTER);
		texto.setFont(fuente);
		lineas.addActionListener(eventoBotonLineasPulsado);
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
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}
	
	public static void Lineas() {
		JFrame ventana = new JFrame("Líneas");
		JPanel botonera = new JPanel();
		JButton ver = new JButton("Ver Líneas");
		JButton agregar = new JButton("Nueva Línea");
		JLabel texto = new JLabel("<html><div style='text-align: center;'> Gestión de "
				+"Líneas</div></html>", SwingConstants.CENTER);
		texto.setFont(fuente);
		ver.addActionListener(eventoVerLineas);
		agregar.addActionListener(eventoNuevaLinea);
		GridLayout gl = new GridLayout(2,0);
		gl.setVgap(5);
		GridLayout glb = new GridLayout(0,2);
		glb.setHgap(10);
		glb.setVgap(15);
		botonera.setLayout(glb);
		Container c = ventana.getContentPane();
		c.setLayout(gl);
		botonera.setLayout(glb);
		botonera.add(ver);
		botonera.add(agregar);
		c.add(texto);
		c.add(botonera);
		ventana.setSize(270, 100);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}
	
	public static void nuevaLinea(int tipo) {
		int tamText = 15;
		
		JFrame ventana = new JFrame("Nueva Línea");
		JLabel texto1 = new JLabel("N° de Línea:");
		texto1.setHorizontalAlignment(SwingConstants.RIGHT);
		JTextField num = new JTextField(tamText);
		JLabel texto2 = new JLabel("Nombre:");
		JTextField nombre = new JTextField(tamText);
		JLabel texto3 = new JLabel("Color:");
		JTextField color = new JTextField(tamText);
		JLabel texto4 = new JLabel("Pasaj. Sentados:");
		JTextField sentados = new JTextField(tamText);
		JLabel texto5 = new JLabel("Pasaj. Parados:");
		JTextField parados = new JTextField(tamText);
		JRadioButton wifi = new JRadioButton("WiFi");
		JRadioButton aire = new JRadioButton("Aire Acond.");
		JButton cancelar = new JButton("Cancelar");
		JButton guardar = new JButton("Guardar");
		
		eventoCancelar.configurar(ventana);
		cancelar.addActionListener(eventoCancelar);
		eventoGuardarLinea.configurar(num, nombre, color, sentados, parados, wifi, aire,
				tipo, ventana);
		guardar.addActionListener(eventoGuardarLinea);
		
		JPanel botonera = new JPanel();
		botonera.setLayout(new GridBagLayout());
		GridBagConstraints lugar = new GridBagConstraints();
		lugar.gridx = 0;
		lugar.gridy = 0;
		lugar.gridwidth = 1;
		lugar.gridheight = 1;
		botonera.add(guardar, lugar);
		lugar.gridx = 1;
		lugar.gridx = 2;
		botonera.add(new JPanel(), lugar);
		lugar.gridx = 3;
		botonera.add(cancelar, lugar);
		
		JPanel servicios = new JPanel();
		servicios.add(wifi);
		servicios.add(aire);

		ventana.setSize(300, 200);
		if(tipo == 2) ventana.setSize(300, 200);
		ventana.setLocationRelativeTo(null);
		ventana.getContentPane().setLayout(new GridBagLayout());
		lugar.gridx = 0;
		lugar.gridy = 0;
		lugar.anchor = lugar.EAST;
		lugar.gridwidth = 1;
		lugar.gridheight = 1;
		lugar.weighty = 1.0;
		lugar.weightx = 1.0;
		ventana.getContentPane().add(texto1, lugar);
		lugar.gridy = 1;
		ventana.getContentPane().add(texto2, lugar);
		lugar.gridy = 2;
		ventana.getContentPane().add(texto3, lugar);
		lugar.gridy = 3;
		ventana.getContentPane().add(texto4, lugar);
		lugar.gridy = 4;
		if(tipo == 1) {
			ventana.getContentPane().add(texto5, lugar);
		}
		lugar.gridx = 1;
		lugar.gridy = 0;
		lugar.gridwidth = 4;
		lugar.anchor = lugar.CENTER;
		ventana.getContentPane().add(num, lugar);
		lugar.gridy = 1;
		lugar.weighty = 0.0;
		ventana.getContentPane().add(nombre, lugar);
		lugar.gridy = 2;
		ventana.getContentPane().add(color, lugar);
		lugar.gridy = 3;
		ventana.getContentPane().add(sentados, lugar);
		lugar.gridy = 4;
		if(tipo == 1) {
			ventana.getContentPane().add(parados, lugar);
		}
		lugar.gridx = 0;
		lugar.gridy = 5;
		lugar.gridwidth = 5;
		ventana.getContentPane().add(botonera, lugar);
		/*ventana.getContentPane().add(guardar, lugar);
		lugar.gridx = 3;
		ventana.getContentPane().add(cancelar, lugar);*/
		if(tipo == 2) {
			/*lugar.gridx = 0;
			lugar.gridy = 4;
			ventana.getContentPane().add(wifi, lugar);
			lugar.gridx = 1;
			ventana.getContentPane().add(aire, lugar);*/
			lugar.gridx = 0;
			lugar.gridy = 4;
			lugar.gridwidth = 5;
			ventana.getContentPane().add(servicios, lugar);
		}
		ventana.setVisible(true);
	}
	
	public static void sinElementos() {
		JOptionPane.showMessageDialog(null,"Sin elementos para mostrar","",
				JOptionPane.ERROR_MESSAGE);
	}
}
