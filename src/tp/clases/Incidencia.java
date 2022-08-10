package tp.clases;

import java.time.LocalDate;

public class Incidencia {
	private int id;
	private LocalDate inicio;
	private LocalDate fin;
	private String descripcion;
	
	public Incidencia(int id, LocalDate inicio, String descripcion) {
		super();
		this.setId(id);
		this.setInicio(inicio);
		this.setDescripcion(descripcion);
		this.setFin(LocalDate.of(5000, 1, 1));
	}
	
	public Incidencia(int id, LocalDate inicio, LocalDate fin, String descripcion) {
		this(id, inicio, descripcion);
		this.setFin(fin);
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
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
