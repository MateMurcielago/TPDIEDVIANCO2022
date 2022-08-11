package tp.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tp.app.App;

public class EventoVerParadasDe implements ActionListener {
	private int id;
	
	public EventoVerParadasDe() {
		super();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(App.tieneParadas(id)) {
			ScreensManager.verParadasDe(id);
		} else {
			ScreensManager.sinElementos();
		}
	}
	
	public void configurar(int id) {
		this.id = id;
	}
}
