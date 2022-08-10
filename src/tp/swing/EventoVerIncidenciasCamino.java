package tp.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tp.app.App;

public class EventoVerIncidenciasCamino implements ActionListener {
	private int id;
	
	public EventoVerIncidenciasCamino() {
		super();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(App.tieneIncidencias(id)) {
			ScreensManager.verIncidencias(id);
		} else {
			ScreensManager.sinElementos();
		}
	}
	
	public void configurar(int id) {
		this.id = id;
	}
}
