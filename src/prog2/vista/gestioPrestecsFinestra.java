package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class gestioPrestecsFinestra extends JFrame{
    private JPanel panellGestioFinestra;
    private JButton botoAfegirP;
    private JButton sortirButton;
    private JLabel etiquetaRegistre;
    private JScrollPane panellPrestecsRegistrats;
    private JList llistaPrestecs;
    private Adaptador adaptador;
    private JPanel panellGestioPrestecs;
    private JButton afegirPrestec;

    public gestioPrestecsFinestra(Adaptador a) {
        this.adaptador = a;
        setTitle("Gestió dels Préstecs");
        setContentPane(panellGestioFinestra); //
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        actualitzaPrestecs();

        sortirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestioPrestecsFinestra.this.dispose();
            }
        });
        botoAfegirP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                afegirPrestec afegir = new afegirPrestec(adaptador, gestioPrestecsFinestra.this);
                afegir.setVisible(true);
            }
        });

        actualitzaPrestecs();
    }
    public void actualitzaPrestecs(){
        DefaultListModel<String> llista = new DefaultListModel<>();
        ArrayList<String> prestecsString = adaptador.recuperaPrestecs();

        for (String prestec: prestecsString){
            llista.addElement(prestec);
        }

        llistaPrestecs.setModel(llista);
    }
}