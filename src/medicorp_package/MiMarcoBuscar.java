package medicorp_package;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class MiMarcoBuscar extends JFrame {

	private static final long serialVersionUID = 1L;

	public MiMarcoBuscar(ArrayList<paciente> losPacientes) {

		setBounds(100, 200, 600, 300);
		setTitle("MEDICORP SOLUTIONS - BUSCAR PACIENTES");
		Toolkit mipantalla = Toolkit.getDefaultToolkit();
		Image miIcono = mipantalla.getImage("src/images/crocodile.png");
		setIconImage(miIcono);
		setResizable(false);
		setVisible(true);
		LaminaBuscar lamina2 = new LaminaBuscar(losPacientes);
		add(lamina2);

	}

}

class LaminaBuscar extends JPanel {
	private static final long serialVersionUID = 1L;

	public LaminaBuscar(ArrayList<paciente> losPacientes) {
		this.losPacientes = losPacientes;
		setLayout(new BorderLayout());
		JPanel lamina_superior = new JPanel();
		JPanel lamina_centro = new JPanel();
		lamina_superior.setLayout(new GridLayout(4, 2));
		area_resultado = new JTextArea(8, 50);
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

		JButton enviar = new JButton("ENVIAR");
		enviar.setBackground(Color.GREEN);
		enviar.addActionListener(new EnviarDatos());
		add(enviar, BorderLayout.SOUTH);
	}

	private class EnviarDatos implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			area_resultado.setText("");
			for (int i = 0; i < losPacientes.size(); i++) {

				if (nombre.getText().equalsIgnoreCase(losPacientes.get(i).getName())) {
					area_resultado.append("    Nombre: " + losPacientes.get(i).getName());
					area_resultado.append("    Apellido: " + losPacientes.get(i).getLastName());
					String dni = Integer.toString(losPacientes.get(i).getDNI());
					area_resultado.append(" DNI: " + dni + "\n");
				}
				if (apellido.getText().equalsIgnoreCase(losPacientes.get(i).getLastName())) {
					area_resultado.append("    Nombre: " + losPacientes.get(i).getName());
					area_resultado.append("    Apellido: " + losPacientes.get(i).getLastName());
					String dni = Integer.toString(losPacientes.get(i).getDNI());
					area_resultado.append(" DNI: " + dni + "\n");
				}
				if (dni.getText().equals(Integer.toString(losPacientes.get(i).getDNI()))) {
					area_resultado.append("    Nombre: " + losPacientes.get(i).getName());
					area_resultado.append("    Apellido: " + losPacientes.get(i).getLastName());
					String dni = Integer.toString(losPacientes.get(i).getDNI());
					area_resultado.append(" DNI: " + dni + "\n");
				}
			}
		}
	}

	private JTextField apellido;
	private JTextField nombre;
	private JTextField dni;
	private JTextField fechaNacimiento;
	private JTextArea area_resultado;
	private ArrayList<paciente> losPacientes;
}
