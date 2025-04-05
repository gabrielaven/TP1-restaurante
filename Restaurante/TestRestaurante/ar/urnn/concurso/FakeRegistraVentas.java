package ar.urnn.concurso;

public class FakeRegistraVentas implements RegistroVenta {
    private final ProveedorDeFecha proveedor;
    private String registro;

    public FakeRegistraVentas(ProveedorDeFecha proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public void registrarVenta(double montoTotal) {
        String fecha = proveedor.obtenerFecha();
        registro = fecha + " || " + String.format("%.2f", montoTotal) + System.lineSeparator();
    }

    public String data() {
        return registro;
    }
}
