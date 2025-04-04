package ar.urnn.concurso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrarVentasBD implements RegistroVenta {
    private ConnectionManager connectionManager;

    public RegistrarVentasBD(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public void registrarVenta(double montoTotal) {
        String sql = "INSERT INTO ventas (fecha, monto_total) VALUES (CURRENT_DATE, ?)";
        try (Connection conn = connectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, montoTotal);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar la venta en la base de datos.", e);
        }
    }
}

