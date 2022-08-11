package tp.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import tp.app.App;

public class EventoPrimeraParada implements ActionListener {
	private int id_linea;
	private int id_parada;
	private JFrame ventana;
	
	public EventoPrimeraParada() {
		super();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		App.asignarParada(id_linea, id_parada);
		ventana.dispose();
	}
	
	public void configurar(int id_linea, int id_parada, JFrame ventana) {
		this.id_linea = id_linea;
		this.id_parada = id_parada;
		this.ventana = ventana;
	}
}
