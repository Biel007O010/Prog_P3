package prog2.vista;

import prog2.adaptador.Adaptador;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class gestioPrestecsFinestra extends JFrame {
    private JPanel panellGestioPrestecs;
    private JScrollPane panellPrestecsRegistrats;
    private JList<String> llistaPrestecs;
    private JButton sortirButton;
    private JButton afegirPrestec;
    private JButton retornarPrestecButton;
    private JButton noRetornatsButton;

    private Adaptador adaptador;

    private boolean mostrantNomésPendents = false;

    public gestioPrestecsFinestra(Adaptador a) {
        this.adaptador = a;

        setTitle("Gestió de Préstecs");
        setContentPane(panellGestioPrestecs);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 450);
        setLocationRelativeTo(null);
        actualitzaPrestecs();

        retornarPrestecButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int prestecSeleccionat = llistaPrestecs.getSelectedIndex();

                if (prestecSeleccionat == -1) {
                    JOptionPane.showMessageDialog(gestioPrestecsFinestra.this,
                            "Si us plau, selecciona un préstec de la llista per retornar-lo.",
                            "Avís",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {
                    int posicionGlobalReal = prestecSeleccionat;

                    if (mostrantNomésPendents) {
                        String textSeleccionat = llistaPrestecs.getSelectedValue();
                        posicionGlobalReal = adaptador.recuperaPrestecs().indexOf(textSeleccionat);
                    }

                    adaptador.retornarPrestec(posicionGlobalReal);
                    actualitzaPrestecs();

                    JOptionPane.showMessageDialog(gestioPrestecsFinestra.this,
                            "Préstec retornat correctament.",
                            "Èxit",
                            JOptionPane.INFORMATION_MESSAGE);

                } catch (BiblioException ex) {
                    JOptionPane.showMessageDialog(gestioPrestecsFinestra.this,
                            ex.getMessage(),
                            "Error al retornar",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        noRetornatsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrantNomésPendents = !mostrantNomésPendents;

                if (mostrantNomésPendents) {
                    noRetornatsButton.setText("Veure Tots");
                } else {
                    noRetornatsButton.setText("Veure No Retornats");
                }

                actualitzaPrestecs();
            }
        });

        afegirPrestec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                afegirPrestec afegirP = new afegirPrestec(adaptador, gestioPrestecsFinestra.this);
                afegirP.setVisible(true);
            }
        });

        sortirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    protected void actualitzaPrestecs() {
        DefaultListModel<String> llistaModel = new DefaultListModel<>();
        ArrayList<String> prestecsAMostrar;

        if (mostrantNomésPendents) {
            prestecsAMostrar = adaptador.recuperaPrestecsNoRetornats();
        } else {
            prestecsAMostrar = adaptador.recuperaPrestecs();
        }

        if (prestecsAMostrar != null) {
            for (String p : prestecsAMostrar) {
                llistaModel.addElement(p);
            }
        }
        llistaPrestecs.setModel(llistaModel);
    }
}