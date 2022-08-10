package tp.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import tp.app.App;

public class ScreensManager {
	//Fuente de menú
	private static Font fuente = new Font("Audiowide", Font.PLAIN, 18);
	
	//Eventos
	private static EventoBotonCaminosPulsado eventoBotonCaminosPulsado =
			new EventoBotonCaminosPulsado();
	private static EventoBotonLineasPulsado eventoBotonLineasPulsado = 
			new EventoBotonLineasPulsado();
	private static EventoBotonParadasPulsado eventoBotonParadasPulsado =
			new EventoBotonParadasPulsado();
	private static EventoCancelar eventoCancelar = new EventoCancelar();
	private static EventoDetallesCamino eventoDetallesCamino = new EventoDetallesCamino();
	private static EventoGuardarCamino eventoGuardarCamino = new EventoGuardarCamino();
	private static EventoGuardarIncidencia eventoGuardarIncidencia = new EventoGuardarIncidencia();
	private static EventoGuardarLinea eventoGuardarLinea = new EventoGuardarLinea();
	private static EventoGuardarParada eventoGuardarParada = new EventoGuardarParada();
	private static EventoNuevoCamino eventoNuevoCamino = new EventoNuevoCamino();
	private static EventoNuevaIncidencia eventoNuevaIncidencia = new EventoNuevaIncidencia();
	private static EventoNuevaLinea eventoNuevaLinea = new EventoNuevaLinea();
	private static EventoNuevaParada eventoNuevaParada = new EventoNuevaParada();
	private static EventoOrigenDestino eventoOrigen = new EventoOrigenDestino(1);
	private static EventoOrigenDestino eventoDestino = new EventoOrigenDestino(2);
	private static EventoParadasLinea eventoParadasLinea = new EventoParadasLinea();
	private static EventoVerCaminos eventoVerCaminos = new EventoVerCaminos();
	private static EventoVerIncidenciasCamino eventoVerIncidenciasCamino =
			new EventoVerIncidenciasCamino();
	private static EventoVerLineas eventoVerLineas = new EventoVerLineas();
	private static EventoVerParadas eventoVerParadas = new EventoVerParadas();
	
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
		paradas.addActionListener(eventoBotonParadasPulsado);
		caminos.addActionListener(eventoBotonCaminosPulsado);
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
		//JLabel texto1 = new JLabel("N° de Línea:");
		//texto1.setHorizontalAlignment(SwingConstants.RIGHT);
		//JTextField num = new JTextField(tamText);
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
		eventoGuardarLinea.configurar(nombre, color, sentados, parados, wifi, aire,
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
		//ventana.getContentPane().add(texto1, lugar);
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
		//ventana.getContentPane().add(num, lugar);
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
	
	public static void verLineas() {
		JFrame ventana = new JFrame("Ver Líneas");
		JLabel texto = new JLabel ("Elija una línea para ver más detalles");
		JPanel botonera = new JPanel();
		JScrollPane panelDeslizable = new JScrollPane();
		panelDeslizable.setBounds(800, 280, 366, 181);
		String[] columnas = {"ID", "Tipo", "Nombre", "Color", "Pasaj. Sentados",
				"Pasaj. Parados", "WiFi", "Aire Acond." };
		DefaultTableModel modelo = new DefaultTableModel(null, columnas);
		JButton paradas = new JButton("Paradas");
		
		ventana.setLayout(new GridBagLayout());
		botonera.setLayout(new GridBagLayout());
		GridBagConstraints lugar = new GridBagConstraints();

		JTable tabla = new JTable(modelo);
		tabla.setPreferredScrollableViewportSize(new Dimension(800, 280));
		panelDeslizable.setViewportView(tabla);
		
		eventoParadasLinea.configurar(tabla);
		paradas.addActionListener(eventoParadasLinea);
		
		ventana.setSize(900, 400);
		ventana.setLocationRelativeTo(null);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		for(int i = 0; i < App.getCantLineas(); i++) {
			modelo.addRow(App.getFilaLineas(i));
		}
		for(int i = 0; i < 8; i++) {
			tabla.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
		
		panelDeslizable.setViewportView(tabla);
		panelDeslizable.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		panelDeslizable.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		lugar.gridx = 0;
		lugar.gridy = 0;
		lugar.weighty = 1.0;
		lugar.weightx = 1.0;
		botonera.add(paradas, lugar);
		
		lugar.gridx = 0;
		lugar.gridy = 0;
		lugar.weighty = 1.0;
		lugar.weightx = 1.0;
		ventana.getContentPane().add(texto, lugar);
		lugar.gridy = 1;
		lugar.weighty = 0.0;
		lugar.weightx = 0.0;
		ventana.getContentPane().add(panelDeslizable, lugar);
		lugar.gridy = 2;
		lugar.weighty = 1.0;
		lugar.weightx = 1.0;
		ventana.getContentPane().add(botonera, lugar);
		//ventana.pack();
		ventana.setVisible(true);
	}
	
	public static void paradas() {
		JFrame ventana = new JFrame("Paradas");
		JPanel botonera = new JPanel();
		JButton ver = new JButton("Ver Paradas");
		JButton agregar = new JButton("Nueva Parada");
		JLabel texto = new JLabel("<html><div style='text-align: center;'> Gestión de "
				+"Paradas</div></html>", SwingConstants.CENTER);
		texto.setFont(fuente);
		ver.addActionListener(eventoVerParadas);
		agregar.addActionListener(eventoNuevaParada);
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
	
	public static void nuevaParada() {
		int tamText = 15;
		
		JFrame ventana = new JFrame("Nueva Parada");
		JLabel texto1 = new JLabel("N° Parada:");
		JTextField num = new JTextField(20);
		JLabel texto2 = new JLabel("Calle y N°:");
		JTextField calle = new JTextField(tamText);
		JTextField num_dir = new JTextField(4);
		JButton cancelar = new JButton("Cancelar");
		JButton guardar = new JButton("Guardar");
		
		eventoGuardarParada.configurar(num, calle, num_dir, ventana);
		guardar.addActionListener(eventoGuardarParada);
		eventoCancelar.configurar(ventana);
		cancelar.addActionListener(eventoCancelar);
		
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
		
		JPanel calle_y_num = new JPanel();
		calle_y_num.setLayout(new GridBagLayout());
		lugar.gridx = 0;
		lugar.gridy = 0;
		calle_y_num.add(calle, lugar);
		lugar.gridx = 1;
		calle_y_num.add(new JPanel(), lugar);
		lugar.gridx = 2;
		calle_y_num.add(num_dir, lugar);
		
		ventana.setSize(320, 120);
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
		lugar.gridx = 1;
		lugar.gridy = 0;
		lugar.gridwidth = 4;
		lugar.anchor = lugar.CENTER;
		ventana.getContentPane().add(num, lugar);
		lugar.gridy = 1;
		lugar.weighty = 0.0;
		ventana.getContentPane().add(calle_y_num, lugar);
		lugar.gridx = 0;
		lugar.gridy = 2;
		lugar.gridwidth = 5;
		ventana.getContentPane().add(botonera, lugar);
		ventana.setVisible(true);
	}
	
	public static void verParadas() {
		JFrame ventana = new JFrame("Ver Paradas");
		JLabel texto = new JLabel ("Elija una parada para ver más detalles");
		JPanel botonera = new JPanel();
		JScrollPane panelDeslizable = new JScrollPane();
		panelDeslizable.setBounds(600, 280, 366, 181);
		String[] columnas = {"ID", "N° Parada", "Calle", "N° Calle" };
		DefaultTableModel modelo = new DefaultTableModel(null, columnas);
		JButton paradas = new JButton("Paradas");

		ventana.setLayout(new GridBagLayout());
		botonera.setLayout(new GridBagLayout());
		GridBagConstraints lugar = new GridBagConstraints();

		JTable tabla = new JTable(modelo);
		tabla.setPreferredScrollableViewportSize(new Dimension(600, 280));
		panelDeslizable.setViewportView(tabla);

		ventana.setSize(700, 400);
		ventana.setLocationRelativeTo(null);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		for(int i = 0; i < App.getCantParadas(); i++) {
			modelo.addRow(App.getFilaParadas(i));
		}
		for(int i = 0; i < 4; i++) {
			tabla.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		panelDeslizable.setViewportView(tabla);
		panelDeslizable.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		panelDeslizable.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		lugar.gridx = 0;
		lugar.gridy = 0;
		lugar.weighty = 1.0;
		lugar.weightx = 1.0;
		botonera.add(paradas, lugar);
		
		lugar.gridx = 0;
		lugar.gridy = 0;
		lugar.weighty = 1.0;
		lugar.weightx = 1.0;
		ventana.getContentPane().add(texto, lugar);
		lugar.gridy = 1;
		lugar.weighty = 0.0;
		lugar.weightx = 0.0;
		ventana.getContentPane().add(panelDeslizable, lugar);
		lugar.gridy = 2;
		lugar.weighty = 1.0;
		lugar.weightx = 1.0;
		ventana.getContentPane().add(botonera, lugar);
		//ventana.pack();
		ventana.setVisible(true);
	}
	
	public static void caminos() {
		JFrame ventana = new JFrame("Caminos");
		JPanel botonera = new JPanel();
		JButton ver = new JButton("Ver Caminos");
		JButton agregar = new JButton("Nuevo Camino");
		JLabel texto = new JLabel("<html><div style='text-align: center;'> Gestión de "
				+"Caminos</div></html>", SwingConstants.CENTER);
		texto.setFont(fuente);
		agregar.addActionListener(eventoNuevoCamino);
		ver.addActionListener(eventoVerCaminos);
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
	
	public static void nuevoCamino() {
		int tamText = 15;
		int id_origen = 0;
		int id_destino = 0;
		
		JFrame ventana = new JFrame("Nuevo Camino");
		JLabel origen = new JLabel("Origen: -");
		JLabel destino = new JLabel("Destino: -");
		JLabel texto = new JLabel("Distancia:");
		JTextField distancia = new JTextField(tamText);
		JButton addOrigen = new JButton("Origen");
		JButton addDestino = new JButton("Destino");
		JButton guardar = new JButton("Guardar");
		JButton cancelar = new JButton("Cancelar");
		
		eventoOrigen.configurar(ventana, id_origen, id_destino, origen, destino);
		addOrigen.addActionListener(eventoOrigen);
		eventoDestino.configurar(ventana, id_origen, id_destino, origen, destino);
		addDestino.addActionListener(eventoDestino);
		eventoCancelar.configurar(ventana);
		cancelar.addActionListener(eventoCancelar);
		eventoGuardarCamino.configurar(ventana, id_origen, id_destino, distancia);
		guardar.addActionListener(eventoGuardarCamino);
		
		JPanel botonera1 = new JPanel();
		botonera1.setLayout(new GridBagLayout());
		GridBagConstraints lugar = new GridBagConstraints();
		lugar.gridx = 0;
		lugar.gridy = 0;
		lugar.gridwidth = 1;
		lugar.gridheight = 1;
		botonera1.add(addOrigen, lugar);
		lugar.gridx = 1;
		lugar.gridx = 2;
		botonera1.add(new JPanel(), lugar);
		lugar.gridx = 3;
		botonera1.add(addDestino, lugar);
		
		JPanel botonera2 = new JPanel();
		botonera2.setLayout(new GridBagLayout());
		lugar.gridx = 0;
		lugar.gridy = 0;
		lugar.gridwidth = 1;
		lugar.gridheight = 1;
		botonera2.add(guardar, lugar);
		lugar.gridx = 1;
		lugar.gridx = 2;
		botonera2.add(new JPanel(), lugar);
		lugar.gridx = 3;
		botonera2.add(cancelar, lugar);
		
		ventana.setSize(280, 180);
		ventana.setLocationRelativeTo(null);
		ventana.getContentPane().setLayout(new GridBagLayout());
		lugar.gridx = 0;
		lugar.gridy = 2;
		lugar.anchor = lugar.EAST;
		lugar.gridwidth = 1;
		lugar.gridheight = 1;
		lugar.weighty = 1.0;
		lugar.weightx = 1.0;
		ventana.getContentPane().add(texto, lugar);
		lugar.gridx = 1;
		lugar.gridy = 2;
		lugar.gridwidth = 4;
		lugar.anchor = lugar.CENTER;
		ventana.getContentPane().add(distancia, lugar);
		lugar.gridx = 0;
		lugar.gridy = 0;
		lugar.gridwidth = 5;
		ventana.getContentPane().add(origen, lugar);
		lugar.gridy = 1;
		ventana.getContentPane().add(destino, lugar);
		lugar.gridy = 3;
		ventana.getContentPane().add(botonera1, lugar);
		lugar.gridy = 4;
		ventana.getContentPane().add(botonera2, lugar);
		ventana.setVisible(true);
		
	}
	
	public static void nuevoCamino(JLabel origen, JLabel destino, int id_origen, int id_destino) {
		int tamText = 15;
		
		JFrame ventana = new JFrame("Nuevo Camino");
		JLabel texto = new JLabel("Distancia:");
		JTextField distancia = new JTextField(tamText);
		JButton addOrigen = new JButton("Origen");
		JButton addDestino = new JButton("Destino");
		JButton guardar = new JButton("Guardar");
		JButton cancelar = new JButton("Cancelar");
		
		eventoOrigen.configurar(ventana, id_origen, id_destino, origen, destino);
		addOrigen.addActionListener(eventoOrigen);
		eventoDestino.configurar(ventana, id_origen, id_destino, origen, destino);
		addDestino.addActionListener(eventoDestino);
		eventoCancelar.configurar(ventana);
		cancelar.addActionListener(eventoCancelar);
		eventoGuardarCamino.configurar(ventana, id_origen, id_destino, distancia);
		guardar.addActionListener(eventoGuardarCamino);
		
		JPanel botonera1 = new JPanel();
		botonera1.setLayout(new GridBagLayout());
		GridBagConstraints lugar = new GridBagConstraints();
		lugar.gridx = 0;
		lugar.gridy = 0;
		lugar.gridwidth = 1;
		lugar.gridheight = 1;
		botonera1.add(addOrigen, lugar);
		lugar.gridx = 1;
		lugar.gridx = 2;
		botonera1.add(new JPanel(), lugar);
		lugar.gridx = 3;
		botonera1.add(addDestino, lugar);
		
		JPanel botonera2 = new JPanel();
		botonera2.setLayout(new GridBagLayout());
		lugar.gridx = 0;
		lugar.gridy = 0;
		lugar.gridwidth = 1;
		lugar.gridheight = 1;
		botonera2.add(guardar, lugar);
		lugar.gridx = 1;
		lugar.gridx = 2;
		botonera2.add(new JPanel(), lugar);
		lugar.gridx = 3;
		botonera2.add(cancelar, lugar);
		
		ventana.setSize(280, 180);
		ventana.setLocationRelativeTo(null);
		ventana.getContentPane().setLayout(new GridBagLayout());
		lugar.gridx = 0;
		lugar.gridy = 2;
		lugar.anchor = lugar.EAST;
		lugar.gridwidth = 1;
		lugar.gridheight = 1;
		lugar.weighty = 1.0;
		lugar.weightx = 1.0;
		ventana.getContentPane().add(texto, lugar);
		lugar.gridx = 1;
		lugar.gridy = 2;
		lugar.gridwidth = 4;
		lugar.anchor = lugar.CENTER;
		ventana.getContentPane().add(distancia, lugar);
		lugar.gridx = 0;
		lugar.gridy = 0;
		lugar.gridwidth = 5;
		ventana.getContentPane().add(origen, lugar);
		lugar.gridy = 1;
		ventana.getContentPane().add(destino, lugar);
		lugar.gridy = 3;
		ventana.getContentPane().add(botonera1, lugar);
		lugar.gridy = 4;
		ventana.getContentPane().add(botonera2, lugar);
		ventana.setVisible(true);
		
	}
	
	public static void verCaminos() {
		JFrame ventana = new JFrame("Ver Caminos");
		JLabel texto = new JLabel ("Elija un camino para ver más detalles");
		JPanel botonera = new JPanel();
		JScrollPane panelDeslizable = new JScrollPane();
		panelDeslizable.setBounds(600, 280, 366, 181);
		String[] columnas = {"ID", "Origen", "Destino", "Distancia"};
		DefaultTableModel modelo = new DefaultTableModel(null, columnas);
		JButton ok = new JButton("Ok");

		ventana.setLayout(new GridBagLayout());
		botonera.setLayout(new GridBagLayout());
		GridBagConstraints lugar = new GridBagConstraints();

		JTable tabla = new JTable(modelo);
		tabla.setPreferredScrollableViewportSize(new Dimension(600, 280));
		panelDeslizable.setViewportView(tabla);
		

		eventoDetallesCamino.configurar(tabla);
		ok.addActionListener(eventoDetallesCamino);

		ventana.setSize(700, 400);
		ventana.setLocationRelativeTo(null);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		for(int i = 0; i < App.getCantCaminos(); i++) {
			modelo.addRow(App.getFilaCaminos(i));
		}
		for(int i = 0; i < 4; i++) {
			tabla.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		panelDeslizable.setViewportView(tabla);
		panelDeslizable.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		panelDeslizable.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		lugar.gridx = 0;
		lugar.gridy = 0;
		lugar.weighty = 1.0;
		lugar.weightx = 1.0;
		botonera.add(ok, lugar);
		
		lugar.gridx = 0;
		lugar.gridy = 0;
		lugar.weighty = 1.0;
		lugar.weightx = 1.0;
		ventana.getContentPane().add(texto, lugar);
		lugar.gridy = 1;
		lugar.weighty = 0.0;
		lugar.weightx = 0.0;
		ventana.getContentPane().add(panelDeslizable, lugar);
		lugar.gridy = 2;
		lugar.weighty = 1.0;
		lugar.weightx = 1.0;
		ventana.getContentPane().add(botonera, lugar);
		//ventana.pack();
		ventana.setVisible(true);
	}
	
	public static void detallesCamino(int id) {
		JFrame ventana = new JFrame("Más detalles");
		JLabel texto = new JLabel("<html><div style='text-align: center;'>Camino desde "
				+App.getOrigenDe(id)+" hasta "+App.getDestinoDe(id)+"</div></html>");
		JButton ver = new JButton("Ver Incidencias");
		JButton agregar = new JButton("Nueva Incidencia");
		JPanel botonera = new JPanel();
		
		eventoVerIncidenciasCamino.configurar(id);
		ver.addActionListener(eventoVerIncidenciasCamino);
		eventoNuevaIncidencia.configurar(id);
		agregar.addActionListener(eventoNuevaIncidencia);
		
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
	
	public static void nuevaIncidencia(int id) {
		int tam_text = 25;
		
		JFrame ventana = new JFrame("Nueva Incidencia");
		JLabel texto1 = new JLabel("Desc.:");
		JTextField descripcion = new JTextField(tam_text);
		JLabel texto2 = new JLabel("Inicio:");
		JTextField dia_inicio = new JTextField(2);
		JTextField mes_inicio = new JTextField(2);
		JTextField anio_inicio = new JTextField(4);
		JLabel texto3 = new JLabel("Fin:");
		JTextField dia_fin = new JTextField(2);
		JTextField mes_fin = new JTextField(2);
		JTextField anio_fin = new JTextField(4);
		JButton guardar = new JButton("Guardar");
		JButton cancelar = new JButton("Cancelar");
		
		eventoGuardarIncidencia.configurar(id, ventana, descripcion, dia_inicio, mes_inicio, anio_inicio,
				dia_fin, mes_fin, anio_fin);
		guardar.addActionListener(eventoGuardarIncidencia);
		eventoCancelar.configurar(ventana);
		cancelar.addActionListener(eventoCancelar);
		
		JPanel fechas = new JPanel();
		GridBagConstraints lugar = new GridBagConstraints();
		fechas.setLayout(new GridBagLayout());
		lugar.gridx = 0;
		lugar.gridy = 0;
		lugar.gridwidth = 1;
		lugar.gridheight = 1;
		fechas.add(texto2, lugar);
		lugar.gridx = 1;
		fechas.add(dia_inicio, lugar);
		lugar.gridx = 2;
		fechas.add(new JLabel("/"), lugar);
		lugar.gridx = 3;
		fechas.add(mes_inicio, lugar);
		lugar.gridx = 4;
		fechas.add(new JLabel("/"), lugar);
		lugar.gridx = 5;
		fechas.add(anio_inicio, lugar);
		lugar.gridx = 6;
		fechas.add(new JPanel());
		lugar.gridx = 7;
		fechas.add(texto3, lugar);
		lugar.gridx = 8;
		fechas.add(dia_fin, lugar);
		lugar.gridx = 9;
		fechas.add(new JLabel("/"), lugar);
		lugar.gridx = 10;
		fechas.add(mes_fin, lugar);
		lugar.gridx = 11;
		fechas.add(new JLabel("/"), lugar);
		lugar.gridx = 12;
		fechas.add(anio_fin, lugar);
		
		JPanel botonera = new JPanel();
		botonera.setLayout(new GridBagLayout());
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
		
		ventana.setSize(400, 120);
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
		lugar.gridx = 1;
		lugar.gridy = 0;
		lugar.gridwidth = 4;
		lugar.anchor = lugar.CENTER;
		ventana.getContentPane().add(descripcion, lugar);
		lugar.gridx = 0;
		lugar.gridy = 1;
		lugar.gridwidth = 5;
		ventana.getContentPane().add(fechas, lugar);
		lugar.gridy = 2;
		ventana.getContentPane().add(botonera, lugar);
		ventana.setVisible(true);
	}
	
	public static void verIncidencias(int id) {
		JFrame ventana = new JFrame("Incidencias");
		JLabel texto = new JLabel ("Elija la incidencia que desea finalizar");
		JPanel botonera = new JPanel();
		JScrollPane panelDeslizable = new JScrollPane();
		panelDeslizable.setBounds(600, 280, 366, 181);
		String[] columnas = {"ID", "Inicio", "Fin", "Descripción"};
		DefaultTableModel modelo = new DefaultTableModel(null, columnas);
		JButton ok = new JButton("Finalizar");

		ventana.setLayout(new GridBagLayout());
		botonera.setLayout(new GridBagLayout());
		GridBagConstraints lugar = new GridBagConstraints();

		JTable tabla = new JTable(modelo);
		tabla.setPreferredScrollableViewportSize(new Dimension(600, 280));
		panelDeslizable.setViewportView(tabla);

		ventana.setSize(700, 400);
		ventana.setLocationRelativeTo(null);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		for(int i = 0; i < App.getCantIncidenciasDe(id); i++) {
			modelo.addRow(App.getFilaIncidenciasDe(id, i));
		}
		for(int i = 0; i < 4; i++) {
			tabla.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		panelDeslizable.setViewportView(tabla);
		panelDeslizable.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		panelDeslizable.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		lugar.gridx = 0;
		lugar.gridy = 0;
		lugar.weighty = 1.0;
		lugar.weightx = 1.0;
		botonera.add(ok, lugar);
		
		lugar.gridx = 0;
		lugar.gridy = 0;
		lugar.weighty = 1.0;
		lugar.weightx = 1.0;
		ventana.getContentPane().add(texto, lugar);
		lugar.gridy = 1;
		lugar.weighty = 0.0;
		lugar.weightx = 0.0;
		ventana.getContentPane().add(panelDeslizable, lugar);
		lugar.gridy = 2;
		lugar.weighty = 1.0;
		lugar.weightx = 1.0;
		ventana.getContentPane().add(botonera, lugar);
		//ventana.pack();
		ventana.setVisible(true);
	}
	
	public static void finalizarIncidencia(int id) {
		JFrame ventana = new JFrame("Finalizar");
		JLabel texto = new JLabel("Fecha:");
		JTextField dia = new JTextField(2);
		JTextField mes = new JTextField(2);
		JTextField anio = new JTextField(4);
		JButton ok = new JButton("Ok");
		
		JPanel fechas = new JPanel();
		GridBagConstraints lugar = new GridBagConstraints();
		fechas.setLayout(new GridBagLayout());
		lugar.gridx = 0;
		lugar.gridy = 0;
		lugar.gridwidth = 1;
		lugar.gridheight = 1;
		fechas.add(texto, lugar);
		lugar.gridx = 1;
		fechas.add(dia, lugar);
		lugar.gridx = 2;
		fechas.add(new JLabel("/"), lugar);
		lugar.gridx = 3;
		fechas.add(mes, lugar);
		lugar.gridx = 4;
		fechas.add(new JLabel("/"), lugar);
		lugar.gridx = 5;
		fechas.add(anio, lugar);
		
		JPanel botonera = new JPanel();
		botonera.setLayout(new GridBagLayout());
		lugar.gridx = 0;
		lugar.gridy = 0;
		lugar.gridwidth = 1;
		lugar.gridheight = 1;
		botonera.add(ok, lugar);
		
		ventana.setSize(400, 120);
		ventana.setLocationRelativeTo(null);
		ventana.getContentPane().setLayout(new GridBagLayout());
		lugar.gridx = 0;
		lugar.gridy = 0;
		lugar.anchor = lugar.EAST;
		lugar.gridwidth = 1;
		lugar.gridheight = 1;
		lugar.weighty = 1.0;
		lugar.weightx = 1.0;
		ventana.getContentPane().add(fechas, lugar);
		lugar.gridx = 0;
		lugar.gridy = 1;
		lugar.gridwidth = 1;
		ventana.getContentPane().add(botonera, lugar);
	}
	
	public static void sinElementos() {
		JOptionPane.showMessageDialog(null,"Sin elementos para mostrar","",
				JOptionPane.ERROR_MESSAGE);
	}
}
