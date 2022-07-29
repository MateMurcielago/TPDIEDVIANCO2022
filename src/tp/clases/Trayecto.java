package tp.clases;

public class Trayecto {
	private Camino camino;
	private int duracion;
	
	public Trayecto(Camino camino, int duracion) {
		super();
		this.setCamino(camino);
		this.setDuracion(duracion);
	}

	public Camino getCamino() {
		return camino;
	}

	public void setCamino(Camino camino) {
		this.camino = camino;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
}
