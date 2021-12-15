package controlador;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import vista.LaminaAlta;

public class ControladorCamposAlta implements FocusListener {

	public ControladorCamposAlta(JTextField campo, int selector, LaminaAlta milamina) {
		this.campo = campo;
		this.selector = selector;
		this.milamina = milamina;
	}

	@Override
	public void focusGained(FocusEvent e) {
		if (selector == 1) {
			campo.setText("");
			milamina.setEmailIncorrecto(""); // Se borra el mensaje de error.
		}
		if (selector == 2) {
			milamina.setNombreIncorrecto("");// Se borra el mensaje de error.
		}
		if (selector == 3) {
			milamina.setApellidoIncorrecto("");// Se borra el mensaje de error.
		}
		if (selector == 4) {
			milamina.setDniIncorrecto("");// Se borra el mensaje de error.
		}

	}

	@Override
	public void focusLost(FocusEvent e) {

		if (selector == 1) {
			String emailString = campo.getText();
			int arroba = 0;
			int punto = 0;
			for (int i = 0; i < emailString.length(); i++) {
				if (emailString.charAt(i) == '@')
					arroba = arroba + 1;
				if (emailString.charAt(i) == '.')
					punto = punto + 1;
			}
			if (arroba == 1 & punto > 1) {
				milamina.setEmailIncorrecto("   El email es válido!");
				emailOK = true;

			} else {
				milamina.setEmailIncorrecto("<--   El email no es válido");
				emailOK = false;
			}
		}
		if (selector == 2) {
			String palabra = campo.getText();
			if (palabra.equals("")) {
				milamina.setNombreIncorrecto("<--  El nombre no es válido");
				nombreOK = false;
			} else {
				nombreOK = true;
	
			}
		}
		if (selector == 3) {
			String palabra = campo.getText();
			if (palabra.equals("")) {
				milamina.setApellidoIncorrecto("<--  El apellido no es válido");
				apellidoOK= false;
			} else {
				apellidoOK = true;

			}
		} else if (selector == 4) {
			String palabra = campo.getText();
			if (palabra.equals("")) {
				milamina.setDniIncorrecto("<--   El dni es inválido ");
				dniOK=false;
			} else if (milamina.dniYaCargado(milamina.getDni())) {
				milamina.setDniIncorrecto("<--El dni ya existe en la base de datos");
				dniOK=false;
			} else {
				dniOK = true;
				

			}
		}

		if (dniOK & emailOK & apellidoOK & nombreOK) {
			milamina.allCamposOK(true);

		} else {
			milamina.allCamposOK(false);
		}
	}

	private JTextField campo;
	private int selector;
	private LaminaAlta milamina;
	private static boolean dniOK = false;
	private static boolean nombreOK = false;
	private static boolean apellidoOK = false;
	private static boolean emailOK = false;

}
