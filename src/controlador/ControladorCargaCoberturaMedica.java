package controlador;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import modelo.CargaCoberturaMedica;
import vista.LaminaAlta;

public class ControladorCargaCoberturaMedica extends WindowAdapter{
	public ControladorCargaCoberturaMedica(LaminaAlta miLamina) {
		this.miLamina = miLamina;
	}
	public void windowOpened(WindowEvent e) {
		obj.ejecutaConsulta(); // Cargamos el objeto obj con la respuesta de la BBDD.
		
		try {
			while(obj.rs.next()) {
				
				miLamina.setCoberturaMedica(obj.rs.getString(1)); 
			}
			
		}catch(Exception e1) {	
		}
	}
	CargaCoberturaMedica obj= new CargaCoberturaMedica();
	private LaminaAlta miLamina;

}
