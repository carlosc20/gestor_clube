package view;

import model.AlunoJaExisteException;
import model.FacadeModel;

import javax.swing.*;
import java.awt.*;
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
    private JTextField textFieldMorada;
    private JTextField textFieldCurso;

    private JFrame isto;
    private FacadeModel modelFacade;


    public Adicionar() {
        super("Adicionar Membro");
        this.add(mainPanel);
        this.setSize(400,200);
        this.setVisible(true);
        this.modelFacade = FacadeModel.getInstance();

        isto = this;
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nomeI = textFieldNome.getText();
                String numeroI = textFieldNumero.getText();

                if(!nomeI.equals("") && !numeroI.equals("")){
                    try{
                        int numero = Integer.parseInt(textFieldNumero.getText());
                        String curso = textFieldCurso.getText();
                        String morada = textFieldMorada.getText();
                        modelFacade.addAluno(nomeI, numero, curso, LocalDate.now(),morada );
                        isto.dispose();
                    }
                    catch (NumberFormatException n) {
                        JOptionPane.showMessageDialog(isto, "O número tem de estar num formato adequado.","Erro", JOptionPane.WARNING_MESSAGE);
                    }
                    catch (AlunoJaExisteException a) {
                        JOptionPane.showMessageDialog(isto, "O aluno já existe.","Erro", JOptionPane.WARNING_MESSAGE);
                    }
                    catch (IOException i) {
                        JOptionPane.showMessageDialog(isto, "Não foi possível guardar.","Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(isto, "É necessário preencher todos os campos.","Erro", JOptionPane.WARNING_MESSAGE);
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
