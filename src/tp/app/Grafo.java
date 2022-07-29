package tp.app;

import java.util.ArrayList;
import java.util.List;
import tp.clases.*;

public class Grafo {
	protected List<Camino> caminos;
	protected List<Parada> paradas;
	
	public Grafo() {
		this.caminos = new ArrayList<Camino>();
		this.paradas = new ArrayList<Parada>();
	}
}
