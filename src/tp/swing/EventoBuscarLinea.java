package tp.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import tp.app.App;

public class EventoBuscarLinea implements ActionListener {
	private JFrame ventana;
	private int id_origen;
	private int id_destino;
	
	public EventoBuscarLinea() {
		super();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.id_origen != -1 && this.id_destino != -1) {
			int opcion = -1;
			if(e.getActionCommand().equals("M�s R�pido")) { 
				opcion = 0;
			} else if(e.getActionCommand().equals("M�s Corto")) {
				opcion = 1;
			} else if(e.getActionCommand().equals("M�s Barato")) {
				opcion = 2;
			}
			this.ventana.dispose();
			int id = App.boleto(this.id_origen, this.id_destino, opcion);
			if(id != -1) {
				ScreensManager.boleto(id ,this.id_origen, this.id_destino);
			} else {
				JOptionPane.showMessageDialog(null,"No hay l�neas disponibles","",JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null,"Falta informaci�n","",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void configurar(JFrame ventana, int id_origen, int id_destino) {
		this.ventana = ventana;
		this.id_origen = id_origen;
		this.id_destino = id_destino;
	}
}
