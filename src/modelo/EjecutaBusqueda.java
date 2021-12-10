package modelo;

import java.sql.*;

public class EjecutaBusqueda {
	public EjecutaBusqueda() {
		miConexion = new Conexion();
	}

	public ResultSet Busqueda(String apellido, String nombre, String dni, String fechaNacimiento) {
		Connection accesoBBDD = miConexion.dameConexion();
		try {
			enviaConsultaTodos= accesoBBDD.prepareStatement(consultaTodos);
			enviaConsultaTodos.setString(1,apellido);
			enviaConsultaTodos.setString(2,nombre);
			enviaConsultaTodos.setString(3,dni);
			enviaConsultaTodos.setString(4,fechaNacimiento);
			rs=enviaConsultaTodos.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}

	public Conexion miConexion;
	public ResultSet rs;
	private PreparedStatement enviaConsultaTodos;
	private final String consultaTodos = "SELECT DNI, LASTNAME, NAME, GENDER, BIRTHDAY,"
			+ " MARITALSTATUS  FROM pacientes WHERE LASTNAME=? OR NAME=? OR DNI=? OR BIRTHDAY=?";

}
