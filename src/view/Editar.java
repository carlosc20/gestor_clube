package view;

import model.AlunoNaoExisteException;
import model.FacadeModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;

public class Editar extends JFrame {

    private FacadeModel modelFacade;
    private JPanel mainPanel;
    private JTextField textFieldNome;
    private JTextField textFieldNumero;
    private JButton cancelarButton;
    private JButton confirmarButton;
    private JButton cotasButton;

    private JFrame isto;
    private Cotas cotasFrame;

    private int naluno;

    public Editar(int numero) {
        super("Editar");
        this.add(mainPanel);
        this.setSize(400,200);
        this.setVisible(true);

        isto = this;
        naluno = numero;

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

                String novoNome = textFieldNome.getText();

                if (!novoNome.equals("")) {
                    System.out.println(novoNome);
                    try {
                        modelFacade.editAluno(novoNome, naluno, "", LocalDate.now(), "");
                        isto.dispose();
                    } catch (IOException i) {
                        JOptionPane.showMessageDialog(isto, "Não foi possível guardar.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(isto, "É necessário preencher todos os campos.", "Erro", JOptionPane.WARNING_MESSAGE);
                }
            }

        });

        cotasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cotasFrame != null && cotasFrame.isDisplayable()) { //se já existe, tras para a frente
                    cotasFrame.toFront();
                } else {
                    cotasFrame = new Cotas(naluno);
                }
            }
        });
    }
}