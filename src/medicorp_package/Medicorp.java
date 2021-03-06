package medicorp_package;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;


public class Medicorp {
	public static void main(String[] args) {
		miMarco mimarco = new miMarco();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
	}
}

class miMarco extends JFrame {

	private static final long serialVersionUID = 1L;

	public miMarco() {
		setBounds(700, 300, 600, 300);
		setTitle("Bienvenidos a MEDICORP SOLUTIONS");
		setResizable(false);
		Lamina milamina = new Lamina();
		add(milamina);
		Toolkit mipantalla = Toolkit.getDefaultToolkit();
		Image miIcono = mipantalla.getImage("src/images/crocodile.png");
		setIconImage(miIcono);
	}
}

class Lamina extends JPanel {

	private static final long serialVersionUID = 1L;
	JButton botonListar = new JButton("Listar Pacientes");
	JButton botonAlta = new JButton("Alta de Pacientes");
	JButton botonBuscar = new JButton("Buscar Pacientes");
	JButton botonTurnoAlta = new JButton("Alta de Turno");
	private JLabel user_comunication = new JLabel();
	Log_errors error = new Log_errors();
	
	public Lamina() {
		add(botonListar);
		add(botonAlta);
		add(botonBuscar);
		add(botonTurnoAlta);
		add(user_comunication);
		botonListar.addActionListener(new listar_pacientes());
		botonAlta.addActionListener(new alta_pacientes());
		setBackground(new Color(26, 105, 150));
	}

	private class listar_pacientes implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (losPacientes.isEmpty()) {
				user_comunication.setText("No hay pacientes cargados.");
			} else {
				miMarcoListar mimarco2 = new miMarcoListar(losPacientes);
				mimarco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		}
	}

	private class alta_pacientes implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String regex = "^[a-zA-Z]+$";
			try {
				dni = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el DNI del paciente: "));
				if (dni <= 999999 | dni > 99000000) {
					throw new dni_validation("El DNI ingresado es inv?lido");
				}
				apellido = JOptionPane.showInputDialog("Ingrese el apellido del paciente: ");
				if (apellido.matches(regex)) {// ...
				}
				apellido = apellido.trim();
				apellido = apellido.substring(0, 1).toUpperCase() + apellido.substring(1);
				nombre = JOptionPane.showInputDialog("Ingrese el nombre del paciente: ");
				if (nombre.matches(regex)) {// ...
				}
				nombre = nombre.trim();
				nombre = nombre.substring(0, 1).toUpperCase() + nombre.substring(1);
				fechaNacimiento.setLenient(false);
				fechaNacimiento.set(Calendar.YEAR,
						Integer.parseInt(JOptionPane.showInputDialog("Ingrese el a?o de nacimiento: ")));
				fechaNacimiento.set(Calendar.MONTH,
						Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes de nacimiento: ")) - 1);
				fechaNacimiento.set(Calendar.DAY_OF_MONTH,
						Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dia de nacimiento: ")));
				System.out.println(fechaNacimiento.getTime());
				paciente socio = new paciente(dni, apellido, nombre, fechaNacimiento); // Se da de alta un nuevo socio
				losPacientes.add(paciente.getSocioTotal() - 1, socio);
				System.out.println("Se da de alta un paciente");
				JOptionPane.showMessageDialog(null, "Paciente dado de alta satisfactoriamente.");
			} catch (dni_validation e1) {
				user_comunication.setText("Error:  " + e1.getMessage());
				error.write("El DNI ingresado es inv?lido");
			} catch (IllegalArgumentException e2) {
				user_comunication.setText("Error: dato ingresado es inv?lido.");
				error.write("Error: dato ingresado es inv?lido.");
			} catch (NullPointerException e3) {
				user_comunication.setText("Error: Carga de datos cancelada.");
				error.write("Error: Carga de datos cancelada.");
			} catch (ArrayIndexOutOfBoundsException e4) {
				user_comunication.setText("Error: DNI no v?lido.");
				error.write("Error: DNI no v?lido.");
			} catch (Throwable e5) {
				user_comunication.setText("Error inesperado durante la carga de datos.");
			}
		}
	}

	private static ArrayList<paciente> losPacientes = new ArrayList<paciente>();
	private int dni;
	private String apellido;
	private String nombre;
	private GregorianCalendar fechaNacimiento = new GregorianCalendar();

}

class dni_validation extends Exception {

	private static final long serialVersionUID = 1L;

	public dni_validation() {
	}

	public dni_validation(String msj_error) {
		super(msj_error);
	}
}
