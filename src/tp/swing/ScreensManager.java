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
	//Fuente de men�
	private static Font fuente = new Font("Audiowide", Font.PLAIN, 18); //Reemplazar con "Showcard Gothic",
		//si no se cuenta con dicha fuente en la PC (no viene de f�brica)
	
	//Eventos (demasiados eventos...)
	private static EventoAgregarCamino eventoAgregarCamino = new EventoAgregarCamino();
	private static EventoAgregarParada eventoAgregarParada = new EventoAgregarParada();
	private static EventoBoleteria eventoBoleteria = new EventoBoleteria();
	private static EventoBotonCaminosPulsado eventoBotonCaminosPulsado =
			new EventoBotonCaminosPulsado();
	private static EventoBotonLineasPulsado eventoBotonLineasPulsado = 
			new EventoBotonLineasPulsado();
	private static EventoBotonParadasPulsado eventoBotonParadasPulsado =
			new EventoBotonParadasPulsado();
	private static EventoBuscarLinea eventoBuscarLinea = new EventoBuscarLinea();
	private static EventoCancelar eventoCancelar = new EventoCancelar();
	private static EventoDetallesCamino eventoDetallesCamino = new EventoDetallesCamino();
	private static EventoDetallesLinea eventoDetallesLinea = new EventoDetallesLinea();
	private static EventoGuardarCamino eventoGuardarCamino = new EventoGuardarCamino();
	private static EventoGuardarIncidencia eventoGuardarIncidencia = new EventoGuardarIncidencia();
	private static EventoGuardarLinea eventoGuardarLinea = new EventoGuardarLinea();
	private static EventoGuardarParada eventoGuardarParada = new EventoGuardarParada();
	private static EventoNuevaParadaLinea eventoNuevaParadaLinea = new EventoNuevaParadaLinea();
	private static EventoNuevoCamino eventoNuevoCamino = new EventoNuevoCamino();
	private static EventoNuevoCaminoLinea eventoNuevoCaminoLinea = new EventoNuevoCaminoLinea();
	private static EventoNuevaIncidencia eventoNuevaIncidencia = new EventoNuevaIncidencia();
	private static EventoNuevaLinea eventoNuevaLinea = new EventoNuevaLinea();
	private static EventoNuevaParada eventoNuevaParada = new EventoNuevaParada();
	private static EventoOrigenDestino eventoOrigen = new EventoOrigenDestino(1);
	private static EventoOrigenDestino eventoDestino = new EventoOrigenDestino(2);
	private static EventoOrigenDestino2 eventoOrigen2 = new EventoOrigenDestino2(1);
	private static EventoOrigenDestino2 eventoDestino2 = new EventoOrigenDestino2(2);
	private static EventoParadaDirecta eventoParadaDirecta = new EventoParadaDirecta();
	private static EventoParadasLinea eventoParadasLinea = new EventoParadasLinea();
	private static EventoPrimeraParada eventoPrimeraParada = new EventoPrimeraParada();
	private static EventoVerCaminos eventoVerCaminos = new EventoVerCaminos();
	private static EventoVerCaminosDe eventoVerCaminosDe = new EventoVerCaminosDe();
	private static EventoVerIncidenciasCamino eventoVerIncidenciasCamino =
			new EventoVerIncidenciasCamino();
	private static EventoVerLineas eventoVerLineas = new EventoVerLineas();
	private static EventoVerParadas eventoVerParadas = new EventoVerParadas();
	private static EventoVerParadasDe eventoVerParadasDe = new EventoVerParadasDe();
	private static EventoVerTrayectos eventoVerTrayectos = new EventoVerTrayectos();
	
	public static void PantallaPrincipal() {
		JFrame ventana = new JFrame("Gesti�n de Transporte");
		
		JPanel botonera = new JPanel();
		JButton lineas = new JButton("L�neas");
		JButton paradas = new JButton("Paradas");
		JButton caminos = new JButton("Caminos");
		JButton incidencias = new JButton("Boleter�a");
		JLabel texto = new JLabel("<html><div style='text-align: center;'>Bienvenido al "
		+"Sistema de Gesti�n de Transporte P�blico</div></html>"
				, SwingConstants.CENTER);
		texto.setFont(fuente);
		lineas.addActionListener(eventoBotonLineasPulsado);
		paradas.addActionListener(eventoBotonParadasPulsado);
		caminos.addActionListener(eventoBotonCaminosPulsado);
		incidencias.addActionListener(eventoBoleteria);
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
		JFrame ventana = new JFrame("L�neas");
		JPanel botonera = new JPanel();
		JButton ver = new JButton("Ver L�neas");
		JButton agregar = new JButton("Nueva L�nea");
		JLabel texto = new JLabel("<html><div style='text-align: center;'> Gesti�n de "
				+"L�neas</div></html>", SwingConstants.CENTER);
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
		
		JFrame ventana = new JFrame("Nueva L�nea");
		//JLabel texto1 = new JLabel("N� de L�nea:");
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
		JFrame ventana = new JFrame("Ver L�neas");
		JLabel texto = new JLabel ("Elija una l�nea para ver m�s detalles");
		JPanel botonera = new JPanel();
		JScrollPane panelDeslizable = new JScrollPane();
		panelDeslizable.setBounds(800, 280, 366, 181);
		String[] columnas = {"ID", "Tipo", "Nombre", "Color", "Pasaj. Sentados",
				"Pasaj. Parados", "WiFi", "Aire Acond." };
		DefaultTableModel modelo = new DefaultTableModel(null, columnas);
		JButton paradas = new JButton("Ok");
		
		ventana.setLayout(new GridBagLayout());
		botonera.setLayout(new GridBagLayout());
		GridBagConstraints lugar = new GridBagConstraints();

		JTable tabla = new JTable(modelo);
		tabla.setPreferredScrollableViewportSize(new Dimension(800, 280));
		panelDeslizable.setViewportView(tabla);
		
		eventoDetallesLinea.configurar(tabla);
		paradas.addActionListener(eventoDetallesLinea);
		
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
	
	public static void detallesLinea(int id) {
		JFrame ventana = new JFrame("M�s detalles");
		JLabel texto = new JLabel("<html><div style='text-align: center;'>Detalles de la l�nea "
				+App.getNombreLinea(id)+"</div></html>");
		texto.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		JButton ver = new JButton("Ver Paradas");
		JButton tray = new JButton("Ver Trayecto");
		JButton agregar = new JButton("A�adir Parada");
		JButton agregarCam = new JButton("A�adir Camino");
		JButton verCam = new JButton("Ver Caminos");
		JPanel botonera = new JPanel();
		JPanel botonera2 = new JPanel();
		
		eventoAgregarParada.configurar(id);
		agregar.addActionListener(eventoAgregarParada);
		eventoVerParadasDe.configurar(id);
		ver.addActionListener(eventoVerParadasDe);
		eventoVerTrayectos.configurar(id);
		tray.addActionListener(eventoVerTrayectos);
		eventoVerCaminosDe.configurar(id);
		verCam.addActionListener(eventoVerCaminosDe);
		eventoAgregarCamino.configurar(id);
		agregarCam.addActionListener(eventoAgregarCamino);
		
		GridLayout gl = new GridLayout(3,0);
		gl.setVgap(5);
		GridLayout glb = new GridLayout(0,3);
		glb.setHgap(10);
		glb.setVgap(15);
		GridLayout glb2 = new GridLayout(0,2);
		glb2.setHgap(5);
		glb2.setVgap(15);
		botonera.setLayout(glb);
		botonera2.setLayout(glb2);
		Container c = ventana.getContentPane();
		c.setLayout(gl);
		botonera.setLayout(glb);
		botonera.add(ver);
		botonera.add(tray);
		botonera.add(verCam);
		botonera2.add(agregar);
		botonera2.add(agregarCam);
		c.add(texto);
		c.add(botonera);
		c.add(botonera2);
		
		ventana.setSize(450, 120);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}
	
	public static void primeraParada(int id) {
		String aux = JOptionPane.showInputDialog("Ingrese el ID", "");
		JFrame ventana = new JFrame("Nueva Parada");
		JLabel texto = new JLabel(App.direccionDe(Integer.valueOf(aux)));
		JButton ok = new JButton("Ok");
		JButton cancelar = new JButton("Cancelar");
		
		eventoPrimeraParada.configurar(id, Integer.valueOf(aux), ventana);
		ok.addActionListener(eventoPrimeraParada);
		eventoCancelar.configurar(ventana);
		cancelar.addActionListener(eventoCancelar);
		
		JPanel botonera = new JPanel();
		botonera.setLayout(new GridBagLayout());
		GridBagConstraints lugar = new GridBagConstraints();
		lugar.gridy = 0;
		lugar.gridx = 0;
		lugar.gridwidth = 1;
		lugar.gridheight = 1;
		botonera.add(ok, lugar);
		lugar.gridx = 1;
		botonera.add(new JPanel(), lugar);
		lugar.gridx = 2;
		botonera.add(cancelar, lugar);
		
		ventana.getContentPane().setLayout(new GridBagLayout());
		lugar.gridy = 0;
		lugar.gridx = 0;
		lugar.weighty = 1.0;
		lugar.weightx = 1.0;
		ventana.getContentPane().add(texto, lugar);
		lugar.gridy = 1;
		ventana.getContentPane().add(botonera, lugar);
		ventana.setSize(270, 100);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}
	
	public static void verParadasDe(int id) {
		JFrame ventana = new JFrame("Paradas de la l�nea");
		JLabel texto = new JLabel ("Todas las paradas de la l�nea");
		JPanel botonera = new JPanel();
		JScrollPane panelDeslizable = new JScrollPane();
		panelDeslizable.setBounds(600, 280, 366, 181);
		String[] columnas = {"ID", "N� Parada", "Calle", "N� Calle" };
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

		for(int i = 0; i < App.getCantParadasDe(id); i++) {
			modelo.addRow(App.getFilaParadasDe(id, i));
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
	
	public static void agregarParada(int id) {
		String aux = JOptionPane.showInputDialog("Ingrese el ID", "");
		if(App.existeCamino(App.getIDUltimaParada(id), Integer.valueOf(aux), true)) {
			JFrame ventana = new JFrame("Nueva Parada");
			JLabel texto = new JLabel(App.direccionDe(Integer.valueOf(aux)));
			JLabel texto2 = new JLabel("Duraci�n:");
			JTextField duracion = new JTextField(4);
			JButton ok = new JButton("Ok");
			JButton cancelar = new JButton("Cancelar");
			
			eventoNuevaParadaLinea.configurar(id, Integer.valueOf(aux), ventana, duracion);
			ok.addActionListener(eventoNuevaParadaLinea);
			eventoCancelar.configurar(ventana);
			cancelar.addActionListener(eventoCancelar);
			
			JPanel botonera = new JPanel();
			botonera.setLayout(new GridBagLayout());
			GridBagConstraints lugar = new GridBagConstraints();
			lugar.gridy = 0;
			lugar.gridx = 0;
			lugar.gridwidth = 1;
			lugar.gridheight = 1;
			botonera.add(ok, lugar);
			lugar.gridx = 1;
			botonera.add(new JPanel(), lugar);
			lugar.gridx = 2;
			botonera.add(cancelar, lugar);
			
			JPanel dur = new JPanel();
			dur.setLayout(new GridBagLayout());
			lugar.gridy = 0;
			lugar.gridx = 0;
			lugar.gridwidth = 1;
			lugar.gridheight = 1;
			dur.add(texto2, lugar);
			lugar.gridx = 1;
			botonera.add(new JPanel(), lugar);
			lugar.gridx = 2;
			dur.add(duracion, lugar);
			
			ventana.getContentPane().setLayout(new GridBagLayout());
			lugar.gridy = 0;
			lugar.gridx = 0;
			lugar.weighty = 1.0;
			lugar.weightx = 1.0;
			ventana.getContentPane().add(texto, lugar);
			lugar.gridy = 1;
			ventana.getContentPane().add(dur, lugar);
			lugar.gridy = 2;
			ventana.getContentPane().add(botonera, lugar);
			ventana.setSize(270, 150);
			ventana.setLocationRelativeTo(null);
			ventana.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null,"No existe camino hacia la parada","Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void paradaDirecta(int id) { //unused
		String aux = JOptionPane.showInputDialog("Ingrese el ID", "");
		if(App.caminoDirecto(App.getIDUltimaParada(id), Integer.valueOf(aux))) {
			JFrame ventana = new JFrame("Nueva Parada");
			JLabel texto = new JLabel(App.direccionDe(Integer.valueOf(aux)));
			JLabel texto2 = new JLabel("Duraci�n:");
			JTextField duracion = new JTextField(4);
			JButton ok = new JButton("Ok");
			JButton cancelar = new JButton("Cancelar");
			
			eventoParadaDirecta.configurar(id, Integer.valueOf(aux), ventana, duracion);
			ok.addActionListener(eventoParadaDirecta);
			eventoCancelar.configurar(ventana);
			cancelar.addActionListener(eventoCancelar);
			
			JPanel botonera = new JPanel();
			botonera.setLayout(new GridBagLayout());
			GridBagConstraints lugar = new GridBagConstraints();
			lugar.gridy = 0;
			lugar.gridx = 0;
			lugar.gridwidth = 1;
			lugar.gridheight = 1;
			botonera.add(ok, lugar);
			lugar.gridx = 1;
			botonera.add(new JPanel(), lugar);
			lugar.gridx = 2;
			botonera.add(cancelar, lugar);
			
			JPanel dur = new JPanel();
			dur.setLayout(new GridBagLayout());
			lugar.gridy = 0;
			lugar.gridx = 0;
			lugar.gridwidth = 1;
			lugar.gridheight = 1;
			dur.add(texto2, lugar);
			lugar.gridx = 1;
			botonera.add(new JPanel(), lugar);
			lugar.gridx = 2;
			dur.add(duracion, lugar);
			
			ventana.getContentPane().setLayout(new GridBagLayout());
			lugar.gridy = 0;
			lugar.gridx = 0;
			lugar.weighty = 1.0;
			lugar.weightx = 1.0;
			ventana.getContentPane().add(texto, lugar);
			lugar.gridy = 1;
			ventana.getContentPane().add(dur, lugar);
			lugar.gridy = 2;
			ventana.getContentPane().add(botonera, lugar);
			ventana.setSize(270, 150);
			ventana.setLocationRelativeTo(null);
			ventana.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null,"No existe camino directo hacia la parada","",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void verTrayectos(int id) {
		JFrame ventana = new JFrame("Trayectos de la l�nea");
		JLabel texto = new JLabel("Todos los trayectos de la l�nea");JPanel botonera = new JPanel();
		JScrollPane panelDeslizable = new JScrollPane();
		panelDeslizable.setBounds(600, 280, 366, 181);
		String[] columnas = {"ID", "Origen", "Destino", "Duraci�n"};
		DefaultTableModel modelo = new DefaultTableModel(null, columnas);
		JButton paradas = new JButton("Paradas");

		ventana.setLayout(new GridBagLayout());
		botonera.setLayout(new GridBagLayout());
		GridBagConstraints lugar = new GridBagConstraints();

		JTable tabla = new JTable(modelo);
		tabla.setPreferredScrollableViewportSize(new Dimension(600, 280));
		panelDeslizable.setViewportView(tabla);

		ventana.setSize(750, 400);
		ventana.setLocationRelativeTo(null);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		for(int i = 0; i < App.getCantTrayectosDe(id); i++) {
			modelo.addRow(App.getFilaTrayectos(id, i));
		}
		for(int i = 0; i < 5; i++) {
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
	
	public static void verCaminosDe(int id) {
		JFrame ventana = new JFrame("Caminos de la l�nea");
		JLabel texto = new JLabel ("Todos los caminos que recorre la l�nea");
		JPanel botonera = new JPanel();
		JScrollPane panelDeslizable = new JScrollPane();
		panelDeslizable.setBounds(600, 280, 366, 181);
		String[] columnas = {"ID", "Origen", "Destino", "Distancia"};
		DefaultTableModel modelo = new DefaultTableModel(null, columnas);
		JButton paradas = new JButton("Caminos");

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

		for(int i = 0; i < App.getCantCaminosDe(id); i++) {
			modelo.addRow(App.getFilaCaminosDe(id, i));
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
	
	public static void agregarCamino(int id) {
		String aux = JOptionPane.showInputDialog("Ingrese el ID", "");
		JFrame ventana = new JFrame("Nuevo Camino");
		JLabel texto1 = new JLabel("Camino desde");
		JLabel texto2 = new JLabel(App.getDireccionOrigenDe(Integer.valueOf(aux)));
		JLabel texto3 = new JLabel("hasta");
		JLabel texto4 = new JLabel(App.getDireccionDestinoDe(Integer.valueOf(aux)));
		JButton ok = new JButton("Ok");
		JButton cancelar = new JButton("Cancelar");
		
		eventoNuevoCaminoLinea.configurar(id, Integer.valueOf(aux), ventana);
		ok.addActionListener(eventoNuevoCaminoLinea);
		eventoCancelar.configurar(ventana);
		cancelar.addActionListener(eventoCancelar);
		
		JPanel botonera = new JPanel();
		botonera.setLayout(new GridBagLayout());
		GridBagConstraints lugar = new GridBagConstraints();
		lugar.gridy = 0;
		lugar.gridx = 0;
		lugar.gridwidth = 1;
		lugar.gridheight = 1;
		botonera.add(ok, lugar);
		lugar.gridx = 1;
		botonera.add(new JPanel(), lugar);
		lugar.gridx = 2;
		botonera.add(cancelar, lugar);
		
		ventana.getContentPane().setLayout(new GridBagLayout());
		lugar.gridy = 0;
		lugar.gridx = 0;
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
		ventana.getContentPane().add(botonera, lugar);
		ventana.setSize(270, 150);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}
	
	public static void paradas() {
		JFrame ventana = new JFrame("Paradas");
		JPanel botonera = new JPanel();
		JButton ver = new JButton("Ver Paradas");
		JButton agregar = new JButton("Nueva Parada");
		JLabel texto = new JLabel("<html><div style='text-align: center;'> Gesti�n de "
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
		JLabel texto1 = new JLabel("N� Parada:");
		JTextField num = new JTextField(20);
		JLabel texto2 = new JLabel("Calle y N�:");
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
		JLabel texto = new JLabel ("Elija una parada para ver m�s detalles");
		JPanel botonera = new JPanel();
		JScrollPane panelDeslizable = new JScrollPane();
		panelDeslizable.setBounds(600, 280, 366, 181);
		String[] columnas = {"ID", "N� Parada", "Calle", "N� Calle" };
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
		JLabel texto = new JLabel("<html><div style='text-align: center;'> Gesti�n de "
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
		JLabel texto = new JLabel ("Elija un camino para ver m�s detalles");
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
		JFrame ventana = new JFrame("M�s detalles");
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
		String[] columnas = {"ID", "Inicio", "Fin", "Descripci�n"};
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
	
	public static void boleteria() {
		int id_origen = -1;
		int id_destino = -1;
		
		JFrame ventana = new JFrame("Boleter�a");
		
		JButton addOrigen = new JButton("Origen");
		JButton addDestino = new JButton("Destino");
		
		JButton rapido = new JButton("M�s R�pido");
		JButton corto = new JButton("M�s Corto");
		JButton barato = new JButton("M�s Barato");
		
		JLabel texto1 = new JLabel("<html><div style='text-align: center;'>Bienvenido a "
		+"la Boleter�a</div></html>", SwingConstants.CENTER);
		texto1.setFont(fuente);
		JLabel texto2 = new JLabel("<html><div style='text-align: center;'>Rellene los requisitos "
				+"que debe cumplir la l�nea</div></html>", SwingConstants.CENTER);
		JLabel texto3 = new JLabel("Desde: -", SwingConstants.CENTER);
		JLabel texto4 = new JLabel("Hasta: -", SwingConstants.CENTER);
		
		eventoOrigen2.configurar(ventana, id_origen, id_destino);
		addOrigen.addActionListener(eventoOrigen2);
		eventoOrigen2.configurar(ventana, id_origen, id_destino);
		addDestino.addActionListener(eventoDestino2);
		eventoBuscarLinea.configurar(ventana, id_origen, id_destino);
		rapido.addActionListener(eventoBuscarLinea);
		corto.addActionListener(eventoBuscarLinea);
		barato.addActionListener(eventoBuscarLinea);
		
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
		botonera2.add(rapido, lugar);
		lugar.gridx = 1;
		lugar.gridx = 2;
		botonera2.add(new JPanel(), lugar);
		lugar.gridx = 3;
		botonera2.add(corto, lugar);
		lugar.gridx = 4;
		botonera2.add(new JPanel(), lugar);
		lugar.gridx = 5;
		botonera2.add(barato, lugar);
		
		ventana.setSize(350, 250);
		ventana.setLocationRelativeTo(null);
		ventana.getContentPane().setLayout(new GridBagLayout());
		lugar.weighty = 1.0;
		lugar.weightx = 1.0;
		lugar.gridx =0;
		lugar.gridy = 0;
		lugar.gridwidth = 1;
		lugar.gridheight = 1;
		ventana.getContentPane().add(texto1, lugar);
		lugar.gridy = 1;
		ventana.getContentPane().add(texto2, lugar);
		lugar.gridy = 2;
		ventana.getContentPane().add(texto3, lugar);
		lugar.gridy = 3;
		ventana.getContentPane().add(texto4, lugar);
		lugar.gridy = 4;
		ventana.getContentPane().add(botonera1, lugar);
		lugar.gridy = 5;
		ventana.getContentPane().add(botonera2, lugar);
		ventana.setVisible(true);
	}
	
	public static void boleteria(int id_origen, int id_destino) {
		JFrame ventana = new JFrame("Boleter�a");
		
		JButton addOrigen = new JButton("Origen");
		JButton addDestino = new JButton("Destino");
		
		JButton rapido = new JButton("M�s R�pido");
		JButton corto = new JButton("M�s Corto");
		JButton barato = new JButton("M�s Barato");
		
		JLabel texto1 = new JLabel("<html><div style='text-align: center;'>Bienvenido a "
		+"la Boleter�a</div></html>", SwingConstants.CENTER);
		texto1.setFont(fuente);
		JLabel texto2 = new JLabel("<html><div style='text-align: center;'>Rellene los requisitos "
				+"que debe cumplir la l�nea</div></html>", SwingConstants.CENTER);
		JLabel texto3 = new JLabel();
		texto3.setAlignmentX(SwingConstants.CENTER);
		JLabel texto4 = new JLabel();
		texto4.setAlignmentX(SwingConstants.CENTER);
		if(id_origen != -1) {
			texto3.setText("Desde: "+App.direccionDe(id_origen));
		} else texto3.setText("Desde: -");
		if(id_destino != -1) texto4.setText("Hasta: "+App.direccionDe(id_destino));
		else texto4.setText("Hasta: -");
		
		eventoOrigen2.configurar(ventana, id_origen, id_destino);
		addOrigen.addActionListener(eventoOrigen2);
		eventoDestino2.configurar(ventana, id_origen, id_destino);
		addDestino.addActionListener(eventoDestino2);
		eventoBuscarLinea.configurar(ventana, id_origen, id_destino);
		rapido.addActionListener(eventoBuscarLinea);
		corto.addActionListener(eventoBuscarLinea);
		barato.addActionListener(eventoBuscarLinea);
		
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
		botonera2.add(rapido, lugar);
		lugar.gridx = 1;
		lugar.gridx = 2;
		botonera2.add(new JPanel(), lugar);
		lugar.gridx = 3;
		botonera2.add(corto, lugar);
		lugar.gridx = 4;
		botonera2.add(new JPanel(), lugar);
		lugar.gridx = 5;
		botonera2.add(barato, lugar);
		
		ventana.setSize(350, 250);
		ventana.setLocationRelativeTo(null);
		ventana.getContentPane().setLayout(new GridBagLayout());
		lugar.weighty = 1.0;
		lugar.weightx = 1.0;
		lugar.gridx =0;
		lugar.gridy = 0;
		lugar.gridwidth = 1;
		lugar.gridheight = 1;
		ventana.getContentPane().add(texto1, lugar);
		lugar.gridy = 1;
		ventana.getContentPane().add(texto2, lugar);
		lugar.gridy = 2;
		ventana.getContentPane().add(texto3, lugar);
		lugar.gridy = 3;
		ventana.getContentPane().add(texto4, lugar);
		lugar.gridy = 4;
		ventana.getContentPane().add(botonera1, lugar);
		lugar.gridy = 5;
		ventana.getContentPane().add(botonera2, lugar);
		ventana.setVisible(true);
	}
	
	public static void boleto(int id, int id_origen, int id_destino) {
		JFrame ventana = new JFrame("Boleto");
		JLabel texto1 = new JLabel("L�nea: "+App.getNombreDe(id), SwingConstants.CENTER);
		JLabel texto2 = new JLabel("Origen: "+App.direccionDe(id_origen), SwingConstants.CENTER);
		JLabel texto3 = new JLabel("Destino: "+App.direccionDe(id_destino), SwingConstants.CENTER);
		JLabel texto4 = new JLabel("Duraci�n: "+App.getDuracionDe(id, id_origen, id_destino), 
				SwingConstants.CENTER);
		JLabel texto5 = new JLabel("Distancia: "+App.getDistanciaDe(id, id_origen, id_destino), 
				SwingConstants.CENTER);
		JLabel texto6 = new JLabel("Precio: $", SwingConstants.CENTER);
	}
	
	public static void sinElementos() {
		JOptionPane.showMessageDialog(null,"Sin elementos para mostrar","",
				JOptionPane.ERROR_MESSAGE);
	}
}
