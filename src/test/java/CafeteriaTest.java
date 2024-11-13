import gestioncafeteria.Cafeteria;
import gestioncafeteria.Cafe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CafeteriaTest {
    private Cafeteria cafeteria;
    private Cafe cafe1;
    private Cafe cafe2;

    @BeforeEach
    void setUp() {
        List<String> redesSociales = Arrays.asList("Instagram", "Facebook");
        cafeteria = new Cafeteria("Cafetería Central", "123 Calle Principal", redesSociales);

        List<String> ingredientesCafe1 = Arrays.asList("Leche", "Crema");
        cafe1 = new Cafe("Espresso", 50, 30, "Pequeño", ingredientesCafe1);

        List<String> ingredientesCafe2 = Arrays.asList("Chocolate");
        cafe2 = new Cafe("Café Mocha", 60, 40, "Mediano", ingredientesCafe2);

        cafeteria.agregarCafe(cafe1);
        cafeteria.agregarCafe(cafe2);
    }

    @Test
    void testAgregarCafe() {
        List<String> ingredientes = Arrays.asList("Leche", "Canela");
        Cafe cafeNuevo = new Cafe("Café Latte", 70, 50, "Grande", ingredientes);
        cafeteria.agregarCafe(cafeNuevo);

        assertTrue(cafeteria.getCafes().contains(cafeNuevo));
    }

    @Test
    void testObtenerCafesPorTamaño() {
        List<Cafe> cafesPequeños = cafeteria.obtenerCafesPorTamaño("Pequeño");

        assertEquals(1, cafesPequeños.size());
        assertTrue(cafesPequeños.contains(cafe1));
    }

    @Test
    void testDescontinuarCafe() {
        boolean resultado = cafeteria.descontinuarCafe("Espresso");

        assertTrue(resultado);
        assertFalse(cafeteria.getCafes().contains(cafe1));
    }

    @Test
    void testModificarInfo() {
        List<String> nuevasRedes = Arrays.asList("Twitter", "LinkedIn");
        cafeteria.modificarInfo("Nueva Cafetería", "456 Calle Secundaria", nuevasRedes);

        assertEquals("Nueva Cafetería", cafeteria.getNombre());
        assertEquals("456 Calle Secundaria", cafeteria.getDireccion());
        assertEquals(nuevasRedes, cafeteria.getRedesSociales());
    }
}

