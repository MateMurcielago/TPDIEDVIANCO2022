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
	
	public boolean tieneLaParada(int id) {
		if(this.getParadas().stream().filter(p -> p.getId() == id).findFirst().isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean existeCaminoEntreParadas(int id_origen, int id_destino) {
		int guia = 0;
		for(int i = 0; i < this.caminos.size(); i++) {
			if(guia == 0) {
				if(this.caminos.get(i).getOrigen().getId() == id_origen) {
					guia++;
					if(this.caminos.get(i).getOrigen().getId() == id_destino) return true;
				}
			} else {
				if(this.caminos.get(i).getOrigen().getId() == id_destino) return true;
			}
		}
		return false;
	}
	
	public float getDuracionTrayecto(int id_origen, int id_destino) {
		return this.recorrido.stream().
				filter(t -> t.getOrigen().getId() == id_origen && t.getDestino().getId() == id_destino).
				findFirst().get().getDuracion();
	}
	
	public float getDistanciaEntre(int id_origen, int id_destino) {
		float distancia = 0;
		int guia = 0;
		for(int i = 0; i < this.caminos.size(); i++) {
			if(guia == 0) {
				if(this.caminos.get(i).getOrigen().getId() == id_origen) {
					guia++;
					distancia = this.caminos.get(i).getDistancia();
				}
			} else {
				if(this.caminos.get(i).getOrigen().getId() == id_destino) return distancia;
				else distancia += this.caminos.get(i).getDistancia();
			}
		}
		return 100000000000000.0f;
	}
	
	public float getPrecioBoleto(int id_origen, int id_destino) {
		return 0.0f;
	}
}
