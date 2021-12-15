package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CargaEspecialidades {
	
	public CargaEspecialidades() {
		miConexion= new Conexion();
	}
	public void ejecutaConsulta() {
		Connection accesoBBDD = miConexion.dameConexion();
		
		try {
			Statement coberturas = accesoBBDD.createStatement();
			rs=coberturas.executeQuery("SELECT DISTINCTROW NOMBRE FROM especialidades");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	public Conexion miConexion;
	public ResultSet rs;
}
