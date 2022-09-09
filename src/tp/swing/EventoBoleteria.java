package tp.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventoBoleteria implements ActionListener {
	public EventoBoleteria() {
		super();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ScreensManager.boleteria();
	}
}
