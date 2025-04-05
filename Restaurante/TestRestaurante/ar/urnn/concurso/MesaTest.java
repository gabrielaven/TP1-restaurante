package ar.urnn.concurso;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MesaTest {
    private Mesa mesa;
    private FakeRegistraVentas fakeRegistro;

    @BeforeEach
    void iniciarMesa() {
        fakeRegistro = new FakeRegistraVentas(new ProveedorDeFechaFake("27/03/2027"));
        mesa = new Mesa(1, fakeRegistro);
    }

    @Test
    void testCalculoCostoVisa() {
        mesa.agregarBebida("Coca Cola", 5.0, 2);   
        mesa.agregarComida("Milanesa", 10.0, 1);
        double total = mesa.calcularCosto(new Visa(), Propina.BAJO); 
        assertEquals(20.09, total, 0.01);

        String esperado = "27/03/2027 || 20,09" + System.lineSeparator();
        assertEquals(esperado, fakeRegistro.data());
    }

    @Test
    void testCalculoCostoMastercard() {
        mesa.agregarBebida("Fanta", 4.0, 3);           
        mesa.agregarComida("Hamburguesa", 8.0, 2); 
        double total = mesa.calcularCosto(new Mastercard(), Propina.MEDIO); 
        assertEquals(28.51, total, 0.01);

        String esperado = "27/03/2027 || 28,51" + System.lineSeparator();
        assertEquals(esperado, fakeRegistro.data());
    }

    @Test
    void testCalculoCostoComarcaPlus() {
        mesa.agregarBebida("Agua", 3.0, 1);     
        mesa.agregarComida("pizza", 7.0, 2);  
        double total = mesa.calcularCosto(new ComarcaPlus(), Propina.ALTO);
        assertEquals(17.49, total, 0.01);

        String esperado = "27/03/2027 || 17,49" + System.lineSeparator();
        assertEquals(esperado, fakeRegistro.data());
    }
}


