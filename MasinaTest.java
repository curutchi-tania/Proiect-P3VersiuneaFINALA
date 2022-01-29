/**
 * @author      Curutchi Tania-Maria <tania.curutchi01@e-uvt.com>
 */
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
public class MasinaTest {

    /**
     * Crearea de teste pentru masini.
     */
    @Test
    public void testMasinaGet() {
        Masina masina1 = new Masina("Audi", 2010, 90000, 10000, "rosu", "A4 2.0 190 CP diesel");
        assertEquals("Audi", masina1.getMarca());
        assertEquals("rosu", masina1.getCuloare());
        assertEquals(90000, masina1.getKilometraj());

        Masina masina2 = new Masina("Volvo", 2019, 58000, 41000, "gri", "XC60 2.0 190 CP diesel");
        assertEquals(2019, masina2.getAn());
        assertEquals("XC60 2.0 190 CP diesel", masina2.getDescriere());
    }
}