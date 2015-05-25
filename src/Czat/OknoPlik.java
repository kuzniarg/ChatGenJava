package Czat;

import static Czat.Pliki.wczytajPlik;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.SwingUtilities;

public class OknoPlik extends JPanel implements ActionListener {

    JButton dodajPlikButton;
    JTextArea log;
    JFileChooser fc;

    public OknoPlik() {
        super(new BorderLayout());

        log = new JTextArea(5, 20);
        log.setMargin(new Insets(5, 5, 5, 5));
        log.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(log);

        fc = new JFileChooser();

        dodajPlikButton = new JButton("Wybierz plik");
        dodajPlikButton.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(dodajPlikButton);

        add(buttonPanel, BorderLayout.PAGE_START);
        add(logScrollPane, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int pom = fc.showOpenDialog(OknoPlik.this);
        if (pom == JFileChooser.APPROVE_OPTION) {
            File plik = fc.getSelectedFile();
            log.append("Otwieranie pliku: " + plik.getName() + ".\n");
            try {
                wczytajPlik(plik);
                log.append("Dodano do bazy.");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(OknoPlik.class.getName()).log(Level.SEVERE, null, ex);
                log.append("Błąd podczas dodawania do bazy.");
            } catch (IOException ex) {
                Logger.getLogger(OknoPlik.class.getName()).log(Level.SEVERE, null, ex);
                log.append("Błąd podczas dodawania do bazy.");
            }
        }
        log.setCaretPosition(log.getDocument().getLength());
    }

    private static void initOknoPlik() {
        JFrame frame = new JFrame("Dodaj plik");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(new OknoPlik());
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public static void OknoPlikStart() {
        SwingUtilities.invokeLater(() -> {
            UIManager.put("swing.boldMetal", Boolean.FALSE);
            initOknoPlik();
        });
    }
}
