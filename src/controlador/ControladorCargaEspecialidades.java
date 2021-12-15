package controlador;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import modelo.CargaEspecialidades;
import vista.LaminaTurno;



public class ControladorCargaEspecialidades extends WindowAdapter{
	
	public ControladorCargaEspecialidades(LaminaTurno miLamina) {
		this.miLamina = miLamina;
	}
	public void windowOpened(WindowEvent e) {
		obj.ejecutaConsulta(); // Cargamos el objeto obj con la respuesta de la BBDD.
		
		try {
			while(obj.rs.next()) {
				
				miLamina.setEspecialidades(obj.rs.getString(1)); 
			}
			
		}catch(Exception e1) {	
		}
	}
	CargaEspecialidades obj= new CargaEspecialidades(); 
	private LaminaTurno miLamina;

}
