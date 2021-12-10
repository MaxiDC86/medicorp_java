package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controlador.ControladorBotonAlta;
import controlador.ControladorBotonBusqueda;
import modelo.EjecutaNuevoPaciente;

public class LaminaAlta extends JPanel {

	public LaminaAlta() {

		setLayout(new BorderLayout());
		JPanel lamina_superior = new JPanel();
		JPanel lamina_centro = new JPanel();
		lamina_superior.setLayout(new GridLayout(6, 2));
		add(lamina_superior, BorderLayout.NORTH);
		add(lamina_centro, BorderLayout.CENTER);
		apellido = new JTextField(15);
		nombre = new JTextField(15);
		dni = new JTextField(15);
		fechaNacimiento = new JTextField(15);
		sexo = new JTextField(15);
		estadocivil=new JTextField(15);
		lamina_superior.add(new JLabel("   Apellido"));
		lamina_superior.add(apellido);
		lamina_superior.add(new JLabel("   Nombre"));
		lamina_superior.add(nombre);
		lamina_superior.add(new JLabel("   DNI"));
		lamina_superior.add(dni);
		lamina_superior.add(new JLabel("   Fecha de Nacimiento"));
		lamina_superior.add(fechaNacimiento);
		lamina_superior.add(new JLabel("   Genero"));
		lamina_superior.add(sexo);
		lamina_superior.add(new JLabel("   Estado civil"));
		lamina_superior.add(estadocivil);

		JButton enviar = new JButton("CARGAR PACIENTE EN BASE DE DATOS");
		enviar.setBackground(Color.GREEN);
		enviar.addActionListener(new ControladorBotonAlta(this));
		add(enviar, BorderLayout.SOUTH);
	}

	public String getApellido() {
		return apellido.getText();
	}

	public String getNombre() {
		return nombre.getText();
	}

	public int getDni() {
		return  Integer.parseInt(dni.getText());
	}

	public String getFechaNacimiento() {
		return fechaNacimiento.getText();
	}
	public String getSexo() {
		return sexo.getText();
	}
	private JTextField dni;
	private JTextField nombre,sexo, estadocivil;
	private JTextField apellido;
	private JTextField fechaNacimiento;


}