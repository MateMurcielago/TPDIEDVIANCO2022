package tp.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tp.app.App;

public class EventoVerLineas implements ActionListener {
	public EventoVerLineas() {
		super();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(!App.hayLineas()) {
			ScreensManager.sinElementos();
		}
	}
}
