package tp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import tp.app.App;
import tp.clases.*;

public class DBManager {
	private static String url = "jdbc:mysql://root@127.0.0.1:3306/tpdied";
	private static String user = "root";
	private static String pass = "Ezequiel98";
	
	public static void addEconomica(Economica e) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			Statement st = conn.createStatement();
			st.executeUpdate("INSERT INTO LINEA (id,nombre,color,maxpasajerossentados,"
					+ "maxpasajerosparados) VALUES ("+e.getId()+",'"+e.getNombre()+"',"
					+"'"+e.getColor()+"',"+e.getMaxPasajerosSentados()+","
					+e.getMaxPasajerosParados()+")");
			st.close();
			conn.close();
		} catch(ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch(SQLException e2) {
			e2.printStackTrace();
		} finally {
			if(!e.getParadas().isEmpty()) {
				for(int i = 0; i < e.getParadas().size(); i++) {
					DBManager.addLineaParada(e, e.getParadas().get(i));
				}
			}
		}
	}
	
	public static void addSuperior(Superior s) {
		Connection conn = null;
		char w;
		char a;
		if(s.isWifi()) {
			w = 't';
		} else {
			w = 'f';
		}
		if(s.isAireAcondicionado()) {
			a = 't';
		} else {
			a = 'f';
		}
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			Statement st = conn.createStatement();
			st.executeUpdate("INSERT INTO LINEA (id,nombre,color,maxpasajerossentados,"
					+"wifi,aireacondicionado) VALUES ("+s.getId()+",'"+s.getNombre()+"','"
					+s.getColor()+"',"+s.getMaxPasajerosSentados()+",'"+w+"','"+a+"')");
			st.close();
			conn.close();
		} catch(ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch(SQLException e2) {
			e2.printStackTrace();
		} finally {
			if(!s.getParadas().isEmpty()) {
				for(int i = 0; i < s.getParadas().size(); i++) {
					DBManager.addLineaParada(s, s.getParadas().get(i));
				}
			}
		}
	}
	
	public static void addIncidencia(Incidencia i, Camino c) {
		Connection conn = null;
		String inicio = i.getInicio().getYear()+"-"+0+i.getInicio().getMonthValue()
				+"-"+i.getInicio().getDayOfMonth();
		String fin = "";
		if(i.getFin() != null) {
			fin = i.getFin().getYear()+"-"+i.getFin().getMonthValue()+"-"
			+i.getFin().getDayOfMonth();
		}
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			Statement st = conn.createStatement();
			if(i.getFin() != null) {
				st.executeUpdate("INSERT INTO INCIDENCIA VALUES ("+i.getId()+",'"+inicio+
						"','"+fin+"','"+i.getDescripcion()+"',"+c.getId()+")");
			} else {
				st.executeUpdate("INSERT INTO INCIDENCIA (id,inicio,descripcion,camino_id)"
						+ " VALUES ("+i.getId()+",'"+inicio+"','"+i.getDescripcion()+"',"
						+c.getId()+")");
			}
			st.close();
			conn.close();
		} catch(ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch(SQLException e2) {
			e2.printStackTrace();
		}
	}
	
	public static void addParada(Parada p) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			Statement st = conn.createStatement();
			st.executeUpdate("INSERT INTO PARADA (ID, NROPARADA, CALLE, NROCALLE) VALUES ("
			+p.getId()+","+p.getNroParada()+",'"+p.getCalle()+"',"+p.getNroCalle()+")");
			st.close();
			conn.close();
		} catch(ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch(SQLException e2) {
			e2.printStackTrace();
		}
	}
	
	public static void addLineaParada(Linea l, Parada p) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			Statement st = conn.createStatement();
			st.executeUpdate("INSERT INTO LINEA_PARADA (id_linea,id_parada)"
			+" VALUES ("+l.getId()+","+p.getId()+")");
			st.close();
			conn.close();
		} catch(ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch(SQLException e2) {
			e2.printStackTrace();
		}
	}
	
	public static void addLineaCamino(Linea l, Camino c) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			Statement st = conn.createStatement();
			st.executeUpdate("INSERT INTO LINEA_CAMINO (id_linea,id_camino)"
			+" VALUES ("+l.getId()+","+l.getId()+")");
			st.close();
			conn.close();
		} catch(ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch(SQLException e2) {
			e2.printStackTrace();
		}
	}
	
	public static void addCamino(Camino c) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			Statement st = conn.createStatement();
			st.executeUpdate("INSERT INTO CAMINO VALUES ("+c.getId()+","
			+c.getOrigen().getId()+","+c.getDestino().getId()+","+c.getDistancia()+")");
			st.close();
			conn.close();
		} catch(ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch(SQLException e2) {
			e2.printStackTrace();
		}
	}
	
	public static void addTrayecto(Trayecto t, Linea l) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			Statement st = conn.createStatement();
			st.executeUpdate("INSERT INTO TRAYECTO VALUES ("+t.getId()+","
			+t.getOrigen().getId()+","+t.getDestino().getId()+","+t.getDuracion()+","+l.getId()+")");
			st.close();
			conn.close();
		} catch(ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch(SQLException e2) {
			e2.printStackTrace();
		}
	}
	
	public static void cargarLineas() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery("SELECT * FROM LINEA");
			while(res.next()) {
				if(res.getString("wifi") != null) {
					boolean wifi;
					if(res.getString("wifi").equals("t")) {
						wifi = true;
					} else {
						wifi = false;
					}
					boolean aire;
					if(res.getString("aireacondicionado").equals("t")) {
						aire = true;
					} else {
						aire = false;
					}
					App.cargarSuperior(res.getInt("id"), res.getString("nombre"), res.getString("color"), 
							res.getInt("maxpasajerossentados"), wifi, aire);
				} else {
					App.cargarEconomica(res.getInt("id"), res.getString("nombre"), res.getString("color"),
							res.getInt("maxpasajerossentados"), res.getInt("maxpasajerosparados"));
				}
			}
			st.close();
			conn.close();
		} catch(ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch(SQLException e2) {
			e2.printStackTrace();
		}
	}
	
	public static void cargarParadas() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery("SELECT * FROM PARADA");
			while(res.next()) {
				App.cargarParada(res.getInt("id"), res.getInt("nroparada"), res.getString("calle"), 
						res.getInt("nrocalle"));
			}
			st.close();
			conn.close();
		} catch(ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch(SQLException e2) {
			e2.printStackTrace();
		}
	}
	
	public static void cargarCaminos() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery("SELECT * FROM CAMINO");
			while(res.next()) {
				App.cargarCamino(res.getInt("id"), res.getInt(2), res.getInt(3), 
						res.getFloat("distancia"));
			}
			st.close();
			conn.close();
		} catch(ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch(SQLException e2) {
			e2.printStackTrace();
		}
	}
	
	public static void cargarIncidencias() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery("SELECT * FROM INCIDENCIA");
			while(res.next()) {
				App.cargarIncidencia(res.getInt("id"), res.getString("descripcion"), 
						LocalDate.parse(res.getString("inicio")), LocalDate.parse(res.getString("fin")),  
						res.getInt("camino_id"));
			}
			st.close();
			conn.close();
		} catch(ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch(SQLException e2) {
			e2.printStackTrace();
		}
	}
}
