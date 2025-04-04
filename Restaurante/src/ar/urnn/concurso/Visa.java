package ar.urnn.concurso;
class Visa implements TarjetaCredito {
    @Override
    public double aplicarDescuento(double totalBebidas, double totalComidas) {
        return (totalBebidas * 0.97) + totalComidas; 
    }
}