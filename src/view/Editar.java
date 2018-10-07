package view;

import model.AlunoNaoExisteException;
import model.FacadeModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class Editar extends JFrame {

    private FacadeModel modelFacade;
    private JPanel mainPanel;
    private JTextField textFieldNome;
    private JTextField textFieldNumero;
    private JButton cancelarButton;
    private JButton confirmarButton;

    private JFrame isto;

    public Editar(int numero) {
        super("Editar");
        this.add(mainPanel);
        this.setSize(400,200);
        this.setVisible(true);

        isto = this;

        modelFacade = FacadeModel.getInstance();
        try {
            String nome = modelFacade.getAlunoNome(numero);
            textFieldNome.setText(nome);
            textFieldNumero.setText(Integer.toString(numero));
        } catch (AlunoNaoExisteException e) {
            this.setVisible(false);
            this.dispose();
        }
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isto.dispose();
            }
        });
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: editar dados
                String novoNome = textFieldNome.getText();

            }
        });
    }
}