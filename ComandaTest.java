/**
 * @author      Curutchi Tania-Maria <tania.curutchi01@e-uvt.com>
 */
import org.junit.Test;
import java.sql.Timestamp;
import static org.junit.jupiter.api.Assertions.*;

public class ComandaTest {
    /**
     * Crearea de teste pentru comenzi.
     */
    @Test
    public void testComandaGet() {
        Comanda comanda1 = new Comanda(1, Timestamp.valueOf("2021-12-27 17:36:27"), 1, StatusPlata.ANULAT, 10, 3);
        assertEquals(1, comanda1.getId());
        assertEquals(10, comanda1.getIdMasina());
        assertEquals(3, comanda1.getIdClient());

        Comanda comanda2 = new Comanda(2, Timestamp.valueOf("2021-10-11 00:00:00"), 1, StatusPlata.IN_ASTEPTARE, 11, 5);
        assertEquals(StatusPlata.IN_ASTEPTARE, comanda2.getStatus());
        assertEquals(11, comanda2.getIdMasina());
    }
}