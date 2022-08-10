package tp.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import tp.app.App;

public class EventoFinalizarIncidencia implements ActionListener {
	private JFrame ventana;
	private int id;
	private JTable tabla;
	
	public EventoFinalizarIncidencia() {
		super();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(tabla.getSelectedRow() != -1) {
			if(App.isFinalizada(Integer.valueOf(this.tabla.getValueAt(this.tabla.getSelectedRow(), 0)
					.toString()))) {
				JOptionPane.showMessageDialog(null,"Esta incidencia ya está finalizada","",
						JOptionPane.ERROR_MESSAGE);
			} else {
				ScreensManager.finalizarIncidencia(Integer.valueOf(this.tabla.getValueAt(
						this.tabla.getSelectedRow(), 0).toString()));
				ventana.dispose();
				ScreensManager.verIncidencias(id);
			}
		}
	}
	
	public void configurar(JFrame ventana, JTable tabla, int id) {
		this.ventana = ventana;
		this.tabla = tabla;
		this.id = id;
	}
}
