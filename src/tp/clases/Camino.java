package tp.clases;

import java.util.ArrayList;

public class Camino {
	private Parada origen;
	private Parada destino;
	private int distancia;
	private ArrayList<Incidencia> incidencias;
	
	public Camino() {
		super();
		this.distancia = 0;
	}
	
	public Camino(Parada origen, Parada destino, int distancia) {
		super();
		this.setOrigen(origen);
		this.setDestino(destino);
		this.setDistancia(distancia);
		this.incidencias = new ArrayList<Incidencia>();
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

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	
	public ArrayList<Incidencia> getIncidencias() {
		return this.incidencias;
	}
	
	public void addIncidencia(Incidencia i) {
		this.incidencias.add(i);
	}
}
