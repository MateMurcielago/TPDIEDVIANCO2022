package tp.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import tp.app.App;

public class EventoOrigenDestino implements ActionListener {
	int cual;
	JFrame ventana;
	int id_origen;
	int id_destino;
	JLabel origen;
	JLabel destino;
	
	public EventoOrigenDestino(int cual) {
		super();
		this.cual = cual;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String aux = JOptionPane.showInputDialog("Ingrese el ID", "");
		if(App.isParada(Integer.valueOf(aux))) {
			if(cual == 1) {
				this.id_origen = Integer.valueOf(aux);
				this.origen.setText("Origen: "+App.direccionDe(Integer.valueOf(aux)));
			} else {
				this.id_destino = Integer.valueOf(aux);
				this.destino.setText("Destino: "+App.direccionDe(Integer.valueOf(aux)));
			}
			ventana.dispose();
			ScreensManager.nuevoCamino(origen, destino, id_origen, id_destino);
		}
	}
	
	public void configurar(JFrame ventana, int id_origen, int id_destino, JLabel origen, JLabel destino) {
		this.ventana = ventana;
		this.id_origen = id_origen;
		this.id_destino = id_destino;
		this.origen = origen;
		this.destino = destino;
	}
}
