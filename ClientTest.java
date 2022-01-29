/**
 * @author      Curutchi Tania-Maria <tania.curutchi01@e-uvt.com>
 */
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientTest {
    /**
     * Crearea de teste pentru clienti.
     */
    @Test
    public void testClientGet() {
        Client client1 = new Client("Tania", "Curutchi");
        assertEquals(-1, client1.getId());
        assertEquals("Tania", client1.getNume());
        assertEquals("Curutchi", client1.getPrenume());


        Client client2 = new Client(13, "ABC", "DEF");
        assertEquals(13, client2.getId());
        assertEquals("ABC", client2.getNume());
        assertEquals("DEF", client1.getPrenume());

    }
}
