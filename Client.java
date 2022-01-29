/**
 * @author      Curutchi Tania-Maria <tania.curutchi01@e-uvt.com>
 */
public class Client {
    private int id;
    private String nume;
    private String prenume;

    /**
     * Getter pentru id-ul clientului.
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter pentru id-ul clientului.
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter pentru numele clientului.
     * @return nume
     */
    public String getNume() {
        return nume;
    }

    /**
     * Setter pentru numele clientului.
     * @param nume
     */
    public void setNume(String nume) {
        this.nume = nume;
    }

    /**
     * Getter pentru prenumele clientului.
     * @return prenume
     */
    public String getPrenume() {
        return prenume;
    }

    /**
     * Setter pentru prenumele clientului.
     * @param prenume
     */
    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public Client(String nume, String prenume) {
        this(-1, nume, prenume);
    }

    /**
     * Constructor pentru clasa Client.
     * @param id, nume, prenume
     */
    public Client(int id, String nume, String prenume) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;

    }

    /**
     * Metoda toString().
     */
    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nume='" + nume + ", prenume='" + prenume + '\'' +
                '}';
    }
}
