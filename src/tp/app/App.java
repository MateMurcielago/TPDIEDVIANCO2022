package tp.app;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import tp.clases.*;
import tp.db.*;
import tp.swing.ScreensManager;

public class App {
	private static ArrayList<Linea> lineas = new ArrayList<Linea>();
	private static ArrayList<Parada> paradas = new ArrayList<Parada>();
	private static ArrayList<Camino> caminos = new ArrayList<Camino>();
	public static void main(String[] args) {
		ScreensManager.PantallaPrincipal();
	}
	
	public static boolean hayLineas() {
		if(lineas.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean hayParadas() {
		if(paradas.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean hayCaminos() {
		if(caminos.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
	
	public static void addLinea(String nombre, String color, int sentados, 
			int parados, boolean wifi, boolean aire, int tipo) {
		if(tipo == 1) {
			addEconomica(nombre, color, sentados, parados);
		} else {
			addSuperior(nombre, color, sentados, wifi, aire);
		}
	}
	
	private static void addEconomica(String nombre, String color, int sentados,
			int parados) {
		int id = 0;
		if(parados == -1) {
			lineas.add(new Economica(id + 1, nombre, color, sentados));
		} else {
			lineas.add(new Economica(id + 1, nombre, color, sentados, parados));
		}
	}
	
	private static void addSuperior(String nombre, String color, int sentados,
			boolean wifi, boolean aire) {
		int id = 0;
		lineas.add(new Superior(id + 1, nombre, color, sentados, wifi, aire));
	}
	
	public static void addParada(int nroParada, String calle, int nroCalle) {
		int id = 0;
		if(!paradas.isEmpty()) {
			for(int i = 0; i < paradas.size(); i++) {
				if(paradas.get(i).getId() > id) id = paradas.get(i).getId();
			}
		}
		paradas.add(new Parada(id + 1, nroParada, calle, nroCalle));
	}
	
	public static void addCamino(int id_origen, int id_destino, float distancia) {
		int id = 0;
		caminos.add(new Camino(id + 1, 
				paradas.stream().filter(p -> p.getId() == id_origen).findFirst().get(),
				paradas.stream().filter(p -> p.getId() == id_destino).findFirst().get(), distancia));
	}
	
	public static int getCantLineas() {
		return lineas.size();
	}
	
	public static String[] getFilaLineas(int i) {
		String[] fila = {"", "", "", "", "", "", "", ""};
		fila[0] = Integer.toString(lineas.get(i).getId());
		fila[2] = lineas.get(i).getNombre();
		fila[3] = lineas.get(i).getColor();
		fila[4] = Integer.toString(lineas.get(i).getMaxPasajerosSentados());
		if(lineas.get(i) instanceof Economica) {
			fila[1] = "Económica";
			fila[5] = Integer.toString(((Economica) lineas.get(i)).getMaxPasajerosParados());
			fila[6] = "-";
			fila[7] = "-";
		} else {
			fila[1] = "Superior";
			fila[5] = "0";
			if(((Superior) lineas.get(i)).isWifi()) {
				fila[6] = "SÍ";
			} else {
				fila[6] = "NO";
			}
			if(((Superior) lineas.get(i)).isAireAcondicionado()) {
				fila[7] = "SÍ";
			} else {
				fila[7] = "NO";
			}
		}
		return fila;
	}
	
	public static int getCantParadas() {
		return paradas.size();
	}
	
	public static String[] getFilaParadas(int i) {
		String[] fila = {"", "", "", ""};
		fila[0] = Integer.toString(paradas.get(i).getId());
		fila[1] = Integer.toString(paradas.get(i).getNroParada());
		fila[2] = paradas.get(i).getCalle();
		fila[3] = Integer.toString(paradas.get(i).getNroCalle());
		return fila;
	}
	
	public static int getCantCaminos() {
		return caminos.size();
	}
	
	public static String[] getFilaCaminos(int i) {
		String[] fila = {"", "", "", ""};
		fila[0] = Integer.toString(caminos.get(i).getId());
		fila[1] = caminos.get(i).getOrigen().getCalle()+" "+caminos.get(i).getOrigen().getNroCalle();
		fila[2] = caminos.get(i).getDestino().getCalle()+" "+caminos.get(i).getDestino().getNroCalle();
		fila[3] = Float.toString(caminos.get(i).getDistancia());
		return fila;
	}
	
	public static String direccionDe(int id) {
		String dir = paradas.stream().filter(p -> p.getId() == id).findFirst().get().getCalle();
		int num = paradas.stream().filter(p -> p.getId() == id).findFirst().get().getNroCalle();
		return dir+" "+num;
	}
	
	public static boolean isParada(int id) {
		if(paradas.isEmpty()) {
			return false;
		} else if(paradas.stream().filter(p -> p.getId() == id).findFirst().isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
}
