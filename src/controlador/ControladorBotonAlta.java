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
		
		if(miLamina.getDniString().equals("")|| miLamina.getApellido().equals("") || miLamina.getNombre().equals("") ) {
			miLamina.setDatosCargados("Completar todos los campos!");
		}else {
			
			if(obj.NuevoPaciente(miLamina.getDni(), miLamina.getApellido(), miLamina.getNombre(),
					miLamina.getFechaNacimiento(), miLamina.getSexo(), miLamina.getEstadocivil(),miLamina.getCoberturaMedica()).equals("OK")) {
				
				miLamina.setDatosCargados("---->Los datos han sido cargados exitosamente!");
				miLamina.clearInlet();
			}else {
				miLamina.setDatosCargados("---->Se ha producido un error!");
			}
		}

	}

	EjecutaNuevoPaciente obj = new EjecutaNuevoPaciente();
	private LaminaAlta miLamina;
	private String cargaDatos;

}
