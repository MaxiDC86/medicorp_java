package modelo;

import java.sql.*;

public class Conexion {
	public Conexion() {

	}

	public Connection dameConexion() {
		Connection miConexion = null;

		try {
			miConexion = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/medicorp" + "?user=pma" + "&password=123456" + "&useSSL=false");
			/*miConexion = DriverManager
					.getConnection("jdbc:mysql://db4free.net:3306/pruebas_db4free","usuario_32771"
							,"Hola4278#");*/

		} catch (Exception e) {

		}
		return miConexion;
	}

}
