package view;

import model.AlunoNaoExisteException;
import model.FacadeModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Cotas extends JFrame implements Observer {
    private FacadeModel modelFacade;
    private JList list1;
    private JPanel panel3;
    private JButton pagar;
    private JButton ok;
    private DefaultListModel<String> modelQ;
    private JFrame isto;

    private int id;

    public Cotas(int numero) {
        super("Pagamento");
        this.setSize(500, 500);
        this.add(panel3);
        this.setVisible(true);
        isto = this;
        id = numero;

        modelFacade = FacadeModel.getInstance();
        modelFacade.addObserver(this);


        // lista de cotas
        modelQ = new DefaultListModel<>();
        list1.setModel(modelQ);
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list1.setLayoutOrientation(JList.VERTICAL);


        pagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    modelFacade.pagarCota(numero, 5.0);
                }catch (IOException i){System.out.println("erro");}
            }
        });
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isto.dispose();
            }
        });
    }
    public void fillJListCotas (){
        try {
            ArrayList<Double> c = modelFacade.getCotasValor(id);
                for (double a : c) {
                    this.modelQ.addElement(String.valueOf(a));
                }
        }catch(AlunoNaoExisteException a) {System.out.println("erro");}
    }

    public void update(Observable o, Object arg) {
        System.out.println("Atualizou");
        int atual = (int) arg;
        if(atual == 1) {
            fillJListCotas();
        }
    }
}
