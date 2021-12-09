package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;

public class MiMarcoEliminar extends JFrame {

	private static final long serialVersionUID = 1L;

	public MiMarcoEliminar(ArrayList<paciente> losPacientes) {
		setBounds(700, 200, 800, 300);
		setTitle("MEDICORP SOLUTIONS - ELIMINAR DE PACIENTES");
		Toolkit mipantalla = Toolkit.getDefaultToolkit();
		Image miIcono = mipantalla.getImage("src/images/crocodile.png");
		setIconImage(miIcono);
		setResizable(true);
		setVisible(true);
		//milamina = new LaminaEliminar(losPacientes);
		add(milamina);

	}

	private LaminaEliminar milamina;
}

class LaminaEliminar extends JPanel {
	private static final long serialVersionUID = 1L;

	public LaminaEliminar() {

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

		JButton enviar = new JButton("Eliminar");
		enviar.setBackground(Color.GREEN);
		//enviar.addActionListener(new EliminarPaciente());
		add(enviar, BorderLayout.SOUTH);
	}




	private JTextField apellido;
	private JTextField nombre;
	private JTextField dni;
	private JTextField fechaNacimiento;
	private JTextArea area_resultado;


}
