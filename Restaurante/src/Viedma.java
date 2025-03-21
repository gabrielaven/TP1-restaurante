class Viedma implements TarjetaCredito {
    @Override
    public double aplicarDescuento(double totalBebidas, double totalComidas) {
        return totalBebidas + totalComidas;
    }
}