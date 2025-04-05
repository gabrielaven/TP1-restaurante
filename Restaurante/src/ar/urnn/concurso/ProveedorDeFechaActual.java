package ar.urnn.concurso;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProveedorDeFechaActual implements ProveedorDeFecha {
    @Override
    public String obtenerFecha() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
