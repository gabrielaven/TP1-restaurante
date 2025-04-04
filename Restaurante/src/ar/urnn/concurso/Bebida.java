package ar.urnn.concurso;
public class Bebida {
    private final String nombre;
    private final double precio;
    private final int cantidad;

    public Bebida(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public double calcularSubtotal() {
        return precio * cantidad;
    }
}
