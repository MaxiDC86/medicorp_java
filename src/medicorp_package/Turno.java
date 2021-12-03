package medicorp_package;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Turno {
	
	public Turno(int dni, String apellido, String nombre, GregorianCalendar fechaNacimiento){
		this.dni = dni;
		this.apellido = apellido;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		
	}
	
	private int dni;
	private String apellido;
	private String nombre;
	private GregorianCalendar fechaNacimiento;
	private GregorianCalendar fechaTurno;
	
	
	
	private static ArrayList<Turno> TurnosPacientes = new ArrayList<Turno>();

}
