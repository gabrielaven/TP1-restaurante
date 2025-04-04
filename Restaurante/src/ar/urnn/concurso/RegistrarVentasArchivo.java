package ar.urnn.concurso;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistrarVentasArchivo implements RegistroVenta {
    private static final String RUTA_ARCHIVO = "C:\\Users\\User\\Downloads\\universidad\\objetos 2\\archivos\\ventas.txt";
    private static final Path PATH = Paths.get(RUTA_ARCHIVO);

	@Override
	public void registrarVenta(double montoTotal) {
		String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String registro = fecha + " || " + montoTotal;

        try {
            Files.write(PATH, (registro + System.lineSeparator()).getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo guardar la venta en el archivo.", e);
        }
}
}