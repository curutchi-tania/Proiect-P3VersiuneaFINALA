/**
 * @author      Curutchi Tania-Maria <tania.curutchi01@e-uvt.com>
 */
import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class Application {
    private JFrame frame;
    private JPanel mainPanel;
    private DealershipDatabase db;

    /**
     * Crearea panoului central cu masini
     * <p>
     * Interfata corespunzatoare masinilor si caracteristicilor acestora
     * aici se creaza panourile si butoanele corespunzatoare pentru
     * afisarea masinilor si optiunilor asociate acestora.
     * <p>
     * In cadrul acestui panou masinile pot fi cautate dupa anumite
     * criterii, selectate si ordonate in functie de pret
     */
    private void displayCarsPage() {
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
        container.setPreferredSize(new Dimension(800,400));

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.setPreferredSize(new Dimension(800,400));

//        JLabel dealershipTitle = new JLabel("Cars");
//        mainPanel.add(dealershipTitle);

        JLabel carDescription = new JLabel("Select a car to view more info");
        mainPanel.add(carDescription);

        List<Masina> masini = db.getMasini();

        final JPanel masinaPanel = new JPanel();

        final JButton backButton = new JButton();
        backButton.setText("Back");

        //masinaPanel.setBackground(Color.red);

        JLabel masinaPanelMarca = new JLabel();
        masinaPanel.add(masinaPanelMarca);

        JLabel masinaPanelDescriere = new JLabel();
        masinaPanel.add(masinaPanelDescriere);

        JLabel masinaPanelAn = new JLabel();
        masinaPanel.add(masinaPanelAn);

        JLabel masinaPanelKilometraj = new JLabel();
        masinaPanel.add(masinaPanelKilometraj);

        JLabel masinaPanelCuloare = new JLabel();
        masinaPanel.add(masinaPanelCuloare);

        JLabel masinaPanelPret = new JLabel();
        masinaPanel.add(masinaPanelPret);

        masinaPanel.add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                masinaPanel.setVisible(false);
                mainPanel.setVisible(true);
            }
        });

        masinaPanel.setLayout(new BoxLayout(masinaPanel, BoxLayout.PAGE_AXIS));
        masinaPanel.setPreferredSize(new Dimension(800,400));
        masinaPanel.setVisible(false);
        mainPanel.setVisible(true);

        JTable masiniTable = new JTable();
        JTextField search = new JTextField();
        mainPanel.add(search);
        JButton searchButton = new JButton("Search");
        mainPanel.add(searchButton);
        List<Masina> filtruMasini = new ArrayList<>(masini);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtruMasini.clear();
                filtruMasini.addAll(masini.stream()
                                .filter(m -> {
                                    String mString = m.getMarca() + m.getAn() + m.getCuloare() +
                                            m.getDescriere() + m.getPret() + m.getKilometraj();
                                    return mString.toLowerCase().contains(search.getText().toLowerCase().trim());
                                })
                        .toList());
                masiniTable.repaint();
            }
        });
        JButton sortButton = new JButton("Sort by ascending price");
        mainPanel.add(sortButton);
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MaxHeap<Masina> m = new MaxHeap<>(filtruMasini, new Comparator<Masina>() {
                    @Override
                    public int compare(Masina o1, Masina o2) {
                        return Float.compare(o1.getPret(), o2.getPret());
                    }
                });
                filtruMasini.clear();
                filtruMasini.addAll(m.sort());
                masiniTable.repaint();
            }
        });

        JButton sortButton2 = new JButton("Sort by descending price");
        mainPanel.add(sortButton2);
        sortButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MaxHeap<Masina> m = new MaxHeap<>(filtruMasini, new Comparator<Masina>() {
                    @Override
                    public int compare(Masina o1, Masina o2) {
                        return Float.compare(o2.getPret(), o1.getPret());
                    }
                });
                filtruMasini.clear();
                filtruMasini.addAll(m.sort());
                masiniTable.repaint();
            }
        });

        JScrollPane scrollPane = new JScrollPane(masiniTable);
        masiniTable.setFillsViewportHeight(true);
        String[] columNames = {"Nr.", "Marca", "Descriere", "Pret"};
        masiniTable.setModel(new DefaultTableModel(new Object[][]{}, columNames) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }

            @Override
            public int getRowCount() {
                return filtruMasini.size();
            }

            @Override
            public Object getValueAt(int row, int column) {
                return switch (column) {
                    case 0 -> row + 1;
                    case 1 -> filtruMasini.get(row).getMarca();
                    case 2 -> filtruMasini.get(row).getDescriere();
                    case 3 -> filtruMasini.get(row).getPret();
                    default -> "undefined";
                };
            }
        });
        // masiniTable.setAutoCreateRowSorter(true);
        masiniTable.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table = (JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    Masina masina = filtruMasini.get(row);
                    masinaPanelMarca.setText(masina.getMarca());
                    masinaPanelDescriere.setText(masina.getDescriere());
                    masinaPanelAn.setText("Anul fabricatiei: " + masina.getAn());
                    masinaPanelKilometraj.setText("Kilometraj: " + masina.getKilometraj() + " km");
                    masinaPanelCuloare.setText("Culoare: " + masina.getCuloare());
                    masinaPanelPret.setText("Pret: " + masina.getPret() + " euro");

                    masinaPanel.setVisible(true);
                    mainPanel.setVisible(false);
                }
            }
        });
        mainPanel.add(scrollPane);

//        for (Masina masina : masini) {
//            JButton masinaButton = new JButton();
//
//            masinaButton.setMaximumSize(new Dimension(300, 50));
//
//            JButton marca_si_descriere = new JButton(masina.getMarca() + " " + masina.getDescriere());
//            masinaButton.add(marca_si_descriere);
//
//            marca_si_descriere.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    masinaPanelMarca.setText(masina.getMarca());
//                    masinaPanelDescriere.setText(masina.getDescriere());
//                    masinaPanelAn.setText("Anul fabricatiei: " + masina.getAn());
//                    masinaPanelKilometraj.setText("Kilometraj: " + masina.getKilometraj() + " km");
//                    masinaPanelCuloare.setText("Culoare: " + masina.getCuloare());
//                    masinaPanelPret.setText("Pret: " + masina.getPret() + " euro");
//
//                    masinaPanel.setVisible(true);
//                    mainPanel.setVisible(false);
//                }
//            });
//            mainPanel.add(masinaButton);
//        }
        frame.getContentPane().add(container);
        container.add(mainPanel);
        container.add(masinaPanel);
    }

    /**
     * Conectarea cu baza de date.
     */
    public void run() {
        db = new DealershipDatabase();
        db.connect();
        frame = new JFrame("Dealership");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                db.closeConnection();
            }
        });
        displayCarsPage();

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
