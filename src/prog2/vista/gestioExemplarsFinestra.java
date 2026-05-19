package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class gestioExemplarsFinestra extends JFrame {
    private Adaptador adaptador;
    private JPanel panellGestioExemplars;
    private JButton afegirExemplarButton;
    private JButton sortirButton;
    private JScrollPane panellExemplarsRegistrats;
    private JList llistaExemplars;
    private JLabel etiquetaExemplarsRegistrats;

    public gestioExemplarsFinestra(Adaptador a) {
        this.adaptador = a;
        setTitle("Gestió dels Exemplars");
        setContentPane(panellGestioExemplars); //
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        actualitzaExemplars();

        afegirExemplarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                afegirExemplar afegirE = new afegirExemplar(adaptador, gestioExemplarsFinestra.this);
                afegirE.setVisible(true);
            }
        });

        actualitzaExemplars();

        sortirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestioExemplarsFinestra.this.dispose();
            }
        });
    }

    public void actualitzaExemplars(){
        DefaultListModel<String> llista = new DefaultListModel<>();
        ArrayList<String> llistaExem = adaptador.recuperaExemplars();

        for (String exemplar: llistaExem){
            llista.addElement(exemplar);
        }
        llistaExemplars.setModel(llista);
    }
}
