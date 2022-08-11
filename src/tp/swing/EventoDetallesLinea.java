package tp.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

public class EventoDetallesLinea implements ActionListener {
	JTable tabla;
	
	public EventoDetallesLinea() {
		super();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(tabla.getSelectedRow() != -1) {
			ScreensManager.detallesLinea(
					Integer.valueOf(tabla.getValueAt(tabla.getSelectedRow(), 0).toString()));
		}
	}
	
	public void configurar(JTable tabla) {
		this.tabla = tabla;
	}
}
