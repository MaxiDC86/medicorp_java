package medicorp_package;

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

		fechaNacimiento.set(Calendar.YEAR, 1986);
		fechaNacimiento.set(Calendar.MONTH, 12 - 1);
		fechaNacimiento.set(Calendar.DAY_OF_MONTH, 17);
		dni = 32771332;
		apellido = "Dias Correia";
		nombre = "Maximiliano";

		paciente socio = new paciente(dni, apellido, nombre, fechaNacimiento); // Se da de alta un nuevo socio
		losPacientes.add(paciente.getSocioTotal() - 1, socio);

		miMarco mimarco = new miMarco(losPacientes);
	}

}

class miMarco extends JFrame {
	private ArrayList<paciente> losPacientes;
	public miMarco(ArrayList<paciente> losPacientes) {
		setBounds(500, 300, 450, 400);
		setTitle("Bienvenidos a MEDICORP SOLUTIONS");
		setResizable(false);
		setIconImage(null);
		setVisible(true);
		this.losPacientes = losPacientes;
		Lamina milamina = new Lamina(losPacientes);
		add(milamina);
	}
	
}

class Lamina extends JPanel {
	JButton botonListar = new JButton("Listar Pacientes");
	JButton botonAlta = new JButton("Alta de Pacientes");

	public Lamina(ArrayList<paciente> losPacientes) {
		add(botonListar);
		add(botonAlta);
		botonListar.addActionListener(new listar_pacientes());
		botonAlta.addActionListener(new alta_pacientes());
		this.losPacientes = losPacientes;
	}

	private class listar_pacientes implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < losPacientes.size(); i++) {
				System.out.println(losPacientes.get(i).getDNI());
				System.out.println(losPacientes.get(i).getLastName());
				System.out.println(losPacientes.get(i).getName());
				System.out.println(losPacientes.get(i).getBirthDate().get(Calendar.YEAR));
				System.out.println(losPacientes.get(i).getBirthDate().get(Calendar.MONTH) + 1);
				System.out.println(losPacientes.get(i).getBirthDate().get(Calendar.DAY_OF_MONTH));
			}
		}
	}
	private class alta_pacientes implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			System.out.println("Se da de alta un paciente");
		}
		
	}
	private ArrayList<paciente> losPacientes;
}
