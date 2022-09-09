package tp.clases;

import tp.app.App;

public class Economica extends Linea {
	private int maxPasajerosParados;
	
	public Economica(int id, String nombre, String color, int maxPasajerosSentados) {
		super(id, nombre, color, maxPasajerosSentados);
		this.maxPasajerosParados = ((maxPasajerosSentados * 40)/100);
	}
	
	public Economica(int id, String nombre, String color, int maxPasajerosSentados, 
			int maxPasajerosParados) {
		super(id, nombre, color, maxPasajerosSentados);
		this.setMaxPasajerosParados(maxPasajerosParados);
	}

	public int getMaxPasajerosParados() {
		return maxPasajerosParados;
	}

	public void setMaxPasajerosParados(int maxPasajerosParados) {
		this.maxPasajerosParados = maxPasajerosParados;
	}
	
	@Override
	public float getPrecioBoleto(int id_origen, int id_destino) {
		float precio = this.getDistanciaEntre(id_origen, id_destino) * App.montoBase();
		precio += (precio * 2)/100;
		return precio;
	}
}
