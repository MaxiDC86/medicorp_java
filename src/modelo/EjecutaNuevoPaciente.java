package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;


public class EjecutaNuevoPaciente {
	public EjecutaNuevoPaciente() {
		miConexion = new Conexion();
	}

	public String NuevoPaciente(int dni, String apellido, String nombre, 
			String birthday,String sexo, String maritalStatus) {
		Connection accesoBBDD = miConexion.dameConexion();
		try {
			enviaNuevoPaciente = accesoBBDD.prepareStatement(enviaDatosPaciente);
			enviaNuevoPaciente.setInt(1, dni);
			enviaNuevoPaciente.setString(2, apellido);
			enviaNuevoPaciente.setString(3, nombre);
			enviaNuevoPaciente.setString(4, sexo);
			enviaNuevoPaciente.setString(5, birthday);
			enviaNuevoPaciente.setString(6, maritalStatus);
			enviaNuevoPaciente.setInt(7, 9);
			enviaNuevoPaciente.setString(8, timeNow.toString());			
			enviaNuevoPaciente.executeUpdate();
			System.out.println("datos enviados!");
			return "OK";
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error!";
		}

	}

	public Conexion miConexion;
	private PreparedStatement enviaNuevoPaciente;
	private final String enviaDatosPaciente = "INSERT INTO pacientes ( DNI, LASTNAME, NAME,"
			+ " GENDER, BIRTHDAY,MARITALSTATUS,ID,CREATED) VALUES (?,?,?,?,?,?,?,?)";
	private LocalDate timeNow = LocalDate.now();
}
