package modelo;

import java.sql.*;

public class Conexion {
	public Conexion() {

	}

	public Connection dameConexion() {
		Connection miConexion = null;

		try {
			miConexion = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/pacientes" + "?user=pma" + "&password=123456" + "&useSSL=false");

		} catch (Exception e) {

		}
		return miConexion;
	}

}
