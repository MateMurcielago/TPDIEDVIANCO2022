package tp.clases;

public class Superior extends Linea {
	private boolean wifi;
	private boolean aireAcondicionado;
	
	public Superior(String nombre, String color, int maxPasajerosSentados, boolean wifi, boolean aire) {
		super(nombre, color, maxPasajerosSentados);
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
}
