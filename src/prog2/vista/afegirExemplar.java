package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class afegirExemplar extends JDialog {
    private Adaptador adaptador;
    gestioExemplarsFinestra finestraAnterior;
    private JPanel panellAfegirExem;
    private JButton acceptarButton;
    private JButton cancelarButton;
    private JLabel etiquetaAutor;
    private JCheckBox admetPrestecLlargCheckBox;
    private JTextField autorField;
    private JTextField titolField;
    private JTextField idField;
    private JLabel etiquetaTitol;
    private JLabel etiquetaID;

    public afegirExemplar(Adaptador a, gestioExemplarsFinestra f){
        super(f);
        this.adaptador = a;
        this.finestraAnterior = f;
        setTitle("Afegir Exemplar");
        setContentPane(panellAfegirExem); //
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setModal(true);
        setSize(400, 300);
        setLocationRelativeTo(null);
        acceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String titol = titolField.getText();
                String autor = autorField.getText();
                boolean prestecLlarg = admetPrestecLlargCheckBox.isSelected();

                if (id.isEmpty() || titol.isEmpty() || autor.isEmpty()){
                    JOptionPane.showMessageDialog(afegirExemplar.this, "Si us plau, omple tots els camps.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                try {
                    adaptador.afegirExemplar(id, titol, autor, prestecLlarg);

                    if (afegirExemplar.this.finestraAnterior != null){
                        afegirExemplar.this.finestraAnterior.actualitzaExemplars();
                    }

                    afegirExemplar.this.dispose();
                } catch (BiblioException ex) {
                    JOptionPane.showMessageDialog(afegirExemplar.this, ex.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);                }
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                afegirExemplar.this.dispose();
            }
        });
    }
}
