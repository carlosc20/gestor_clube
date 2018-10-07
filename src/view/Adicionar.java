package view;

import model.AlunoJaExisteException;
import model.FacadeModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;

public class Adicionar extends JFrame{

    private JTextField textFieldNome;
    private JTextField textFieldNumero;
    private JButton cancelarButton;
    private JButton adicionarButton;
    private JPanel mainPanel;
    private JLabel warningLabel;

    private JFrame isto;
    private FacadeModel modelFacade;

    public Adicionar(FacadeModel clube) {
        super("Adicionar Membro");
        this.add(mainPanel);
        this.setSize(400,200);
        this.setVisible(true);
        this.modelFacade = clube;

        isto = this;

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nomeI = textFieldNome.getText();
                String numeroI = textFieldNumero.getText();

                if(!nomeI.equals("") || !numeroI.equals("")){

                    int numero = Integer.parseInt(textFieldNumero.getText());

                    try{clube.addAluno(nomeI, numero, "", LocalDate.now(),"" );}
                    catch (AlunoJaExisteException a) {System.out.println("Erro");}
                    catch (IOException i) {System.out.println("Erro");}

                    isto.setVisible(false);
                    isto.dispose();

                }
                else {
                    System.out.println("teste");
                    warningLabel.setText("Erro");
                }

            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isto.dispose();
            }
        });
    }

}
