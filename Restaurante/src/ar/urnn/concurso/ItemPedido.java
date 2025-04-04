package ar.urnn.concurso;

class ItemPedido {
    private final String nombre;
    private final double precio;
    private final int cantidad;
    private final boolean esBebida;

    public ItemPedido(String nombre, double precio, int cantidad, boolean esBebida) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.esBebida = esBebida;
    }

    public double calcularSubtotal() {
        return precio * cantidad;
    }
    
    public boolean esBebida() {
        return esBebida;
    }
}