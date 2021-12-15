package controlador;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import modelo.CargaCoberturaMedica;
import modelo.CargaDNIs;

public class ControladorCargaDNIs extends WindowAdapter {
	public ControladorCargaDNIs(ArrayList<String> dniLista) {
		this.dniLista = dniLista;

	}

	public void windowOpened(WindowEvent e) {
		obj.ejecutaCargaDNIs(); // Cargamos el objeto obj con la respuesta de la BBDD.
		try {
			while (obj.rs.next()) {

				dniLista.add(obj.rs.getString(1));
			}
		} catch (Exception e1) {
		}
	}

	CargaDNIs obj = new CargaDNIs();
	private ArrayList<String> dniLista;
}
