package vista;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;

import controlador.ControladorCargaCoberturaMedica;
import controlador.ControladorCargaEspecialidades;

public class MiMarcoTurno extends JFrame{

	private static final long serialVersionUID = 1L;

	public MiMarcoTurno() {

		setBounds(100, 200, 500, 400);
		setTitle("MEDICORP SOLUTIONS - ALTA TURNOS");
		Toolkit mipantalla = Toolkit.getDefaultToolkit();
		Image miIcono = mipantalla.getImage("src/images/crocodile.png");
		setIconImage(miIcono);
		setResizable(false);
		setVisible(true);
		LaminaTurno lamina2 = new LaminaTurno();
		add(lamina2);
		addWindowListener(new ControladorCargaEspecialidades(lamina2));
	}

}
