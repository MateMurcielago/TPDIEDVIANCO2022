package tp.clases;

public class Parada {
	private int id;
	private int nroParada;
	private String calle;
	private int nroCalle;
	
	public Parada(int id, int nroParada, String calle, int nroCalle) {
		super();
		this.setId(id);
		this.setNroParada(nroParada);
		this.setCalle(calle);
		this.setNroCalle(nroCalle);
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getNroParada() {
		return nroParada;
	}

	public void setNroParada(int nroParada) {
		this.nroParada = nroParada;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNroCalle() {
		return nroCalle;
	}

	public void setNroCalle(int nroCalle) {
		this.nroCalle = nroCalle;
	}
}
