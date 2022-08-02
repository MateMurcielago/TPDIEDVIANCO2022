package tp.clases;

import java.util.ArrayList;

public class Camino {
	private int id;
	private Parada origen;
	private Parada destino;
	private float distancia;
	private ArrayList<Incidencia> incidencias;
	
	public Camino() {
		super();
		this.distancia = 0;
	}
	
	public Camino(int id, Parada origen, Parada destino, float distancia) {
		super();
		this.setId(id);
		this.setOrigen(origen);
		this.setDestino(destino);
		this.setDistancia(distancia);
		this.incidencias = new ArrayList<Incidencia>();
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public Parada getOrigen() {
		return origen;
	}

	public void setOrigen(Parada origen) {
		this.origen = origen;
	}

	public Parada getDestino() {
		return destino;
	}

	public void setDestino(Parada destino) {
		this.destino = destino;
	}

	public float getDistancia() {
		return distancia;
	}

	public void setDistancia(float distancia) {
		this.distancia = distancia;
	}
	
	public ArrayList<Incidencia> getIncidencias() {
		return this.incidencias;
	}
	
	public void addIncidencia(Incidencia i) {
		this.incidencias.add(i);
	}
}
