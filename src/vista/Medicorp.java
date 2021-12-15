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

import controlador.ControladorCargaCoberturaMedica;
import controlador.ControladorCargaDNIs;
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
		Lamina milamina = new Lamina(dniLista);
		add(milamina);
		Toolkit mipantalla = Toolkit.getDefaultToolkit();
		Image miIcono = mipantalla.getImage("src/images/crocodile.png");
		setIconImage(miIcono);
		addWindowListener(new ControladorCargaDNIs(dniLista));
	}



	private ArrayList<String> dniLista = new ArrayList<String>();
}

class Lamina extends JPanel {

	private static final long serialVersionUID = 1L;
	JButton botonListar = new JButton("Listar Pacientes");
	JButton botonAlta = new JButton("Alta de Pacientes");
	JButton botonBuscar = new JButton("Buscar Pacientes");
	JButton botonTurnoAlta = new JButton("Alta de Turno");
	JButton botonTurnoBaja = new JButton("Baja de Turno");
	private JLabel user_comunication = new JLabel();
	Log_errors error = new Log_errors();

	public Lamina(ArrayList<String> dniLista) {
		this.dniLista = dniLista;
		add(botonAlta);
		add(botonBuscar);
		add(botonTurnoAlta);
		add(botonTurnoBaja);
		add(user_comunication);
		botonAlta.addActionListener(new alta_pacientes());
		botonBuscar.addActionListener(new buscar_pacientes());
		botonTurnoAlta.addActionListener(new turno_nuevo());
		setBackground(new Color(26, 105, 150));
	}

	private class alta_pacientes implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			MiMarcoAlta mimarco2 = new MiMarcoAlta(dniLista);
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

	private class turno_nuevo implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			MiMarcoTurno mimarco4 = new MiMarcoTurno();
			mimarco4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}
	private ArrayList<String> dniLista;
}

class dni_validation extends Exception {

	private static final long serialVersionUID = 1L;

	public dni_validation() {
	}

	public dni_validation(String msj_error) {
		super(msj_error);
	}
}
