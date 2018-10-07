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
    private JTextField textFieldCurso;
    private JTextField textFieldMorada;

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
            String curso = modelFacade.getAlunoCurso(numero);
            String morada = modelFacade.getAlunoMorada(numero);
            textFieldNome.setText(nome);
            textFieldNumero.setText(Integer.toString(numero));
            textFieldCurso.setText(curso);
            textFieldMorada.setText(morada);
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
                String novoCurso = textFieldCurso.getText();
                String novoMorada = textFieldMorada.getText();

                if (!novoNome.equals("")) {
                    System.out.println(novoNome);
                    try {
                        modelFacade.editAluno(novoNome, naluno, novoCurso, LocalDate.now(), novoMorada);
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