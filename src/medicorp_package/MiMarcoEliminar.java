package medicorp_package;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;

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

	}
}
