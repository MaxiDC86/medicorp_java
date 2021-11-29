package medicorp_package;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

class miMarcoListar extends JFrame {
	public miMarcoListar(ArrayList<paciente> losPacientes) {
		setBounds(700, 200, 800, 400);
		setTitle("MEDICORP SOLUTIONS - LISTADO DE PACIENTES");
		Toolkit mipantalla = Toolkit.getDefaultToolkit();
		Image miIcono = mipantalla.getImage("src/images/crocodile.png");
		setIconImage(miIcono);
		setResizable(false);
		setVisible(true);
		areaTexto = new JTextArea(8, 20);
		try {
			for (int i = 0; i < losPacientes.size(); i++) {
				String dni = Integer.toString(losPacientes.get(i).getDNI());
				areaTexto.append(" DNI: " + dni);
				areaTexto.append("    Apellido: " + losPacientes.get(i).getLastName());
				areaTexto.append("    Nombre: " + losPacientes.get(i).getName());
				String year = Integer.toString(losPacientes.get(i).getBirthDate().get(Calendar.YEAR));
				String month = Integer.toString(losPacientes.get(i).getBirthDate().get(Calendar.MONTH) + 1);
				String day = Integer.toString(losPacientes.get(i).getBirthDate().get(Calendar.DAY_OF_MONTH));
				Date fechaAlta = losPacientes.get(i).getCreateDate();
				areaTexto.append("    Fecha de Nacimiento: " + day + "/" + month + "/" + year + "   Fecha de alta: "
						+ fechaAlta);
				areaTexto.append("\n");
			}
		} catch (NullPointerException erorr) {
			System.out.println("No hay datos cargados");
			JOptionPane.showMessageDialog(null, "No hay datos cargados");
		}
		add(areaTexto);
	}

	private JTextArea areaTexto;
	private static final long serialVersionUID = 1L;
}