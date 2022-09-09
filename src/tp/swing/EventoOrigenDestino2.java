package tp.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import tp.app.App;

public class EventoOrigenDestino2 implements ActionListener {
	private int cual;
	private JFrame ventana;
	private int id_origen;
	private int id_destino;
	
	public EventoOrigenDestino2(int cual) {
		super();
		this.cual = cual;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String aux = JOptionPane.showInputDialog("Ingrese el ID", "");
		if(App.isParada(Integer.valueOf(aux))) {
			if(cual == 1) {
				this.id_origen = Integer.valueOf(aux);
			} else {
				this.id_destino = Integer.valueOf(aux);
			}
			this.ventana.dispose();
			ScreensManager.boleteria(this.id_origen, this.id_destino);
		}
	}
	
	public void configurar(JFrame ventana, int id_origen, int id_destino) {
		this.ventana = ventana;
		this.id_origen = id_origen;
		this.id_destino = id_destino;
	}
}
