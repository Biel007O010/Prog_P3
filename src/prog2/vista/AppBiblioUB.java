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
                gestioPrestecsFinestra finestraPrestecs = new gestioPrestecsFinestra(adaptador);
                finestraPrestecs.setVisible(true);
            }
        });

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser escollirArchiu = new JFileChooser();
                escollirArchiu.setDialogTitle("Guardar datos de la biblioteca");

                int seleccio = escollirArchiu.showSaveDialog(AppBiblioUB.this);

                if(seleccio == JFileChooser.APPROVE_OPTION){
                    java.io.File fitxer = escollirArchiu.getSelectedFile();
                    String ruta = fitxer.getAbsolutePath();

                    try{
                        adaptador.guardaDades(ruta);

                        JOptionPane.showMessageDialog(AppBiblioUB.this,
                                "Dades guardades correctament a: \n" + ruta,
                                "Èxito",
                                JOptionPane.INFORMATION_MESSAGE);
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(AppBiblioUB.this,
                                "Error al guardar el fitxer: " + ex.getMessage(),
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        carregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser escollirArxiu = new JFileChooser();
                escollirArxiu.setDialogTitle("Cargar dades de la biblioteca");

                int selecio = escollirArxiu.showOpenDialog(AppBiblioUB.this);

                if(selecio == JFileChooser.APPROVE_OPTION){
                    java.io.File arxiu = escollirArxiu.getSelectedFile();
                    String ruta = arxiu.getAbsolutePath();

                    try{
                        adaptador.carregaDades(ruta);

                        JOptionPane.showMessageDialog(AppBiblioUB.this,
                                "Dades carregats correctament desde: \n" + ruta,
                                "Éxito",
                                JOptionPane.INFORMATION_MESSAGE);
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(AppBiblioUB.this,
                                "Error al carregar el arxiu: " + ex.getMessage(),
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
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
