package tp.swing;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ScreensManager {
	
	public static void ProbarPantallas() {
		JFrame ventana = new JFrame("La que se coje a tu hermana");
		JTextField texto = new JTextField(20);
		Container c = ventana.getContentPane();
		c.setLayout(new FlowLayout());
		JButton boton = new JButton("Hola");
		c.add(texto);
		c.add(boton);
		ventana.pack();
		ventana.setSize(400, 100);
		ventana.setVisible(true);
		Object[] opciones = {"Si", "No", "Oleme el dedo"};
		//int n1 = JOptionPane.showOptionDialog(ventana, "ACM1PT", "ALERTA", 
		//		JOptionPane.ERROR_MESSAGE, JOptionPane.YES_NO_CANCEL_OPTION, null, 
		//		opciones, opciones[2]);
		//System.out.println(n1);
	}
}
