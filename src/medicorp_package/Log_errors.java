package medicorp_package;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

class Log_errors {

	public void write(String error_message) {
		fechaError = new Date(System.currentTimeMillis());
		error_message = "\n" + error_message + fechaError;
		try {
			salida = new FileWriter("./src/log_error.txt", true);
			BufferedWriter error_buffer = new BufferedWriter(salida);
			error_buffer.write(error_message);
			error_buffer.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	private FileWriter salida;
	private Date fechaError;
}