package tp.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import tp.app.App;

public class EventoGuardarIncidencia implements ActionListener {
	private int id;
	private JFrame ventana;
	private JTextField descripcion;
	private JTextField dia_inicio;
	private JTextField mes_inicio;
	private JTextField anio_inicio;
	private JTextField dia_fin;
	private JTextField mes_fin;
	private JTextField anio_fin;
	
	public EventoGuardarIncidencia() {
		super();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.descripcion.getText().isBlank() || this.dia_inicio.getText().isBlank() ||
				this.mes_inicio.getText().isBlank() || this.anio_inicio.getText().isBlank()) {
			JOptionPane.showMessageDialog(null,"Falta información","",JOptionPane.ERROR_MESSAGE);
		} else {
			if(this.dia_fin.getText().isBlank() || this.mes_fin.getText().isBlank() ||
					this.anio_fin.getText().isBlank()) {
				LocalDate inicio = LocalDate.of(Integer.valueOf(this.anio_inicio.getText().toString()), 
						Integer.valueOf(this.mes_inicio.getText().toString()),
						Integer.valueOf(this.dia_inicio.getText().toString()));
				App.addIncidencia(id, descripcion.getText().toString(), inicio);
			} else {
				LocalDate inicio = LocalDate.of(Integer.valueOf(this.anio_inicio.getText().toString()), 
						Integer.valueOf(this.mes_inicio.getText().toString()),
						Integer.valueOf(this.dia_inicio.getText().toString()));
				LocalDate fin = LocalDate.of(Integer.valueOf(this.anio_fin.getText().toString()), 
						Integer.valueOf(this.mes_fin.getText().toString()),
						Integer.valueOf(this.dia_fin.getText().toString()));
				App.addIncidencia(id, descripcion.getText().toString(), inicio, fin);
			}
			ventana.dispose();
		}
	}
	
	public void configurar(int id, JFrame ventana, JTextField descripcion, JTextField dia_inicio,
			JTextField mes_inicio, JTextField anio_inicio, JTextField dia_fin, JTextField mes_fin,
			JTextField anio_fin) {
		this.id = id;
		this.ventana = ventana;
		this.descripcion = descripcion;
		this.dia_inicio = dia_inicio;
		this.mes_inicio = mes_inicio;
		this.anio_inicio = anio_inicio;
		this.dia_fin = dia_fin;
		this.mes_fin = mes_fin;
		this.anio_fin = anio_fin;
	}
}
