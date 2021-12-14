package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import vista.*;
import modelo.*;

public class ControladorBotonBusqueda implements ActionListener {
	public ControladorBotonBusqueda(LaminaBuscar elmarco) {
		this.elmarco = elmarco;
	}

	@Override
	public void actionPerformed(ActionEvent e1) {
		
		elmarco.clearResultado(); // limpiamos la pantalla de busquedas anteriores.
		resultadoConsultas = obj.Busqueda(elmarco.getApellido(),elmarco.getNombre(), elmarco.getDni(), elmarco.getFechaNacimiento(),elmarco.getSexo());
		try {
			
			while(resultadoConsultas.next()) {
				elmarco.setArea_resultado(" DNI: ");
				elmarco.setArea_resultado(resultadoConsultas.getString("DNI"));
				elmarco.setArea_resultado(" , Apellido: ");
				elmarco.setArea_resultado(resultadoConsultas.getString("LASTNAME"));
				elmarco.setArea_resultado(" , Nombre: ");
				elmarco.setArea_resultado(resultadoConsultas.getString("NAME"));
				elmarco.setArea_resultado(" , Genero: ");
				elmarco.setArea_resultado(resultadoConsultas.getString("GENDER"));
				elmarco.setArea_resultado(" , Fecha de nacimiento: ");
				elmarco.setArea_resultado(resultadoConsultas.getString("BIRTHDAY"));
				elmarco.setArea_resultado(" , Estado civil: ");
				elmarco.setArea_resultado(resultadoConsultas.getString("MARITALSTATUS"));
				elmarco.setArea_resultado(" , Email: ");
				elmarco.setArea_resultado(resultadoConsultas.getString("EMAIL"));
				elmarco.setArea_resultado(" , Cobertura medica: ");
				elmarco.setArea_resultado(resultadoConsultas.getString("PRESTADOR"));
				elmarco.setArea_resultado("\n");
			}
		}catch(Exception e2) {
			
		}
			
		}
	EjecutaBusqueda obj = new EjecutaBusqueda();
	private LaminaBuscar elmarco;
	private ResultSet resultadoConsultas;
}
