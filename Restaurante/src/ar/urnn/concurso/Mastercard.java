package ar.urnn.concurso;
class Mastercard implements TarjetaCredito {
    @Override
    public double aplicarDescuento(double totalBebidas, double totalComidas) {
        return totalBebidas + (totalComidas * 0.98); 
    }
}
