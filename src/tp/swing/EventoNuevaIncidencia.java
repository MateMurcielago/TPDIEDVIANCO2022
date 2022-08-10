package tp.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventoNuevaIncidencia implements ActionListener {
	private int id;
	
	public EventoNuevaIncidencia() {
		super();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ScreensManager.nuevaIncidencia(id);
	}
	
	public void configurar(int id) {
		this.id = id;
	}
}
