package tp.app;

import java.time.LocalDate;
import java.util.ArrayList;

import tp.clases.*;
import tp.db.*;

public class App {

	public static void main(String[] args) {
		//ArrayList<Parada> paradas = new ArrayList<Parada>();
		//ArrayList<Camino> caminos = new ArrayList<Camino>();
		//DBManager.addEconomica(new Economica(1, "Esta", "Amarilla", 40));
		//Superior s = new Superior(1, "Esta", "Amarilla", 40, true, false);
		Parada p = new Parada(1, 1, "Urquiza", 207);
		/*s.addParada(p);*/
		DBManager.addParada(p);
		//DBManager.addSuperior(s);
		Parada p2 = new Parada(2, 2, "Colodredo", 2069);
		Camino c = new Camino(1, p, p2, 1000);
		DBManager.addParada(p2);
		DBManager.addCamino(c);
		//Trayecto t = new Trayecto(1, c, 200);
		//s.addTrayecto(t);
		//DBManager.addTrayecto(t, s);
		Incidencia i = new Incidencia(1, LocalDate.now(),"La que te deja su escencia");
		DBManager.addIncidencia(i, c);
	}

}
