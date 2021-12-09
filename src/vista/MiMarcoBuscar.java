package vista;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;

public class MiMarcoBuscar extends JFrame {

	private static final long serialVersionUID = 1L;

	public MiMarcoBuscar() {

		setBounds(100, 200, 1000, 400);
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
