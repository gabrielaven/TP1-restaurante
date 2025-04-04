package ar.urnn.concurso;
public class Comida {
    private final String nombre;
    private final double precio;
    private final int cantidad;

    public Comida(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public double calcularSubtotal() {
        return precio * cantidad;
    }
}