package modelo;

import java.sql.*;

public class CargaCoberturaMedica {
	public CargaCoberturaMedica(){
		miConexion= new Conexion();
		
	}
	public void ejecutaConsulta() {
		Connection accesoBBDD = miConexion.dameConexion();
		
		try {
			Statement coberturas = accesoBBDD.createStatement();
			rs=coberturas.executeQuery("SELECT DISTINCTROW NOMBRE FROM coberturamedica");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public Conexion miConexion;
	public ResultSet rs;

}
