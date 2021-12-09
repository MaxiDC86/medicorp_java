package vista;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

public class paciente implements Serializable {

	private static final long serialVersionUID = 1L;
	paciente(int dni, String apellido, String nombre, GregorianCalendar fechaNacimiento) {

		this.dni = dni;
		this.apellido = apellido;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.socio_id = socio_total;
		this.fechaAlta = new Date(System.currentTimeMillis());
		socio_total++;
	}

	public int getDNI() {
		return dni;
	}
	public int getId() {
		return socio_id;
	}

	public String getLastName() {
		return apellido;
	}

	public String getName() {
		return nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, dni, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		paciente other = (paciente) obj;
		return Objects.equals(apellido, other.apellido) && dni == other.dni && Objects.equals(nombre, other.nombre);
	}

	public GregorianCalendar getBirthDate() {
		return fechaNacimiento;
	}
	public Date getCreateDate() {
		return fechaAlta;
	}
	public static int getSocioTotal() {
		return socio_total;
	}

	private int dni;
	private String apellido;
	private String nombre;
	private GregorianCalendar fechaNacimiento;
	private Date fechaAlta;
	private int socio_id;
	private static int socio_total;

}
