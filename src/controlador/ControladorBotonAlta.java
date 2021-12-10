package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.EjecutaNuevoPaciente;
import vista.LaminaAlta;

public class ControladorBotonAlta implements ActionListener {

	public ControladorBotonAlta(LaminaAlta miLamina) {
		this.miLamina = miLamina;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		obj.NuevoPaciente(miLamina.getDni(), miLamina.getApellido(), miLamina.getNombre(),
				miLamina.getFechaNacimiento(), miLamina.getSexo(), "SINGLE");

	}

	EjecutaNuevoPaciente obj = new EjecutaNuevoPaciente();
	private LaminaAlta miLamina;

}
