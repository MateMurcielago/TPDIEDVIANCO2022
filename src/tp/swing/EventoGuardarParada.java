package tp.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import tp.app.App;

public class EventoGuardarParada implements ActionListener {
	private JTextField num;
	private JTextField calle;
	private JTextField num_dir;
	private JFrame ventana;
	
	public EventoGuardarParada() {
		super();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.num.getText().isBlank() || this.calle.getText().isBlank() 
				|| this.num_dir.getText().isBlank()) {
			JOptionPane.showMessageDialog(null,"Falta información","",
					JOptionPane.ERROR_MESSAGE);
		} else {
			App.addParada(Integer.valueOf(this.num.getText()), this.calle.getText(), 
					Integer.valueOf(this.num_dir.getText()));
			this.ventana.dispose();
		}
	}
	
	public void configurar(JTextField num, JTextField calle, JTextField num_dir, JFrame ventana) {
		this.num = num;
		this.calle = calle;
		this.num_dir = num_dir;
		this.ventana = ventana;
	}
}
