package tp.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

public class EventoDetallesCamino implements ActionListener {
	JTable tabla;
	
	public EventoDetallesCamino() {
		super();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(tabla.getSelectedRow() != -1) {
			ScreensManager.detallesCamino(
					Integer.valueOf(tabla.getValueAt(tabla.getSelectedRow(), 0).toString()));
		}
	}
	
	public void configurar(JTable tabla) {
		this.tabla = tabla;
	}
}
