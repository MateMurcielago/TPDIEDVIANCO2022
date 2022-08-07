package tp.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import tp.app.App;

public class EventoGuardarLinea implements ActionListener {
	private JTextField nombre;
	private JTextField color;
	private JTextField sentados;
	private JTextField parados;
	private JRadioButton wifi;
	private JRadioButton aire;
	private int tipo;
	private JFrame ventana;
	
	public EventoGuardarLinea(JTextField nombre, JTextField color, 
			JTextField sentados, JTextField parados, JRadioButton wifi, JRadioButton aire, 
			int tipo, JFrame ventana) {
		super();
		this.nombre = nombre;
		this.color = color;
		this.sentados = sentados;
		this.parados = parados;
		this.wifi = wifi;
		this.aire = aire;
		this.tipo = tipo;
		this.ventana = ventana;
	}
	
	public EventoGuardarLinea() {
		super();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int par;
		int sent;
		if(this.nombre.getText().isBlank() || this.color.getText().isBlank()
				|| this.sentados.getText().isBlank()) {
			JOptionPane.showMessageDialog(null,"Falta información","",
					JOptionPane.ERROR_MESSAGE);
		} else {
			sent = Integer.valueOf(this.sentados.getText());
			if(tipo == 1) {
				if(this.parados.getText().isBlank()) {
					par = -1;
				} else {
					par = Integer.valueOf(this.parados.getText());
				}
				if(par <= (sent * 40) / 100) {
					App.addLinea(this.nombre.getText(), this.color.getText(), sent, par, false,
							false, this.tipo);
					this.ventana.dispose();
				} else {
					JOptionPane.showMessageDialog(null,"La cantidad de pasajeros parados"
							+" debe ser un 40% o menos de la cantidad de pasajeros"
							+" sentados","",JOptionPane.ERROR_MESSAGE);
				}
			} else {
				App.addLinea(this.nombre.getText(), this.color.getText(), sent, -1, 
						this.wifi.isSelected(), this.aire.isSelected(), this.tipo);
				this.ventana.dispose();
			}
		}
	}
	
	public void configurar(JTextField nombre, JTextField color, 
			JTextField sentados, JTextField parados, JRadioButton wifi, JRadioButton aire, 
			int tipo, JFrame ventana) {
		this.nombre = nombre;
		this.color = color;
		this.sentados = sentados;
		this.parados = parados;
		this.wifi = wifi;
		this.aire = aire;
		this.tipo = tipo;
		this.ventana = ventana;
	}
}
