package tp.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tp.app.App;

public class EventoVerCaminos implements ActionListener {
	public EventoVerCaminos() {
		super();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(!App.hayCaminos()) {
			ScreensManager.sinElementos();
		} else {
			ScreensManager.verCaminos();
		}
	}
}
