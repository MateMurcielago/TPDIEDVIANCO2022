package tp.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import tp.app.App;

public class EventoNuevoCaminoLinea implements ActionListener {
	private static int id_linea;
	private static int id_camino;
	private JFrame ventana;
	
	public EventoNuevoCaminoLinea() {
		super();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		App.AsignarCamino(id_linea, id_camino);
		this.ventana.dispose();
	}
	
	public void configurar(int id_linea, int id_camino, JFrame ventana) {
		this.id_linea = id_linea;
		this.id_camino = id_camino;
		this.ventana = ventana;
	}
}
