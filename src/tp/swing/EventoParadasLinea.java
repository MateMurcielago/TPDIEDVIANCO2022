package tp.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public class EventoParadasLinea implements ActionListener {
	private JTable tabla;
	
	public EventoParadasLinea() {
		super();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(tabla.getSelectedRow() != -1) {
			JOptionPane.showMessageDialog(null,tabla.getValueAt(tabla.getSelectedRow(), 3),
					"",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void configurar(JTable tabla) {
		this.tabla = tabla;
	}
}
