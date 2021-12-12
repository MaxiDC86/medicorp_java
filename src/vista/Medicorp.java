package vista;

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

import modelo.*;

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
		setBounds(300, 100, 800, 100);
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
	JButton botonTurnoBaja = new JButton("Baja de Turno");
	private JLabel user_comunication = new JLabel();
	Log_errors error = new Log_errors();

	public Lamina() {
		add(botonAlta);
		add(botonBuscar);
		add(botonTurnoAlta);
		add(botonTurnoBaja);
		add(user_comunication);
		botonAlta.addActionListener(new alta_pacientes());
		botonBuscar.addActionListener(new buscar_pacientes());
		setBackground(new Color(26, 105, 150));
	}

	private class alta_pacientes implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			MiMarcoAlta mimarco2 = new MiMarcoAlta();
			mimarco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}

	private class buscar_pacientes implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			MiMarcoBuscar mimarco3 = new MiMarcoBuscar();
			mimarco3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
