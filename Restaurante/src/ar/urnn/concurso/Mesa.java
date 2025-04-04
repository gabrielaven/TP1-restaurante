package ar.urnn.concurso;
import java.util.ArrayList;
import java.util.List;


public class Mesa {
	private final int numero;
    private final List<Bebida> bebidas;
    private final List<Comida> comidas;
    private final RegistroVenta registro;

    public Mesa(int numero, RegistroVenta registro) {
        this.numero = numero;
        this.bebidas = new ArrayList<>();
        this.comidas = new ArrayList<>();
		this.registro = registro;
    }

    public void agregarBebida(String nombre, double precio, int cantidad) {
        bebidas.add(new Bebida(nombre, precio, cantidad));
    }

    public void agregarComida(String nombre, double precio, int cantidad) {
        comidas.add(new Comida(nombre, precio, cantidad));
    }

    public double calcularCosto(TarjetaCredito tarjeta, Propina propina) {
        double totalBebidas = bebidas.stream().mapToDouble(Bebida::calcularSubtotal).sum();
        double totalComidas = comidas.stream().mapToDouble(Comida::calcularSubtotal).sum();
        double totalConDescuento = tarjeta.aplicarDescuento(totalBebidas, totalComidas);
        registro.registrarVenta(totalConDescuento);
        return totalConDescuento + (totalConDescuento * propina.porcentaje());
    }
    
}

