package modelo;

import java.sql.*;

public class EjecutaBusqueda {
	public EjecutaBusqueda() {
		miConexion = new Conexion();
	}

	public ResultSet Busqueda(String apellido, String nombre, String dni, String fechaNacimiento, String sexo) {
		Connection accesoBBDD = miConexion.dameConexion();
		if(fechaNacimiento.equals("")) {
			this.fechaNacimiento ="0000-00-00";
		}else {
			this.fechaNacimiento =fechaNacimiento;
		}
		System.out.println(fechaNacimiento);
		try {
			enviaConsultaTodos= accesoBBDD.prepareStatement(consultaTodos);
			enviaConsultaTodos.setString(1,apellido);
			enviaConsultaTodos.setString(2,nombre);
			enviaConsultaTodos.setString(3,dni);
			enviaConsultaTodos.setString(4,this.fechaNacimiento);
			enviaConsultaTodos.setString(5,sexo);
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
			+ " MARITALSTATUS  FROM pacientes WHERE (LASTNAME=? OR NAME=? OR DNI=? OR BIRTHDAY=?) AND GENDER=?";
	private String fechaNacimiento;

}
