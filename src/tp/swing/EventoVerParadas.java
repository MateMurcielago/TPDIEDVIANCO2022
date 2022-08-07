package tp.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tp.app.App;

public class EventoVerParadas implements ActionListener {
	public EventoVerParadas() {
		super();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(!App.hayParadas()) {
			ScreensManager.sinElementos();
		} else {
			ScreensManager.verParadas();
		}
	}
}
