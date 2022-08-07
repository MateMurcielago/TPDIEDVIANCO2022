package tp.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventoNuevaParada implements ActionListener {
	public EventoNuevaParada() {
		super();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ScreensManager.nuevaParada();
	}
}
