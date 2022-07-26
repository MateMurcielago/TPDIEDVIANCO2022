package tp.clases;

import java.util.ArrayList;

public abstract class Linea {
	private String nombre;
	private String color;
	private int maxPasajerosSentados;
	private ArrayList<Parada> paradas;
	
	public Linea(String nombre, String color, int maxPasajerosSentados) {
		super();
		this.setNombre(nombre);
		this.setColor(color);
		this.setMaxPasajerosSentados(maxPasajerosSentados);
		this.paradas = new ArrayList<Parada>();
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
	
}
