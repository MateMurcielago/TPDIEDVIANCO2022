package tp.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tp.app.App;

public class EventoBotonPulsado implements ActionListener {
	public EventoBotonPulsado() {
		super();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		App.a();
	}

}
