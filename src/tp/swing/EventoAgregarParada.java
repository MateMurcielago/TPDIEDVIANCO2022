package tp.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import tp.app.App;

public class EventoAgregarParada implements ActionListener {
	private int id;
	
	public EventoAgregarParada() {
		super();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(App.tieneParadas(id)) {
			/*String[] opciones = {"Directo", "Con Escalas", "Cancelar"};
			int opcion = JOptionPane.showOptionDialog(null, "¿Qué tipo de línea?", "", 
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
					opciones, opciones[2]);
			if(opcion == 0) {
				//ScreensManager.paradaDirecta(id);
			} else if(opcion == 1) {
			
			}*/
			ScreensManager.agregarParada(id);
		} else {
			ScreensManager.primeraParada(id);
		}
	}
	
	public void configurar(int id) {
		this.id = id;
	}
}
