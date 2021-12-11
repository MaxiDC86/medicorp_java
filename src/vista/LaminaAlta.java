package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.*;
import javax.swing.JFormattedTextField.AbstractFormatter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import controlador.ControladorBotonAlta;
import controlador.ControladorBotonBusqueda;
import modelo.EjecutaNuevoPaciente;

public class LaminaAlta extends JPanel {

	public LaminaAlta() {

		setLayout(new BorderLayout());
		JPanel lamina_superior = new JPanel();
		JPanel lamina_centro = new JPanel();
		lamina_superior.setLayout(new GridLayout(7, 2));
		add(lamina_superior, BorderLayout.NORTH);
		add(lamina_centro, BorderLayout.CENTER);
		apellido = new JTextField(15);
		nombre = new JTextField(15);
		dni = new JTextField(15);
		sexo = new JComboBox();
		sexo.setEditable(false);
		sexo.addItem("FEMENINE");
		sexo.addItem("MASCULINE");
		sexo.addItem("OTHER");
		estadoCivil = new JComboBox();
		estadoCivil.setEditable(false);
		estadoCivil.addItem("MARRIED");
		estadoCivil.addItem("SINGLE");
		estadoCivil.addItem("DIVORCED");
		//-----------------Fecha de Nacimiento------------------------------
		model = new UtilDateModel();
		model.setDate(1990, 8, 24);//Fecha inicial en el calendario.
		model.setSelected(true);
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		JDatePickerImpl fechaNacimiento = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		//--------------------------------------------------------------
		lamina_superior.add(new JLabel("   Apellido"));
		lamina_superior.add(apellido);
		lamina_superior.add(new JLabel("   Nombre"));
		lamina_superior.add(nombre);
		lamina_superior.add(new JLabel("   DNI"));
		lamina_superior.add(dni);
		lamina_superior.add(new JLabel("   Fecha de Nacimiento"));
		lamina_superior.add(fechaNacimiento);
		lamina_superior.add(new JLabel("   Genero"));
		lamina_superior.add(sexo);
		lamina_superior.add(new JLabel("   Estado civil"));
		lamina_superior.add(estadoCivil);

		JButton enviar = new JButton("CARGAR PACIENTE EN BASE DE DATOS");
		enviar.setBackground(Color.GREEN);
		enviar.addActionListener(new ControladorBotonAlta(this));
		add(enviar, BorderLayout.SOUTH);
	}

	public class DateLabelFormatter extends AbstractFormatter {

		private String datePattern = "yyyy-MM-dd";
		private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

		@Override
		public Object stringToValue(String text) throws ParseException {
			return dateFormatter.parseObject(text);
		}

		@Override
		public String valueToString(Object value) throws ParseException {
			if (value != null) {
				Calendar cal = (Calendar) value;
				return dateFormatter.format(cal.getTime());
			}

			return "";
		}

	}

	public String getApellido() {
		return apellido.getText();
	}

	public String getNombre() {
		return nombre.getText();
	}

	public String getEstadocivil() {
		return estadoCivil.getSelectedItem().toString();
	}

	public int getDni() {
		return Integer.parseInt(dni.getText());
	}

	public String getFechaNacimiento() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String yyyyMMdd = sdf.format(model.getValue());
		return yyyyMMdd;
	}

	public String getSexo() {
		return sexo.getSelectedItem().toString();
	}

	private JTextField dni;
	private JTextField nombre;
	private JTextField apellido;
	private JDatePickerImpl fechaNacimiento;
	private UtilDateModel model;
	private JComboBox estadoCivil, sexo;

}
