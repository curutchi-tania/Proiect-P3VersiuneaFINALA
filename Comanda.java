/**
 * @author      Curutchi Tania-Maria <tania.curutchi01@e-uvt.com>
 */
import java.sql.Timestamp;
import java.time.Instant;

public class Comanda {
    private int id;
    private Timestamp data;
    private int cantitate;
    private StatusPlata status;
    private int idMasina;
    private int idClient;

    public Comanda(int cantitate, StatusPlata status, Masina masina, Client client) {
        this(-1, cantitate, status, masina, client);
    }

    public Comanda(int cantitate, StatusPlata status, int idMasina, int idClient) {
        this(-1, cantitate, status, idMasina, idClient);
    }

    public Comanda(int id, int cantitate, StatusPlata status, Masina masina, Client client) {
        this(id, cantitate, status, masina.getId(), client.getId());
    }

    public Comanda(int id, int cantitate, StatusPlata status, int idMasina, int idClient) {
        this(id, new Timestamp(Instant.now().getEpochSecond() * 1000), cantitate, status, idMasina, idClient);
    }

    /**
     * Constructor pentru clasa Comanda.
     * @param id, timestamp, cantitate, status, idMasina, idClient
     */

    public Comanda(int id, Timestamp timestamp, int cantitate, StatusPlata status, int idMasina, int idClient) {
        this.id = id;
        this.data = timestamp;
        this.cantitate = cantitate;
        this.status = status;
        this.idMasina = idMasina;
        this.idClient = idClient;
    }

    /**
     * Getter pentru id-ul comenzii.
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter pentru id-ul comenzii.
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter pentru data comenzii.
     * @return data
     */
    public Timestamp getData() {
        return data;
    }

    /**
     * Setter pentru data comenzii.
     * @param data
     */
    public void setData(Timestamp data) {
        this.data = data;
    }

    /**
     * Getter pentru cantitatea comenzii.
     * @return cantitate
     */
    public int getCantitate() {
        return cantitate;
    }

    /**
     * Setter pentru cantitatea comenzii.
     * @param cantitate
     */
    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    /**
     * Getter pentru statusul comenzii.
     * @return status
     */
    public StatusPlata getStatus() {
        return status;
    }

    /**
     * Setter pentru statusul comenzii.
     * @param status
     */
    public void setStatus(StatusPlata status) {
        this.status = status;
    }

    /**
     * Getter pentru id-ul masinii comenzii.
     * @return idMasina
     */
    public int getIdMasina() {
        return idMasina;
    }

    /**
     * Setter pentru id-ul masinii comenzii.
     * @param idMasina
     */
    public void setIdMasina(int idMasina) {
        this.idMasina = idMasina;
    }

    /**
     * Getter pentru id-ul clientului comenzii.
     * @return idClient
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     * Setter pentru id-ul clientului comenzii.
     * @param idClient
     */
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    /**
     * Metoda toString().
     */
    @Override
    public String toString() {
        return "Comanda{" +
                "id=" + id +
                ", data=" + data +
                ", cantitate=" + cantitate +
                ", status=" + status +
                ", idMasina=" + idMasina +
                ", idClient=" + idClient +
                '}';
    }
}
