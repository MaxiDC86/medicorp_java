package vista;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;

import controlador.ControladorCargaCoberturaMedica;

public class MiMarcoAlta extends JFrame {
	private static final long serialVersionUID = 1L;

	public MiMarcoAlta() {

		setBounds(100, 200, 700, 400);
		setTitle("MEDICORP SOLUTIONS - ALTA DE PACIENTES");
		Toolkit mipantalla = Toolkit.getDefaultToolkit();
		Image miIcono = mipantalla.getImage("src/images/crocodile.png");
		setIconImage(miIcono);
		setResizable(false);
		setVisible(true);
		LaminaAlta lamina2 = new LaminaAlta();
		add(lamina2);
		addWindowListener(new ControladorCargaCoberturaMedica(lamina2));
	}

}
