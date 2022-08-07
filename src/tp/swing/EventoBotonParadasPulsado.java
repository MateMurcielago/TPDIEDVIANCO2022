package tp.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventoBotonParadasPulsado implements ActionListener {
	public EventoBotonParadasPulsado() {
		super();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ScreensManager.paradas();
	}
}
