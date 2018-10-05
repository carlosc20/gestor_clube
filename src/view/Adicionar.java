package view;

import model.Clube;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Adicionar extends JFrame{

    private JTextField textFieldNome;
    private JTextField textFieldNumero;
    private JButton cancelarButton;
    private JButton adicionarButton;
    private JPanel mainPanel;
    private JLabel warningLabel;

    private JFrame isto;
    private Clube modelFacade;

    public Adicionar() {
        super("Adicionar Membro");
        this.add(mainPanel);
        this.setSize(400,200);
        this.setVisible(true);

        isto = this;

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nomeI = textFieldNome.getText();
                String numeroI = textFieldNumero.getText();

                if(!nomeI.equals("") || !numeroI.equals("")){

                    int numero = Integer.parseInt(textFieldNumero.getText());

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
