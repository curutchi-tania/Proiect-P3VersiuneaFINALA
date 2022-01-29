/**
 * @author      Curutchi Tania-Maria <tania.curutchi01@e-uvt.com>
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class FrameClienti {
    private JFrame clientiFrame;
    private DealershipDatabase db;
    private JPanel clientiPanel;

    /**
     * Realizarea interfetei grafice corespunzatoare clientilor
     * <p>
     * Metoda contine crearea panoului pentru clienti si
     * preluarea listei de clienti din baza de date.
     */

    private void displayClientsPage() {
        clientiPanel = new JPanel();
        clientiPanel.setLayout(new BoxLayout(clientiPanel, BoxLayout.PAGE_AXIS));
        clientiPanel.setPreferredSize(new Dimension(800, 400));


        JLabel clientsDescription = new JLabel("Lista clientilor");
        clientiPanel.add(clientsDescription);

        List<Client> clienti = db.getClienti();

        for (Client client : clienti) {
            JPanel clientPanel = new JPanel();

            clientPanel.setMaximumSize(new Dimension(300, 50));

            JLabel nume = new JLabel(client.getNume());
            clientPanel.add(nume);

            JLabel prenume = new JLabel(client.getPrenume());
            clientPanel.add(prenume);

            clientiPanel.add(clientPanel);
        }
        clientiFrame.getContentPane().add(clientiPanel);
    }

    /**
     * Conectarea cu baza de date.
     */
    public void runClienti() {
        db = new DealershipDatabase();
        db.connect();
        clientiFrame = new JFrame("Clienti");
        clientiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clientiFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                db.closeConnection();
            }
        });
        displayClientsPage();
        clientiFrame.pack();
        clientiFrame.setLocationRelativeTo(null);
        clientiFrame.setVisible(true);
    }
}