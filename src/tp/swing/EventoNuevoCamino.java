package tp.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventoNuevoCamino implements ActionListener {
	public EventoNuevoCamino() {
		super();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ScreensManager.nuevoCamino();
	}
}
