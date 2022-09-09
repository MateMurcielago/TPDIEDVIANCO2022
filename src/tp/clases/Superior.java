package tp.clases;

import tp.app.App;

public class Superior extends Linea {
	private boolean wifi;
	private boolean aireAcondicionado;
	
	public Superior(int id, String nombre, String color, int maxPasajerosSentados, boolean wifi, boolean aire) {
		super(id, nombre, color, maxPasajerosSentados);
		this.setWifi(wifi);
		this.setAireAcondicionado(aire);
	}

	public boolean isWifi() {
		return wifi;
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}

	public boolean isAireAcondicionado() {
		return aireAcondicionado;
	}

	public void setAireAcondicionado(boolean aireAcondicionado) {
		this.aireAcondicionado = aireAcondicionado;
	}
	
	@Override
	public float getPrecioBoleto(int id_origen, int id_destino) {
		float precio = this.getDistanciaEntre(id_origen, id_destino) * App.montoBase();
		precio += (precio * 10)/100;
		if(this.wifi) precio += (precio * 5)/100;
		if(this.aireAcondicionado) precio += (precio * 5)/100;
		return precio;
	}
}
