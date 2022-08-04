package tp.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventoBotonLineasPulsado implements ActionListener {
	public EventoBotonLineasPulsado() {
		super();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		ScreensManager.Lineas();
	}
}
