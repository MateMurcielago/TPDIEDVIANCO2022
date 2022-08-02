package tp.clases;

public class Trayecto {
	private int id;
	private Camino camino;
	private float duracion;
	
	public Trayecto(int id, Camino camino, float duracion) {
		super();
		this.setId(id);
		this.setCamino(camino);
		this.setDuracion(duracion);
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public Camino getCamino() {
		return camino;
	}

	public void setCamino(Camino camino) {
		this.camino = camino;
	}

	public float getDuracion() {
		return duracion;
	}

	public void setDuracion(float duracion) {
		this.duracion = duracion;
	}
}
