package prog2.vista;

import javax.swing.*;

/**
 * GUI DE L?APLICACIO
 */
public class AppBiblioUB extends JFrame {
    private JPanel panellAppBiblioUB;

    public AppBiblioUB(){
        setTitle("Prova GUI");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panellAppBiblioUB);
        setSize(500,400);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppBiblioUB prova = new AppBiblioUB();
            prova.setVisible(true);
        });
    }
}
