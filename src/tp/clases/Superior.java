package tp.clases;

public class Superior extends Linea {
	private Servicio servicio; //Entiendo que no puede ofrecer los dos simultaneamente
	
	public Superior(String nombre, String color, int maxPasajerosSentados, Servicio servicio) {
		super(nombre, color, maxPasajerosSentados);
		this.setServicio(servicio);
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	
}
