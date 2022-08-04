package tp.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class EventoCancelar implements ActionListener {
	private JFrame ventana;
	
	public EventoCancelar(JFrame ventana) {
		this.ventana = ventana;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.ventana.dispose();
	}
}
