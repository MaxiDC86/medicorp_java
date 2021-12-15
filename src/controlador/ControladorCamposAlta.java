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
			milamina.setEmailIncorrecto("");
		}
		if (selector == 2) {
			milamina.setNombreIncorrecto("");
		}
		if (selector == 3) {
			milamina.setApellidoIncorrecto("");
		}
		if (selector == 4) {
			milamina.setDniIncorrecto("");
		}

	}

	@Override
	public void focusLost(FocusEvent e) {

		if (selector == 1) {
			String emailString = campo.getText();
			int arroba = 0;
			for (int i = 0; i < emailString.length(); i++) {
				if (emailString.charAt(i) == '@')
					arroba = arroba + 1;
			}
			if (arroba == 1) {
				milamina.setEmailIncorrecto("   El email es válido!");
			} else {
				milamina.setEmailIncorrecto("<--   El email no es válido");
			}
		}
		if (selector == 2) {
			String palabra = campo.getText();
			if (palabra.equals("")) {
				milamina.setNombreIncorrecto("<--  El nombre no es válido");
			}
		}
		if (selector == 3) {
			String palabra = campo.getText();
			if (palabra.equals("")) {
				milamina.setApellidoIncorrecto("<--  El apellido no es válido");
			}
		} else if (selector == 4) {
			String palabra = campo.getText();
			if (palabra.equals("")) {
				milamina.setDniIncorrecto("<--   El dni es inválido ");
			}
			if( milamina.dniYaCargado(milamina.getDni())) {
				milamina.setDniIncorrecto("<--El dni ya existe en la base de datos");
			}
		}

	}

	private JTextField campo;
	private int selector;
	private LaminaAlta milamina;

}
