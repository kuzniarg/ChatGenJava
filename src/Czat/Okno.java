/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Czat;

import static Czat.Rozmowa.botPrzywitanie;
import static Czat.Rozmowa.wyslijWiadomosc;
import java.util.ArrayList;
import javax.swing.JFileChooser;

/**
 *
 * @author Grzechu
 */
public class Okno extends javax.swing.JFrame {

    boolean pierwszyTekst = true;
    JFileChooser fc;

    public static void main(String args[]) {
        Baza.baza = new ArrayList<>();
        Statystyka.statystyka = new ArrayList<>();
        Okno oknoCzatu = new Okno();
        tekstCzat.setText(botPrzywitanie());
        tekstWpisz.setText("Wpisz tekst");
    }

    public Okno() {
        initComponents();
        initOkno();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        tekstCzat = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tekstWpisz = new javax.swing.JTextArea();
        wyslijButton = new javax.swing.JButton();
        dodajPlikButton = new javax.swing.JButton();
        progresStaty1 = new javax.swing.JProgressBar();
        progresStaty2 = new javax.swing.JProgressBar();
        progresStaty3 = new javax.swing.JProgressBar();
        statystyka = new java.awt.Label();
        jScrollPane4 = new javax.swing.JScrollPane();
        wyrazStaty1 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        wyrazStaty2 = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        wyrazStaty3 = new javax.swing.JTextArea();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Symulator czatu");
        setMinimumSize(new java.awt.Dimension(10, 10));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tekstCzat.setColumns(20);
        tekstCzat.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        tekstCzat.setLineWrap(true);
        tekstCzat.setRows(5);
        tekstCzat.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tekstCzat.setEnabled(false);
        jScrollPane1.setViewportView(tekstCzat);
        tekstCzat.setWrapStyleWord(true);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tekstWpisz.setColumns(20);
        tekstWpisz.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        tekstWpisz.setLineWrap(true);
        tekstWpisz.setRows(5);
        tekstWpisz.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tekstWpiszMousePressed(evt);
            }
        });
        tekstWpisz.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tekstWpiszKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(tekstWpisz);

        wyslijButton.setText("Wyślij");
        wyslijButton.setMaximumSize(new java.awt.Dimension(80, 25));
        wyslijButton.setMinimumSize(new java.awt.Dimension(80, 25));
        wyslijButton.setPreferredSize(new java.awt.Dimension(80, 25));
        wyslijButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wyslijButtonActionPerformed(evt);
            }
        });

        dodajPlikButton.setText("Dodaj plik tekstowy");
        dodajPlikButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodajPlikButtonActionPerformed(evt);
            }
        });

        progresStaty1.setStringPainted(true);

        progresStaty2.setStringPainted(true);

        progresStaty3.setStringPainted(true);

        statystyka.setAlignment(java.awt.Label.CENTER);
        statystyka.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        statystyka.setText("Statystyka");

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane4.setPreferredSize(new java.awt.Dimension(280, 100));

        wyrazStaty1.setColumns(20);
        wyrazStaty1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        wyrazStaty1.setRows(5);
        wyrazStaty1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        wyrazStaty1.setEnabled(false);
        jScrollPane4.setViewportView(wyrazStaty1);

        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane5.setPreferredSize(new java.awt.Dimension(280, 100));
        jScrollPane5.setRequestFocusEnabled(false);

        wyrazStaty2.setColumns(20);
        wyrazStaty2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        wyrazStaty2.setRows(5);
        wyrazStaty2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        wyrazStaty2.setEnabled(false);
        jScrollPane5.setViewportView(wyrazStaty2);

        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane6.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane6.setPreferredSize(new java.awt.Dimension(280, 100));

        wyrazStaty3.setColumns(20);
        wyrazStaty3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        wyrazStaty3.setRows(5);
        wyrazStaty3.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        wyrazStaty3.setEnabled(false);
        jScrollPane6.setViewportView(wyrazStaty3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(dodajPlikButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(wyslijButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(progresStaty1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(progresStaty2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(progresStaty3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(statystyka, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dodajPlikButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statystyka, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(progresStaty1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(progresStaty2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(progresStaty3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(wyslijButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void wyslijButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wyslijButtonActionPerformed
        tekstCzat.setText(wyslijWiadomosc(tekstWpisz.getText()));
        tekstWpisz.setText(null);
    }//GEN-LAST:event_wyslijButtonActionPerformed

    private void tekstWpiszMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tekstWpiszMousePressed
        if (pierwszyTekst) {
            tekstWpisz.setText(null);
            pierwszyTekst = false;
        }
    }//GEN-LAST:event_tekstWpiszMousePressed

    private void tekstWpiszKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tekstWpiszKeyTyped
        if (evt.getKeyChar() == '\n'){
            wyslijButton.doClick();
        }

    }//GEN-LAST:event_tekstWpiszKeyTyped

    private void dodajPlikButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodajPlikButtonActionPerformed
        OknoPlik.main(null);
    }//GEN-LAST:event_dodajPlikButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dodajPlikButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea jTextArea1;
    public static javax.swing.JProgressBar progresStaty1;
    public static javax.swing.JProgressBar progresStaty2;
    public static javax.swing.JProgressBar progresStaty3;
    public static java.awt.Label statystyka;
    public static javax.swing.JTextArea tekstCzat;
    public static javax.swing.JTextArea tekstWpisz;
    public static javax.swing.JTextArea wyrazStaty1;
    public static javax.swing.JTextArea wyrazStaty2;
    public static javax.swing.JTextArea wyrazStaty3;
    private javax.swing.JButton wyslijButton;
    // End of variables declaration//GEN-END:variables

    private void initOkno() {
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
