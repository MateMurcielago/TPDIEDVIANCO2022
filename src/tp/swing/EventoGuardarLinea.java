package tp.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class EventoGuardarLinea implements ActionListener {
	private JTextField num;
	private JTextField nombre;
	private JTextField color;
	private JTextField sentados;
	private JTextField parados;
	private JRadioButton wifi;
	private JRadioButton aire;
	private int tipo;
	private JFrame ventana;
	
	public EventoGuardarLinea(JTextField num, JTextField nombre, JTextField color, 
			JTextField sentados, JTextField parados, JRadioButton wifi, JRadioButton aire, 
			int tipo, JFrame ventana) {
		super();
		this.num = num;
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
		if(tipo == 1) {
			System.out.println("Línea '"+nombre.getText()+"' de color "+color.getText()
			+" que permite "+sentados.getText()+" pasajeros sentados y "+parados.getText()
			+" parados");
		}
	}
	
	public void configurar(JTextField num, JTextField nombre, JTextField color, 
			JTextField sentados, JTextField parados, JRadioButton wifi, JRadioButton aire, 
			int tipo, JFrame ventana) {
		this.num = num;
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
