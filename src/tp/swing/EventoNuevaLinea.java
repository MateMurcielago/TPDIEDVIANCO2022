package tp.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class EventoNuevaLinea implements ActionListener {
	public EventoNuevaLinea() {
		super();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String[] opciones = {"Económica", "Superior", "Cancelar"};
		int tipo = JOptionPane.showOptionDialog(null, "¿Qué tipo de línea?", "", 
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
				opciones, opciones[2]);
		if(tipo == 0) {
			ScreensManager.nuevaLinea(1);
		} else if(tipo == 1) {
			ScreensManager.nuevaLinea(2);
		}
	}
}
