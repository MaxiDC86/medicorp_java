package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;
import javax.swing.*;
import javax.swing.JFormattedTextField.AbstractFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import controlador.ControladorBotonAlta;
import controlador.ControladorCamposAlta;
import controlador.ControladorCargaCoberturaMedica;

public class LaminaAlta extends JPanel {

	public LaminaAlta(ArrayList<String> dniLista) {
		this.dniLista = dniLista;

		setLayout(new BorderLayout());
		JPanel lamina_superior = new JPanel();
		JPanel lamina_centro = new JPanel();
		lamina_superior.setLayout(new GridLayout(9, 3));
		//lamina_centro.setLayout(new GridLayout(3, 2));
		add(lamina_centro, BorderLayout.CENTER);
		add(lamina_superior, BorderLayout.NORTH);
		//-------APELLIDO--------------------------------
		apellido = new JTextField(15);
		controlFoco = new ControladorCamposAlta(apellido,3,this);
		apellido.addFocusListener(controlFoco);
		apellidoIncorrecto = new JLabel("");
		apellidoIncorrecto.setFont(letra2);
		apellidoIncorrecto.setForeground(Color.RED);
		//-------NOMBRE--------------------------
		nombre = new JTextField(15);
		controlFoco = new ControladorCamposAlta(nombre,2,this);
		nombre.addFocusListener(controlFoco);
		nombreIncorrecto = new JLabel("");
		nombreIncorrecto.setFont(letra2);
		nombreIncorrecto.setForeground(Color.RED);
		//-------DNI----------------------------------
		dni = new JTextField(8);
		controlFoco = new ControladorCamposAlta(dni,4,this);
		dni.addFocusListener(controlFoco);
		dniIncorrecto = new JLabel("");
		dniIncorrecto.setFont(letra2);;
		dniIncorrecto.setForeground(Color.RED);
		//---------------------EMAIL----------------------------------
		email= new JTextField(40);
		email.setText("ejemplo@ejemplo.com.ar");
		controlFoco = new ControladorCamposAlta(email,1,this);
		email.addFocusListener(controlFoco);
		emailIncorrecto = new JLabel("");
		emailIncorrecto.setFont(letra2);;
		emailIncorrecto.setForeground(Color.RED);
		// ------GENERO----------------------------------
		sexo = new JComboBox();
		sexo.setEditable(false);
		sexo.addItem("FEMENINE");
		sexo.addItem("MASCULINE");
		sexo.addItem("OTHER");
		// ------ESTADO CIVIL---------------------------
		estadoCivil = new JComboBox();
		estadoCivil.setEditable(false);
		estadoCivil.addItem("MARRIED");
		estadoCivil.addItem("SINGLE");
		estadoCivil.addItem("DIVORCED");
		// -------COBERTURA MEDICA-------------------------
		coberturaMedica = new JComboBox();
		coberturaMedica.setEditable(false);
		coberturaMedica.addItem("NINGUNA");
		// -----------------Fecha de Nacimiento----------------------
		model = new UtilDateModel();
		model.setDate(1990, 8, 24);// Fecha inicial en el calendario.
		model.setSelected(true);
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		JDatePickerImpl fechaNacimiento = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		// --------------------Se agregan a la lamina los campos-------------------------
		lamina_superior.add(new JLabel("           Apellido"));
		lamina_superior.add(apellido);
		lamina_superior.add(apellidoIncorrecto);
		lamina_superior.add(new JLabel("           Nombre"));
		lamina_superior.add(nombre);
		lamina_superior.add(nombreIncorrecto);
		lamina_superior.add(new JLabel("           DNI"));
		lamina_superior.add(dni);
		lamina_superior.add(dniIncorrecto);
		lamina_superior.add(new JLabel("           EMAIL"));
		lamina_superior.add(email);
		lamina_superior.add(emailIncorrecto);
		lamina_superior.add(new JLabel("         Fecha de Nacimiento"));
		lamina_superior.add(fechaNacimiento);
		lamina_superior.add(new JLabel("         "));
		lamina_superior.add(new JLabel("           Genero"));
		lamina_superior.add(sexo);
		lamina_superior.add(new JLabel("         "));
		lamina_superior.add(new JLabel("           Estado civil"));
		lamina_superior.add(estadoCivil);
		lamina_superior.add(new JLabel("         "));
		lamina_superior.add(new JLabel("           Cobertura Medica"));
		lamina_superior.add(coberturaMedica);
		// ------------Mensaje de estado de carga de datos en la BBDD ---------------
		datosCargados = new JLabel("");
		Font letra = new Font("Seif",Font.PLAIN,20);
		datosCargados.setFont(letra);;
		lamina_centro.add(datosCargados);
		// ----------Boton para enviar consulta de busqueda a la base de datos----
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

	public String getDni() {
		return dni.getText();
	}
	public String getDniString() {
		return dni.getText();
	}

	public void setCoberturaMedica(String cobertura) {
		this.coberturaMedica.addItem(cobertura);
	}

	public String getFechaNacimiento() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(model.getValue());
	}

	public String getSexo() {
		return sexo.getSelectedItem().toString();
	}
	public String getCoberturaMedica() {
		return coberturaMedica.getSelectedItem().toString();
	}
	public void clearInlet() {
		apellido.setText("");
		nombre.setText("");
		dni.setText("");
		email.setText("");
	}

	public void setDatosCargados(String estadoDatos) {
		this.datosCargados.setText(estadoDatos);
	}

	public String getEmail() {
		return email.getText();
	}

	public void setEmailIncorrecto(String error) {
		this.emailIncorrecto.setText(error);
	}
	public void setApellidoIncorrecto(String error) {
		this.apellidoIncorrecto.setText(error);
	}
	public void setNombreIncorrecto(String error) {
		this.nombreIncorrecto.setText(error);
	}
	public void setDniIncorrecto(String error) {
		this.dniIncorrecto.setText(error);
	}
	
	public boolean dniYaCargado(String dniInput) {

		for (String element : dniLista) {
			if (element.contains(dniInput)) {
				return true;
			}
		}
		return false;
	}

	private JTextField dni;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField email;
	private JDatePickerImpl fechaNacimiento;
	private UtilDateModel model;
	private JComboBox estadoCivil, sexo, coberturaMedica;
	private JLabel datosCargados;
	private JLabel emailIncorrecto;
	private JLabel nombreIncorrecto;
	private JLabel apellidoIncorrecto;
	private JLabel dniIncorrecto;
	private ControladorCamposAlta controlFoco;
	private Font letra2 = new Font("Seif",Font.PLAIN,14);
	private ArrayList<String> dniLista;

}
