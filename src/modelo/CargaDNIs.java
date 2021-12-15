package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CargaDNIs {

	public CargaDNIs() {
		miConexion = new Conexion();
	}

	public void ejecutaCargaDNIs() {
		Connection accesoBBDD = miConexion.dameConexion();

		try {
			Statement coberturas = accesoBBDD.createStatement();
			rs = coberturas.executeQuery("SELECT DISTINCTROW DNI FROM pacientes");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public Conexion miConexion;
	public ResultSet rs;
}
