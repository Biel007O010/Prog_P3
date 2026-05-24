package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class retornarPrestecFinestra extends JDialog {
    private JPanel panellRetornar;
    private JList<String> llistaPendents;
    private JButton retornarButton;
    private JButton sortirButton;

    private Adaptador adaptador;
    private gestioPrestecsFinestra finestraAnterior;

    public retornarPrestecFinestra(Adaptador a, gestioPrestecsFinestra f) {
        super(f);
        this.adaptador = a;
        this.finestraAnterior = f;

        setTitle("Retornar Préstecs");
        setContentPane(panellRetornar);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setModal(true);
        setSize(450, 350);
        setLocationRelativeTo(f);

        actualitzaPendents();

        retornarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int posicionFiltrada = llistaPendents.getSelectedIndex();

                if (posicionFiltrada == -1) {
                    JOptionPane.showMessageDialog(retornarPrestecFinestra.this,
                            "Si us plau, selecciona un préstec de la llista.",
                            "Avís",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {
                    String prestecSeleccionatText = llistaPendents.getSelectedValue();
                    ArrayList<String> totsElsPrestecs = adaptador.recuperaPrestecs();

                    int posicionGlobalReal = totsElsPrestecs.indexOf(prestecSeleccionatText);

                    if (posicionGlobalReal != -1) {
                        adaptador.retornarPrestec(posicionGlobalReal);

                        actualitzaPendents();

                        JOptionPane.showMessageDialog(retornarPrestecFinestra.this,
                                "Préstec retornat correctament.",
                                "Èxit",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(retornarPrestecFinestra.this,
                                "Error al buscar la posición global del préstamo.",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }

                } catch (BiblioException ex) {
                    JOptionPane.showMessageDialog(retornarPrestecFinestra.this,
                            ex.getMessage(),
                            "Error al retornar",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        sortirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retornarPrestecFinestra.this.dispose();
            }
        });
    }

    private void actualitzaPendents() {
        DefaultListModel<String> llistaModel = new DefaultListModel<>();
        ArrayList<String> prestecsNoDevueltos = adaptador.recuperaPrestecsNoRetornats();

        if (prestecsNoDevueltos != null) {
            for (String p : prestecsNoDevueltos) {
                llistaModel.addElement(p);
            }
        }
        llistaPendents.setModel(llistaModel);
    }
}