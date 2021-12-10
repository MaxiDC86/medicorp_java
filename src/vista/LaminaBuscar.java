package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controlador.ControladorBotonBusqueda;

public class LaminaBuscar extends JPanel {
	private static final long serialVersionUID = 1L;

	public LaminaBuscar() {

		setLayout(new BorderLayout());
		JPanel lamina_superior = new JPanel();
		JPanel lamina_centro = new JPanel();
		lamina_superior.setLayout(new GridLayout(4, 2));
		area_resultado = new JTextArea(10, 90);
		area_resultado.setEditable(false);
		area_resultado.setEnabled(false);
		area_resultado.setWrapStyleWord(true);
		area_resultado.setLineWrap(true);
		area_resultado.setDisabledTextColor(Color.black);
		lamina_centro.add(area_resultado);
		add(lamina_superior, BorderLayout.NORTH);
		add(lamina_centro, BorderLayout.CENTER);
		apellido = new JTextField(15);
		nombre = new JTextField(15);
		dni = new JTextField(15);
		fechaNacimiento = new JTextField(15);
		lamina_superior.add(new JLabel("   Apellido"));
		lamina_superior.add(apellido);
		lamina_superior.add(new JLabel("   Nombre"));
		lamina_superior.add(nombre);
		lamina_superior.add(new JLabel("   DNI"));
		lamina_superior.add(dni);
		lamina_superior.add(new JLabel("   Fecha de Nacimiento"));
		lamina_superior.add(fechaNacimiento);

		JButton enviar = new JButton("CONSULTAR EN BASE DE DATOS");
		enviar.setBackground(Color.GREEN);
		enviar.addActionListener(new ControladorBotonBusqueda(this));
		add(enviar, BorderLayout.SOUTH);
	}

	public void setArea_resultado(String area_resultado) {
		this.area_resultado.append(area_resultado);
	}
	public void clearResultado() {
		this.area_resultado.setText("");
	}

	public String getApellido() {
		return apellido.getText();
	}

	public String getNombre() {
		return nombre.getText();
	}

	public String getDni() {
		return dni.getText();
	}

	public String getFechaNacimiento() {
		return fechaNacimiento.getText();
	}
	private JTextField dni;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField fechaNacimiento;

	private JTextArea area_resultado;

}