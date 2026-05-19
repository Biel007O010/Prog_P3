package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI DE L?APLICACIO
 */
public class AppBiblioUB extends JFrame {
    private Adaptador adaptador;
    private JPanel panellAppBiblioUB;
    private JButton gestioUsuarisButton;
    private JButton gestioExemplarsButton;
    private JButton gestioPrestecsButton;
    private JButton guardarButton;
    private JButton carregarButton;

    public AppBiblioUB(){
        adaptador = new Adaptador();
        setTitle("Gestió BiblioUB");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panellAppBiblioUB);
        setSize(500,400);
        setLocationRelativeTo(null);
        gestioUsuarisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestioUsuarisFinestra finestraUsuaris = new gestioUsuarisFinestra(adaptador);
                finestraUsuaris.setVisible(true);
            }
        });

        gestioExemplarsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestioExemplarsFinestra finestraExemplars = new gestioExemplarsFinestra(adaptador);
                finestraExemplars.setVisible(true);
            }
        });


        gestioPrestecsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        carregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }




    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppBiblioUB appBiblioUB = new AppBiblioUB();
            appBiblioUB.setVisible(true);
        });
    }
}
