import gestioncafeteria.Cafe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CafeTest {
    private Cafe cafe;

    @BeforeEach
    public void setUp() {
        List<String> ingredientes = Arrays.asList("Leche", "Chocolate");
        cafe = new Cafe("Espresso", 20, 100, "Mediano", ingredientes);
    }

    @Test
    public void testCrearCafe() {
        assertEquals("Espresso", cafe.getNombre());
        assertEquals(20, cafe.getGramosCafe());
        assertEquals(100, cafe.getMlAgua());
        assertEquals("Mediano", cafe.getTamaño());
        assertEquals(Arrays.asList("Leche", "Chocolate"), cafe.getIngredientesOpcionales());
    }

    @Test
    public void testActualizarDetalles() {
        List<String> nuevosIngredientes = Arrays.asList("Crema", "Chocolate");
        cafe.actualizarDetalles(25, 150, "Grande", nuevosIngredientes);

        assertEquals(25, cafe.getGramosCafe());
        assertEquals(150, cafe.getMlAgua());
        assertEquals("Grande", cafe.getTamaño());
        assertEquals(nuevosIngredientes, cafe.getIngredientesOpcionales());
    }
}
