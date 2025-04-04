package ar.urnn.concurso;

public class Main {
    public static void main(String[] args) {
        RegistroVenta registroArchivo = new RegistrarVentasArchivo();
        Mesa mesaArchivo = new Mesa(1, registroArchivo);
        mesaArchivo.agregarBebida("Coca Cola", 3000.0, 2);
        mesaArchivo.agregarComida("Milanesa", 10000.0, 1);
        mesaArchivo.calcularCosto(new Visa(), Propina.MEDIO);
           
        try {
            ConnectionManager connectionManager = new ConnectionManager();
            RegistroVenta registroBD = new RegistrarVentasBD(connectionManager);
            Mesa mesaBD = new Mesa(2, registroBD);
            mesaBD.agregarBebida("Sprite", 4.5, 1);
            mesaBD.agregarComida("Hamburguesa", 8.0, 2);
            mesaBD.calcularCosto(new Mastercard(), Propina.ALTO);
            connectionManager.closeConnection();
        } catch (Exception e) {
            System.out.println("Error de conexión con la base de datos: " + e.getMessage());
        }
    }
}
