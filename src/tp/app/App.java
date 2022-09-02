package tp.app;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

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
	private static ArrayList<Incidencia> incidencias = new ArrayList<Incidencia>();
	private static ArrayList<Trayecto> trayectos = new ArrayList<Trayecto>();
	
	private static ArrayList<Integer> visitados = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		DBManager.cargarLineas();
		DBManager.cargarParadas();
		DBManager.cargarCaminos();
		DBManager.cargarIncidencias();
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
	
	public static boolean tieneIncidencias(int id) {
		if(caminos.stream().filter(c -> c.getId() == id).findFirst().get().getIncidencias().isEmpty()) {
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
		if(!lineas.isEmpty()) {
			for(int i = 0; i < lineas.size(); i++) {
				if(lineas.get(i).getId() > id) id = lineas.get(i).getId();
			}
		}
		if(parados == -1) {
			lineas.add(new Economica(id + 1, nombre, color, sentados));
			DBManager.addEconomica(new Economica(id + 1, nombre, color, sentados));
		} else {
			lineas.add(new Economica(id + 1, nombre, color, sentados, parados));
			DBManager.addEconomica(new Economica(id + 1, nombre, color, sentados, parados));
		}
	}
	
	private static void addSuperior(String nombre, String color, int sentados,
			boolean wifi, boolean aire) {
		int id = 0;
		if(!lineas.isEmpty()) {
			for(int i = 0; i < lineas.size(); i++) {
				if(lineas.get(i).getId() > id) id = lineas.get(i).getId();
			}
		}
		lineas.add(new Superior(id + 1, nombre, color, sentados, wifi, aire));
		DBManager.addSuperior(new Superior(id + 1, nombre, color, sentados, wifi, aire));
	}
	
	public static void addParada(int nroParada, String calle, int nroCalle) {
		int id = 0;
		if(!paradas.isEmpty()) {
			for(int i = 0; i < paradas.size(); i++) {
				if(paradas.get(i).getId() > id) id = paradas.get(i).getId();
			}
		}
		paradas.add(new Parada(id + 1, nroParada, calle, nroCalle));
		DBManager.addParada(new Parada(id + 1, nroParada, calle, nroCalle));
	}
	
	public static void addCamino(int id_origen, int id_destino, float distancia) {
		int id = 0;
		if(!caminos.isEmpty()) {
			for(int i = 0; i < caminos.size(); i++) {
				if(caminos.get(i).getId() > id) id = caminos.get(i).getId();
			}
		}
		caminos.add(new Camino(id + 1, 
				paradas.stream().filter(p -> p.getId() == id_origen).findFirst().get(),
				paradas.stream().filter(p -> p.getId() == id_destino).findFirst().get(), distancia));
		DBManager.addCamino(new Camino(id + 1, 
				paradas.stream().filter(p -> p.getId() == id_origen).findFirst().get(),
				paradas.stream().filter(p -> p.getId() == id_destino).findFirst().get(), distancia));
	}
	
	public static void addIncidencia(int id, String descripcion, LocalDate inicio, LocalDate fin) {
		int id_inc = 0;
		if(!incidencias.isEmpty()) {
			for(int i = 0; i < incidencias.size(); i++) {
				if(incidencias.get(i).getId() > id_inc) id_inc = incidencias.get(i).getId();
			}
		}
		caminos.stream().filter(c -> c.getId() == id).findFirst().get()
			.addIncidencia(new Incidencia(id_inc + 1, inicio, fin, descripcion));
		incidencias.add(new Incidencia(id_inc + 1, inicio, fin, descripcion));
	}
	
	public static void addIncidencia(int id, String descripcion, LocalDate inicio) {
		int id_inc = 0;
		if(!incidencias.isEmpty()) {
			for(int i = 0; i < incidencias.size(); i++) {
				if(incidencias.get(i).getId() > id_inc) id_inc = incidencias.get(i).getId();
			}
		}
		caminos.stream().filter(c -> c.getId() == id).findFirst().get()
			.addIncidencia(new Incidencia(id_inc + 1, inicio, descripcion));
		incidencias.add(new Incidencia(id_inc + 1, inicio, descripcion));
		DBManager.addIncidencia(new Incidencia(id_inc + 1, inicio, descripcion), 
				caminos.stream().filter(c -> c.getId() == id).findFirst().get());
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
	
	public static int getCantIncidenciasDe(int id) {
		return caminos.stream().filter(c -> c.getId() == id).findFirst().get().getIncidencias().size();
	}
	
	public static String[] getFilaIncidenciasDe(int id, int i) {
		String[] fila = {"", "", "", ""};
		Incidencia aux = caminos.stream().filter(c -> c.getId() == id).findFirst().get().getIncidencias()
				.get(i);
		fila[0] = Integer.toString(aux.getId());
		fila[1] = aux.getInicio().getDayOfMonth() + "/" + aux.getInicio().getMonthValue() + "/"
				+ aux.getInicio().getYear();
		if(aux.getFin().getYear() == 5000) {
			fila[2] = "-";
		} else {
			fila[2] = aux.getFin().getDayOfMonth() + "/" + aux.getFin().getMonthValue() + "/"
					+ aux.getFin().getYear();
		}
		fila[3] = aux.getDescripcion();
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
	
	public static String getOrigenDe(int id) {
		return caminos.stream().filter(c -> c.getId() == id).findFirst().get().getOrigen().getCalle() 
				+ " " +
				caminos.stream().filter(c -> c.getId() == id).findFirst().get().getOrigen().getNroCalle();
	}
	
	public static String getDestinoDe(int id) {
		return caminos.stream().filter(c -> c.getId() == id).findFirst().get().getDestino().getCalle() 
				+ " " +
				caminos.stream().filter(c -> c.getId() == id).findFirst().get().getDestino().getNroCalle();
	}
	
	public static boolean isFinalizada(int id) {
		if(incidencias.stream().filter(i -> i.getId() == id).findFirst().get().getFin().getYear() 
				== 5000) {
			return false;
		} else {
			return true;
		}
	}
	
	public static void finalizar(int id, LocalDate fecha, int id_camino) {
		
	}
	
	public static void cargarEconomica(int id, String nombre, String color, int sentados, int parados) {
		lineas.add(new Economica(id, nombre, color, sentados, parados));
	}
	
	public static void cargarSuperior(int id, String nombre, String color, int sentados, boolean wifi, boolean aire) {
		lineas.add(new Superior(id, nombre, color, sentados, wifi, aire));
	}
	
	public static void cargarParada(int id, int nroParada, String calle, int nroCalle) {
		paradas.add(new Parada(id, nroParada, calle, nroCalle));
	}
	
	public static void cargarCamino(int id, int origen, int destino, float distancia) {
		caminos.add(new Camino(id, paradas.stream().filter(p -> p.getId() == origen).findFirst().get(),
				paradas.stream().filter(p -> p.getId() == destino).findFirst().get(), distancia));
	}
	
	public static void cargarIncidencia(int id, String descripcion, LocalDate inicio, LocalDate fin, int id_camino) {
		caminos.stream().filter(c -> c.getId() == id_camino).findFirst().get().addIncidencia(
				new Incidencia(id, inicio, fin, descripcion));
		incidencias.add(new Incidencia(id, inicio, fin, descripcion));
	}
	
	public static String getNombreLinea(int id) {
		return lineas.stream().filter(l -> l.getId() == id).findFirst().get().getNombre();
	}
	
	public static boolean tieneParadas(int id) {
		if(lineas.stream().filter(l -> l.getId() == id).findFirst().get().getParadas().isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean caminoDirecto(Linea l, int id) {
		return true;
	}
	
	public static void asignarParada(int id_linea, int id_parada) {
		lineas.stream().filter(l -> l.getId() == id_linea ).findFirst().get().addParada(
				paradas.stream().filter(p -> p.getId() == id_parada).findFirst().get());
	}
	
	public static int getCantParadasDe(int id) {
		return lineas.stream().filter(l -> l.getId() == id).findFirst().get().getParadas().size();
	}
	
	public static String[] getFilaParadasDe(int id, int i) {
		String[] fila = {"", "", "", ""};
		fila[0] = Integer.toString(lineas.stream().filter(l -> l.getId() == id).findFirst().get()
				.getParadas().get(i).getId());
		fila[1] = Integer.toString(lineas.stream().filter(l -> l.getId() == id).findFirst().get()
				.getParadas().get(i).getNroParada());
		fila[2] = lineas.stream().filter(l -> l.getId() == id).findFirst().get()
				.getParadas().get(i).getCalle();
		fila[3] = Integer.toString(lineas.stream().filter(l -> l.getId() == id).findFirst().get()
				.getParadas().get(i).getNroCalle());
		return fila;
	}
	
	public static int getCantCaminosDe(int id) {
		return lineas.stream().filter(l -> l.getId() == id).findFirst().get().getCaminos().size();
	}
	
	public static String[] getFilaCaminosDe(int id, int i) {
		String[] fila = {"", "", "", ""};
		fila[0] = Integer.toString(lineas.stream().filter(l -> l.getId() == id).findFirst().get()
				.getCaminos().get(i).getId());
		fila[1] = Integer.toString(lineas.stream().filter(l -> l.getId() == id).findFirst().get()
				.getCaminos().get(i).getOrigen().getId());
		fila[2] = Integer.toString(lineas.stream().filter(l -> l.getId() == id).findFirst().get()
				.getCaminos().get(i).getDestino().getId());
		fila[3] = Float.toString(lineas.stream().filter(l -> l.getId() == id).findFirst().get()
				.getCaminos().get(i).getDistancia());
		return fila;
	}
	
	public static boolean tieneCaminos(int id) {
		if(lineas.stream().filter(l -> l.getId() == id).findFirst().get().getCaminos().isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean caminoDirecto(int id_origen, int id_destino) {
		if(caminos.stream()
				.filter(c -> c.getOrigen().getId() == id_origen & c.getDestino().getId() == id_destino)
				.findFirst().isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
	
	public static int getIDUltimaParada(int id) {
		return lineas.stream().filter(l -> l.getId() == id).findFirst().get().getParadas().get(
				lineas.stream().filter(l -> l.getId() == id).findFirst().get().getParadas().size() - 1)
				.getId();
	}
	
	public static void AsignarParada(int id_linea, int id_parada, float duracion) {
		int id = 0;
		for(int i = 0; i < trayectos.size(); i++) 
			if(trayectos.get(i).getId() > id) id = trayectos.get(i).getId();
		lineas.stream().filter(l -> l.getId() == id_linea ).findFirst().get().addParada(
				paradas.stream().filter(p -> p.getId() == id_parada).findFirst().get());
		Trayecto aux = new Trayecto(id + 1, 
				paradas.stream().filter(p -> p.getId() == App.getIDUltimaParada(id_linea)).findFirst().get(),
				paradas.stream().filter(p -> p.getId() == id_parada).findFirst().get(), duracion);
		trayectos.add(aux);
		lineas.stream().filter(l -> l.getId() == id_linea).findFirst().get().addTrayecto(aux);
	}
	
	public static int getCantTrayectosDe(int id) {
		return lineas.stream().filter(l -> l.getId() == id).findFirst().get().getRecorrido().size();
	}
	
	public static String[] getFilaTrayectos(int id, int i) {
		String[] fila = {"", "", "", ""};
		fila[0] = Integer.toString(lineas.stream().filter(l -> l.getId() == id).findFirst().get()
				.getRecorrido().get(i).getId());
		fila[1] = App.direccionDe(lineas.stream().filter(l -> l.getId() == id).findFirst().get()
				.getRecorrido().get(i).getOrigen().getId());
		fila[2] = App.direccionDe(lineas.stream().filter(l -> l.getId() == id).findFirst().get()
				.getRecorrido().get(i).getDestino().getId());
		fila[3] = Float.toString(lineas.stream().filter(l -> l.getId() == id).findFirst().get()
				.getRecorrido().get(i).getDuracion());
		return fila;
	}
	
	public static boolean tieneTrayectos(int id) {
		if(lineas.stream().filter(l -> l.getId() == id).findFirst().get().getRecorrido().isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean existeCamino(int id_origen, int id_destino, boolean primero) {
		ArrayList<Camino> aux = (ArrayList<Camino>) caminos.stream().
				filter(p -> p.getOrigen().getId() == id_origen).collect(Collectors.toList());
		if(primero) visitados.clear();
		visitados.add(id_origen);
		boolean result = false;
		for(int i = 0; i < aux.size(); i++) {
			if(aux.isEmpty()) return false;
			else if(aux.get(i).getDestino().getId() == id_destino) return true;
			else if(!visitados.contains(aux.get(i).getDestino().getId())) 
				result = existeCamino(aux.get(i).getDestino().getId(), id_destino, false);
			if(result == true) return true;
		}
		return result;
	}
	
	public static String getDireccionOrigenDe(int id) {
		return 
			direccionDe(caminos.stream().filter(c -> c.getId() == id).findFirst().get().getOrigen().getId());
	}
	
	public static String getDireccionDestinoDe(int id) {
		return
			direccionDe(caminos.stream().filter(c -> c.getId() == id).findFirst().get().getDestino().getId());
	}
}
