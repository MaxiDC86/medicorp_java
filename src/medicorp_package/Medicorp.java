package medicorp_package;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
		setBounds(300, 100, 600, 100);
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

	private static ArrayList<paciente> losPacientes = new ArrayList<paciente>();
	private int dni;
	private String apellido;
	private String nombre;
	private GregorianCalendar fechaNacimiento = new GregorianCalendar();
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
		botonBuscar.addActionListener(new buscar_pacientes());
		setBackground(new Color(26, 105, 150));
		losPacientes = readFromFile();
	}

	private class listar_pacientes implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			losPacientes = readFromFile();
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
				//--------------Validación de fuera de rango para el DNI
				if (dni <= 999999 | dni > 99000000) {
					throw new dni_validation("El DNI ingresado es inválido (fuera de rango)");
				}
				//-------------Validación de existencia para el DNI
				for (int i = 0; i < losPacientes.size(); i++) {
					if (dni == losPacientes.get(i).getDNI()) {
						throw new dni_validation("El DNI ya está dado de alta.");
					}
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
				// -------------------------------------------------Saving to file
				saveToFile(losPacientes);

				System.out.println("Se da de alta un paciente");
				JOptionPane.showMessageDialog(null, "Paciente dado de alta satisfactoriamente.");
			} catch (dni_validation e1) {
				user_comunication.setText("Error:  " + e1.getMessage());
				error.write("Error:  " + e1.getMessage());
			} catch (IllegalArgumentException e2) {
				user_comunication.setText("Error: dato ingresado es inválido.");
				error.write("Error: dato ingresado es inválido.");
			} catch (NullPointerException e3) {
				user_comunication.setText("Error: Carga de datos cancelada.");
				error.write("Error: Carga de datos cancelada.");
			} catch (ArrayIndexOutOfBoundsException e4) {
				user_comunication.setText("Error: DNI no válido.");
				error.write("Error: DNI no válido.");
			} catch (Throwable e5) {
				user_comunication.setText("Error inesperado durante la carga de datos.");
			}
		}
	}

	private class buscar_pacientes implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			losPacientes = readFromFile();
			if (losPacientes.isEmpty()) {
				user_comunication.setText("No hay pacientes cargados.");
			} else {
				MiMarcoBuscar mimarco3 = new MiMarcoBuscar(losPacientes);
				mimarco3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		}

	}

	@SuppressWarnings("unchecked")
	public ArrayList<paciente> readFromFile() {
		try {
			ObjectInputStream leyendo_fichero;
			leyendo_fichero = new ObjectInputStream(new FileInputStream("./src/medicorp_package/patients.ser"));
			losPacientes = (ArrayList<paciente>) leyendo_fichero.readObject();
			leyendo_fichero.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return losPacientes;
	}

	public void saveToFile(ArrayList<paciente> losPacientes) {
		try {
			ObjectOutputStream escribiendo_fichero = new ObjectOutputStream(
					new FileOutputStream("./src/medicorp_package/patients.ser"));
			escribiendo_fichero.writeObject(losPacientes);
			escribiendo_fichero.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}

class dni_validation extends Exception {

	private static final long serialVersionUID = 1L;

	public dni_validation() {
	}

	public dni_validation(String msj_error) {
		super(msj_error);
	}
}
