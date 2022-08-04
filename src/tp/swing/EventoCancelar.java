package tp.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class EventoCancelar implements ActionListener {
	private JFrame ventana;
	
	public EventoCancelar(JFrame ventana) {
		this.ventana = ventana;
	}
	
	public EventoCancelar() {
		super();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.ventana.dispose();
	}
	
	public void configurar(JFrame ventana) {
		this.ventana = ventana;
	}
}
