package tp.clases;

import java.time.LocalDate;

public class Incidencia {
	private LocalDate inicio;
	private LocalDate fin;
	private String descripcion;
	
	public Incidencia(LocalDate inicio, String descripcion) {
		super();
		this.setInicio(inicio);
		this.setDescripcion(descripcion);
	}
	
	public Incidencia(LocalDate inicio, LocalDate fin, String descripcion) {
		this(inicio, descripcion);
		this.setFin(fin);
	}

	public LocalDate getInicio() {
		return inicio;
	}

	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}

	public LocalDate getFin() {
		return fin;
	}

	public void setFin(LocalDate fin) {
		this.fin = fin;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
