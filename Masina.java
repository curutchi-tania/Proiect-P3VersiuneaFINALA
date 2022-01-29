/**
 * @author      Curutchi Tania-Maria <tania.curutchi01@e-uvt.com>
 */
public class Masina {
    private int id;
    private String marca;
    private int an;
    private float kilometraj;
    private float pret;
    private String culoare;
    private String descriere;

    public Masina(String marca, int an, float kilometraj, float pret, String culoare, String descriere) {
        this(-1, marca, an, kilometraj, pret, culoare, descriere);
    }

    /**
     * Constructor pentru clasa Masina.
     * @param id, marca, an, kilometraj, pret, culoare, descriere
     */

    public Masina(int id, String marca, int an, float kilometraj, float pret, String culoare, String descriere) {
        this.id = id;
        this.marca = marca;
        this.an = an;
        this.kilometraj = kilometraj;
        this.pret = pret;
        this.culoare = culoare;
        this.descriere = descriere;
    }

    /**
     * Getter pentru id-ul masinii.
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter pentru id-ul masinii.
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter pentru marca masinii.
     * @return marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Setter pentru marca masinii.
     * @param marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Getter pentru anul masinii.
     * @return an
     */
    public int getAn() {
        return an;
    }

    /**
     * Setter pentru anul masinii.
     * @param an
     */
    public void setAn(int an) {
        this.an = an;
    }

    /**
     * Getter pentru kilometrajul masinii.
     * @return kilometraj
     */
    public float getKilometraj() {
        return kilometraj;
    }

    /**
     * Setter pentru kilometrajul masinii.
     * @param kilometraj
     */
    public void setKilometraj(float kilometraj) {
        this.kilometraj = kilometraj;
    }

    /**
     * Getter pentru pretul masinii.
     * @return pret
     */
    public float getPret() {
        return pret;
    }

    /**
     * Setter pentru pretul masinii.
     * @param pret
     */
    public void setPret(float pret) {
        this.pret = pret;
    }

    /**
     * Getter pentru culoarea masinii.
     * @return culoare
     */
    public String getCuloare() {
        return culoare;
    }

    /**
     * Setter pentru culoarea masinii.
     * @param culoare
     */
    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    /**
     * Getter pentru descrierea masinii.
     * @return descriere
     */
    public String getDescriere() {
        return descriere;
    }

    /**
     * Setter pentru descrierea masinii.
     * @param descriere
     */
    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    /**
     * Metoda toString().
     */
    @Override
    public String toString() {
        return "Masina{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", an=" + an +
                ", kilometraj=" + kilometraj +
                ", pret=" + pret +
                ", culoare='" + culoare + '\'' +
                ", descriere='" + descriere + '\'' +
                '}';
    }
}
