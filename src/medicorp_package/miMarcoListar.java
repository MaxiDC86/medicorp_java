package medicorp_package;

import java.awt.Color;
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
		setBounds(700, 200, 800, 300);
		setTitle("MEDICORP SOLUTIONS - LISTADO DE PACIENTES");
		Toolkit mipantalla = Toolkit.getDefaultToolkit();
		Image miIcono = mipantalla.getImage("src/images/crocodile.png");
		setIconImage(miIcono);
		setResizable(true);
		setVisible(true);
		areaTexto = new JTextArea(8, 20);
		areaTexto.setEditable(false);
		areaTexto.setEnabled(false);
		areaTexto.setWrapStyleWord(true);
		areaTexto.setLineWrap(true);
		areaTexto.setDisabledTextColor(Color.black);
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
				areaTexto.append("    Fecha de Nac.: " + day + "/" + month + "/" + year + "   Alta: "
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