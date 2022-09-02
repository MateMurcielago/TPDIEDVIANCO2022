package tp.clases;

public class Trayecto {
	private int id;
	private Parada origen;
	private Parada destino;
	private float duracion;
	
	public Trayecto(int id, Parada origen, Parada destino, float duracion) {
		super();
		this.setId(id);
		this.setOrigen(origen);
		this.setDestino(destino);
		this.setDuracion(duracion);
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

	public float getDuracion() {
		return duracion;
	}

	public void setDuracion(float duracion) {
		this.duracion = duracion;
	}
}
