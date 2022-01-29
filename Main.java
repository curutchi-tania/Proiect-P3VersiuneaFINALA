/**
 * @author      Curutchi Tania-Maria <tania.curutchi01@e-uvt.com>
 */
public class Main {
    public static void main(String[] args) {
        /**
         * Metoda main.
         */
        //DealershipDatabase db = new DealershipDatabase();
        //db.connect();
        //Client client = new Client("Maria", "Ionescu");
        //db.insertClient(client);
        //Masina masina = new Masina("Volkswagen", 2017, 34100, 19900, "negru", "Passat 1.4 150CP benzina");
        //db.insertMasina(masina);
        //Comanda comanda = new Comanda(2, StatusPlata.ANULAT, 1, 3);
        //db.insertComanda(comanda);

        FrameClienti frameClienti = new FrameClienti();
        frameClienti.runClienti();

        //FrameComenzi frameComenzi = new FrameComenzi();
        //frameComenzi.runComenzi();

        //Application application = new Application();
        //application.run();
    }
}
