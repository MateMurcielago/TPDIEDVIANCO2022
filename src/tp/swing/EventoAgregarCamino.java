package tp.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventoAgregarCamino implements ActionListener {
	private int id;
	
	public EventoAgregarCamino() {
		super();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ScreensManager.agregarCamino(id);
	}
	
	public void configurar(int id) {
		this.id = id;
	}
}
