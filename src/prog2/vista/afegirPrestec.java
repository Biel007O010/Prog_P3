package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class afegirPrestec extends JDialog {
    private JPanel panellAfegirPrestec;
    private JComboBox<String> comboExemplars;
    private JComboBox<String> comboUsuaris;
    private JCheckBox llargCheckBox;
    private JButton acceptarButton;
    private JButton cancelarButton;
    private Adaptador adaptador;
    private gestioPrestecsFinestra finestraAnterior;

    public afegirPrestec(Adaptador a, gestioPrestecsFinestra f) {
        super(f);
        this.adaptador = a;
        this.finestraAnterior = f;

        setTitle("Afegir Nou Préstec");
        setContentPane(panellAfegirPrestec);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setModal(true);
        setSize(450, 300);
        setLocationRelativeTo(f);

        omplirDesplegables();

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                afegirPrestec.this.dispose();
            }
        });

        acceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int exemplarPos = comboExemplars.getSelectedIndex();
                int userPos = comboUsuaris.getSelectedIndex();
                boolean esLlarg = llargCheckBox.isSelected();

                if (exemplarPos < -1 || userPos < -1) {
                    JOptionPane.showMessageDialog(afegirPrestec.this,
                            "Has de seleccionar un usuari i un exemplar vàlid.",
                            "Error de selecció",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {

                    adaptador.afegirPrestec(exemplarPos, userPos, esLlarg);

                    if (afegirPrestec.this.finestraAnterior != null) {
                        afegirPrestec.this.finestraAnterior.actualitzaPrestecs();
                    }

                    afegirPrestec.this.dispose();

                } catch (BiblioException ex) {
                    JOptionPane.showMessageDialog(afegirPrestec.this,
                            ex.getMessage(),
                            "Error en afegir el préstec",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void omplirDesplegables() {
        ArrayList<String> exemplars = adaptador.recuperaExemplars();
        if (exemplars != null) {
            for (String ex : exemplars) {
                comboExemplars.addItem(ex);
            }
        }
        ArrayList<String> usuaris = adaptador.recuperaUsuaris();
        if (usuaris != null) {
            for (String u : usuaris) {
                comboUsuaris.addItem(u);
            }
        }
    }
}