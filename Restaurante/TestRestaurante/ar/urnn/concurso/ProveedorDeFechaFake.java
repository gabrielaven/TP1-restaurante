package ar.urnn.concurso;

public class ProveedorDeFechaFake implements ProveedorDeFecha {
    private final String fecha;

    public ProveedorDeFechaFake(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String obtenerFecha() {
        return fecha;
    }
}
