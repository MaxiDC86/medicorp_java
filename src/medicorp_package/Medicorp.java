package medicorp_package;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.*;
import medicorp_package.paciente;

public class Medicorp {
	public static void main(String[] args) {
		ArrayList<paciente> losPacientes = new ArrayList<paciente>();
		int dni;
		String apellido;
		String nombre;
		GregorianCalendar fechaNacimiento = new GregorianCalendar();
		miMarco mimarco = new miMarco();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class miMarco extends JFrame {
	public miMarco() {
		setBounds(700, 300, 600, 300);
		setTitle("Bienvenidos a MEDICORP SOLUTIONS");
		setResizable(false);
		setIconImage(null);
		setVisible(true);
		Toolkit mipantalla = Toolkit.getDefaultToolkit();
		Image miIcono = mipantalla.getImage("src/graficos/crocodile.png");
		setIconImage(miIcono);
		Lamina milamina = new Lamina();
		add(milamina);
	}
}

class miMarcoListar extends JFrame {
	public miMarcoListar(ArrayList<paciente> losPacientes) {
		this.losPacientes = losPacientes;
		setBounds(100, 300, 700, 400);
		setTitle("MEDICORP SOLUTIONS - LISTADO DE PACIENTES");
		setResizable(false);
		setIconImage(null);
		setVisible(true);
		areaTexto = new JTextArea(8, 20);
		try {
			for (int i = 0; i < losPacientes.size(); i++) {
				String dni = Integer.toString(losPacientes.get(i).getDNI());
				areaTexto.append("DNI: " + dni);
				areaTexto.append("  Apellido: " + losPacientes.get(i).getLastName());
				areaTexto.append("  Nombre:" + losPacientes.get(i).getName());
				String year = Integer.toString(losPacientes.get(i).getBirthDate().get(Calendar.YEAR));
				String month = Integer.toString(losPacientes.get(i).getBirthDate().get(Calendar.MONTH) + 1);
				String day = Integer.toString(losPacientes.get(i).getBirthDate().get(Calendar.DAY_OF_MONTH));
				areaTexto.append("  Fecha de Nacimiento: " + day + "/" + month + "/" + year);
				areaTexto.append("\n");
			}
		} catch (NullPointerException erorr) {
			System.out.println("No hay datos cargados");
			JOptionPane.showMessageDialog(null, "No hay datos cargados");
		}
		add(areaTexto);
	}

	private JTextArea areaTexto;
	private ArrayList<paciente> losPacientes = new ArrayList<paciente>();
}

class Lamina extends JPanel {
	JButton botonListar = new JButton("Listar Pacientes");
	JButton botonAlta = new JButton("Alta de Pacientes");
	JButton botonBuscar = new JButton("Buscar Pacientes");
	JButton botonTurnoAlta = new JButton("Alta de Turno");
	private JLabel user_comunication = new JLabel();;

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
				System.out.println("No hay pacientes cargados.");
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
					throw new ArrayIndexOutOfBoundsException();
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
						Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de nacimiento: ")));
				fechaNacimiento.set(Calendar.MONTH,
						Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes de nacimiento: ")) - 1);
				fechaNacimiento.set(Calendar.DAY_OF_MONTH,
						Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dia de nacimiento: ")));
				System.out.println(fechaNacimiento.getTime());
				paciente socio = new paciente(dni, apellido, nombre, fechaNacimiento); // Se da de alta un nuevo socio
				losPacientes.add(paciente.getSocioTotal() - 1, socio);
				System.out.println("Se da de alta un paciente");
				JOptionPane.showMessageDialog(null, "Paciente dado de alta satisfactoriamente.");
			} catch (NumberFormatException e1) {
				System.out.println("Error: " + e1);
				JOptionPane.showMessageDialog(null, "Error: El DNI ingresado es inválido.");
			} catch (IllegalArgumentException e2) {
				user_comunication.setText("Error: Fecha de nacimiento inválida.");
			} catch (NullPointerException e3) {
				user_comunication.setText("Error: Carga de datos cancelada.");
			} catch (ArrayIndexOutOfBoundsException e4) {
				System.out.println("Error inesperado." + e4);
				user_comunication.setText("Error: DNI no válido.");
			} catch (Throwable e5) {
				System.out.println("Error inesperado." + e5);
				user_comunication.setText("Error");
			}
		}
	}

	private static ArrayList<paciente> losPacientes = new ArrayList<paciente>();
	private int dni;
	private String apellido;
	private String nombre;
	private GregorianCalendar fechaNacimiento = new GregorianCalendar();

}
