package tp.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import tp.app.App;

public class EventoParadaDirecta implements ActionListener {
	private int id_linea;
	private int id_parada;
	private JFrame ventana;
	private JTextField duracion;
	
	public EventoParadaDirecta() {
		super();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.duracion.getText().isBlank()) {
			JOptionPane.showMessageDialog(null,"Falta información","", JOptionPane.ERROR_MESSAGE);
		} else {
			App.AsignarParada(id_linea, id_parada, Integer.valueOf(duracion.getText()));
			ventana.dispose();
		}
	}
	
	public void configurar(int id_linea, int id_parada, JFrame ventana, JTextField duracion) {
		this.id_linea = id_linea;
		this.id_parada = id_parada;
		this.ventana = ventana;
		this.duracion = duracion;
	}
}
