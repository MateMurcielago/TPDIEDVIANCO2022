package tp.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tp.app.App;

public class EventoVerCaminosDe implements ActionListener {
private int id;
	
	public EventoVerCaminosDe() {
		super();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(!App.tieneCaminos(id)) {
			ScreensManager.sinElementos();
		} else {
			ScreensManager.verCaminosDe(id);
		}
	}
	
	public void configurar(int id) {
		this.id = id;
	}
}
