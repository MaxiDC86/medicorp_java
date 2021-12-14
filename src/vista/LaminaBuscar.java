package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controlador.ControladorBotonBusqueda;

public class LaminaBuscar extends JPanel {
	private static final long serialVersionUID = 1L;

	public LaminaBuscar() {

		setLayout(new BorderLayout());
		JPanel lamina_superior = new JPanel();
		JPanel lamina_centro = new JPanel();
		lamina_superior.setLayout(new GridLayout(6, 2));
		area_resultado = new JTextArea(10, 115);
		area_resultado.setEditable(false);
		area_resultado.setEnabled(false);
		area_resultado.setWrapStyleWord(true);
		area_resultado.setLineWrap(true);
		area_resultado.setDisabledTextColor(Color.black);
		area_resultadoScroll = new JScrollPane(area_resultado);
		area_resultadoScroll.setBounds(10, 100, 300, 400);
		lamina_centro.add(area_resultadoScroll);
		add(lamina_superior, BorderLayout.NORTH);
		add(lamina_centro, BorderLayout.CENTER);
		apellido = new JTextField(15);
		nombre = new JTextField(15);
		dni = new JTextField(15);
		fechaNacimiento = new JTextField(15);
		sexo = new JComboBox();
		sexo.setEditable(false);
		sexo.addItem("MASCULINE");
		sexo.addItem("FEMENINE");
		sexo.addItem("OTRO");
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

	public String getSexo() {
		return sexo.getSelectedItem().toString();
	}

	private JTextField dni;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField fechaNacimiento;
	private JComboBox sexo;
	private JTextArea area_resultado;
	private JScrollPane area_resultadoScroll;

}