package vista;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;

public class MiMarcoAlta extends JFrame {
	private static final long serialVersionUID = 1L;

	public MiMarcoAlta() {

		setBounds(100, 200, 1000, 300);
		setTitle("MEDICORP SOLUTIONS - ALTA DE PACIENTES");
		Toolkit mipantalla = Toolkit.getDefaultToolkit();
		Image miIcono = mipantalla.getImage("src/images/crocodile.png");
		setIconImage(miIcono);
		setResizable(false);
		setVisible(true);
		LaminaAlta lamina2 = new LaminaAlta();
		add(lamina2);
	}

}