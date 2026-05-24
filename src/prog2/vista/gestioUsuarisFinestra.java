package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class gestioUsuarisFinestra extends JFrame{
    private JPanel panellGestioUsuaris;
    private JButton botoAfegirU;
    private JButton sortirButton;
    private JLabel etiquetaRegistre;
    private JScrollPane panellUsuarisRegistrats;
    private JList llisaUsuaris;
    private Adaptador adaptador;

    public gestioUsuarisFinestra(Adaptador a) {
        this.adaptador = a;
        setTitle("Gestió dels Usuaris");
        setContentPane(panellGestioUsuaris); //
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 300);
        setLocationRelativeTo(null);

        actualitzaUsuaris();

        sortirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestioUsuarisFinestra.this.dispose();
            }
        });
        botoAfegirU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                afegirUsuari afegir = new afegirUsuari(adaptador, gestioUsuarisFinestra.this);
                afegir.setVisible(true);
            }
        });

        actualitzaUsuaris();
    }
    public void actualitzaUsuaris(){
        DefaultListModel<String> llista = new DefaultListModel<>();
        ArrayList<String> usuariString = adaptador.recuperaUsuaris();

        for (String usuari: usuariString){
            llista.addElement(usuari);
        }

        llisaUsuaris.setModel(llista);
    }
}
