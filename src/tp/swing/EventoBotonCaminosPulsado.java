package tp.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventoBotonCaminosPulsado implements ActionListener {
	public EventoBotonCaminosPulsado() {
		super();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ScreensManager.caminos();
	}
}
