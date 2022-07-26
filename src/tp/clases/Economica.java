package tp.clases;

public class Economica extends Linea {
	private int maxPasajerosParados;
	
	public Economica(String nombre, String color, int maxPasajerosSentados) {
		super(nombre, color, maxPasajerosSentados);
		this.maxPasajerosParados = ((maxPasajerosSentados * 40)/100);
	}
	
	public Economica(String nombre, String color, int maxPasajerosSentados, 
			int maxPasajerosParados) {
		super(nombre, color, maxPasajerosSentados);
		this.setMaxPasajerosSentados(maxPasajerosSentados);
	}

	public int getMaxPasajerosParados() {
		return maxPasajerosParados;
	}

	public void setMaxPasajerosParados(int maxPasajerosParados) {
		this.maxPasajerosParados = maxPasajerosParados;
	}
}
