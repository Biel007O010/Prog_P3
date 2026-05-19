package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class afegirUsuari extends JFrame {
    private JPanel panellAfegirUsuari;
    private JButton acceptarButton;
    private JButton cancelarButton;
    private JLabel etiquetaEmail;
    private JCheckBox estudiantCheckBox;
    private JTextField adrecaField;
    private JTextField emailField;
    private JTextField nomField;
    private JLabel etiquetaNom;
    private JLabel etiquetaAdreca;
    private Adaptador adaptador;
    private gestioUsuarisFinestra finestraAnterior;

    public afegirUsuari(Adaptador a, gestioUsuarisFinestra f){
        this.adaptador = a;
        this.finestraAnterior = f;
        setTitle("Afegir Usuari");
        setContentPane(panellAfegirUsuari);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                afegirUsuari.this.dispose();
            }
        });
        acceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nom = nomField.getText();
                String email = emailField.getText();
                String adreca = adrecaField.getText();
                boolean esEstudiant = estudiantCheckBox.isSelected();

                if (nom.isEmpty() || email.isEmpty() || adreca.isEmpty()){
                    JOptionPane.showMessageDialog(afegirUsuari.this, "Si us plau, omple tots els camps.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    adaptador.afegirUsuari(email, nom, adreca, esEstudiant);

                    if (afegirUsuari.this.finestraAnterior != null){
                        afegirUsuari.this.finestraAnterior.actualitzaUsuaris();
                    }

                    afegirUsuari.this.dispose();
                } catch (BiblioException ex) {
                    JOptionPane.showMessageDialog(afegirUsuari.this, ex.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
