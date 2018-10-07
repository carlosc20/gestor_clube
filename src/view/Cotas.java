package view;

import model.AlunoNaoExisteException;
import model.FacadeModel;

import javax.swing.*;

public class Cotas extends JFrame {

    private JPanel panel1;
    private FacadeModel modelFacade;

    public Cotas(int numero) {
        super("Cotas");
        this.add(panel1);
        this.setSize(200,200);
        this.setVisible(true);

        modelFacade = FacadeModel.getInstance();
        JLabel label = new JLabel();
        try {
            String nome = modelFacade.getAlunoNome(numero);
            label.setText(nome);
        } catch (AlunoNaoExisteException e) {
            this.setVisible(false);
            this.dispose();
        }

        this.add(label);
    }
}