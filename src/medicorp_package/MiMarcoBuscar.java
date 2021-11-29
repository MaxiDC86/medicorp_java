package medicorp_package;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MiMarcoBuscar extends JFrame {

	private static final long serialVersionUID = 1L;

	public MiMarcoBuscar() {
		setBounds(100, 200, 500, 300);
		setTitle("MEDICORP SOLUTIONS - BUSCAR PACIENTES");
		Toolkit mipantalla = Toolkit.getDefaultToolkit();
		Image miIcono = mipantalla.getImage("src/images/crocodile.png");
		setIconImage(miIcono);
		setResizable(false);
		setVisible(true);
		LaminaBuscar lamina2 = new LaminaBuscar();
		add(lamina2);

	}
}
class LaminaBuscar extends JPanel {
	private static final long serialVersionUID = 1L;
	public LaminaBuscar() {
		setLayout(new BorderLayout());
		JPanel lamina_superior = new JPanel();
		lamina_superior.setLayout(new GridLayout(4, 2));
		add(lamina_superior, BorderLayout.NORTH);
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
			System.out.println(apellido.getText());
			System.out.println(nombre.getText());
			System.out.println(dni.getText());
			System.out.println(fechaNacimiento.getText());
		}
	}

	private JTextField apellido;
	private JTextField nombre;
	private JTextField dni;
	private JTextField fechaNacimiento;

}
