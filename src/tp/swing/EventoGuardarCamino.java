package tp.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import tp.app.App;

public class EventoGuardarCamino implements ActionListener {
	private JFrame ventana;
	private int id_origen;
	private int id_destino;
	private JTextField distancia;
	
	public EventoGuardarCamino() {
		super();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.id_origen == 0 || this.id_destino == 0 || this.distancia.getText().isBlank()) {
			JOptionPane.showMessageDialog(null,"Falta información","", JOptionPane.ERROR_MESSAGE);
		} else {
			App.addCamino(id_origen, id_destino, Integer.valueOf(distancia.getText()));
			this.ventana.dispose();
		}
	}
	
	public void configurar(JFrame ventana, int id_origen, int id_destino, JTextField distancia) {
		this.ventana = ventana;
		this.id_origen = id_origen;
		this.id_destino = id_destino;
		this.distancia = distancia;
	}
}
