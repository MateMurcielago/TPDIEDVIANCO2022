package tp.clases;

import java.util.ArrayList;

public abstract class Linea {
	private int id;
	private String nombre;
	private String color;
	private int maxPasajerosSentados;
	private ArrayList<Parada> paradas;
	private ArrayList<Camino> caminos;
	private ArrayList<Trayecto> recorrido;
	
	public Linea(int id, String nombre, String color, int maxPasajerosSentados) {
		super();
		this.setId(id);
		this.setNombre(nombre);
		this.setColor(color);
		this.setMaxPasajerosSentados(maxPasajerosSentados);
		this.paradas = new ArrayList<Parada>();
		this.caminos = new ArrayList<Camino>();
		this.recorrido = new ArrayList<Trayecto>();
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMaxPasajerosSentados() {
		return maxPasajerosSentados;
	}

	public void setMaxPasajerosSentados(int maxPasajerosSentados) {
		this.maxPasajerosSentados = maxPasajerosSentados;
	}

	public ArrayList<Parada> getParadas() {
		return paradas;
	}

	public void addParada(Parada p) {
		this.paradas.add(p);
	}
	
	public ArrayList<Trayecto> getRecorrido() {
		return this.recorrido;
	}
	
	public void addTrayecto(Trayecto t) {
		this.recorrido.add(t);
	}
	
	public void addTrayecto(int id, Parada origen, Parada destino, int duracion) {
		this.recorrido.add(new Trayecto(id, origen, destino, duracion));
	}
	
	public ArrayList<Camino> getCaminos() {
		return this.caminos;
	}
	
	public void addCamino(Camino c) {
		this.caminos.add(c);
	}
}
