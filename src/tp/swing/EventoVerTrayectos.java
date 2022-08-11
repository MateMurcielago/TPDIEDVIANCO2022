package tp.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tp.app.App;

public class EventoVerTrayectos implements ActionListener {
	private int id;
	
	public EventoVerTrayectos() {
		super();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(!App.tieneTrayectos(id)) {
			ScreensManager.sinElementos();
		} else {
			ScreensManager.verTrayectos(id);
		}
	}
	
	public void configurar(int id) {
		this.id = id;
	}
}
