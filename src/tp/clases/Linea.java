package tp.clases;

import java.util.ArrayList;

public abstract class Linea {
	private String nombre;
	private String color;
	private int maxPasajerosSentados;
	private ArrayList<Parada> paradas;
	private ArrayList<Trayecto> recorrido;
	
	public Linea(String nombre, String color, int maxPasajerosSentados) {
		super();
		this.setNombre(nombre);
		this.setColor(color);
		this.setMaxPasajerosSentados(maxPasajerosSentados);
		this.paradas = new ArrayList<Parada>();
		this.recorrido = new ArrayList<Trayecto>();
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
	
	public void addTrayecto(Camino c, int duracion) {
		this.recorrido.add(new Trayecto(c, duracion));
	}
}
