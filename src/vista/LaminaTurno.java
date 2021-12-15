package vista;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LaminaTurno extends JPanel{
	
	public LaminaTurno() {
		setLayout(new GridLayout(4,4));
		
		add(new JLabel("Especialidad:"));
		especialidades = new JComboBox();
		add(especialidades);
		
		add(new JLabel("DNI:"));
		dni = new JTextField(8);
		add(dni);
		
		add(new JLabel("¿Enviar email con turno?"));
		sendTurnoEmail = new JCheckBox();
		add(sendTurnoEmail);
		
		JButton enviar = new JButton("TOMAR TURNO");
		enviar.setBackground(Color.BLUE);
		add(enviar);
		
	}
	
	
	public String getEspecialidades() {
		return especialidades.getSelectedItem().toString();
	}
	public void setEspecialidades(String especialidad) {
		this.especialidades.addItem(especialidad);
	}

	private JComboBox especialidades;
	private JTextField dni;
	private JCheckBox sendTurnoEmail;
	

}
