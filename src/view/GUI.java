package view;

import model.FacadeModel;
import model.AlunoJaExisteException;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.time.LocalDate;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;


public class GUI extends JFrame implements Observer {

    private JPanel panel1;
    private JButton adicionarMembroButton;
    private JList list1;
    private JButton removerMembroButton;
    private JTable table1;

    private FacadeModel modelFacade; // mudei o nome
    private DefaultListModel<String> model1; //meti pq causa de uma função


    public GUI(FacadeModel model){


        //frame
        super("Menu");
        this.setSize(600,600);
        this.add(panel1);
        this.setVisible(true);

        this.modelFacade = model;
        this.modelFacade.addObserver(this);

        // lista de membros
        this.model1 = new DefaultListModel<>();
        list1.setModel(model1);
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list1.setLayoutOrientation(JList.VERTICAL);
        list1.setVisibleRowCount(4);


        // membro selecionado
        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()) {

                    if(list1.getSelectedIndex() == -1){
                        removerMembroButton.setEnabled(false);
                    } else {
                        removerMembroButton.setEnabled(true);
                    }
                }
            }
        });


        // menu membro, duplo click
        MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent mouseEvent) {
                JList list1 = (JList) mouseEvent.getSource();
                if (mouseEvent.getClickCount() == 2) {
                    // TODO: editar dados
                    int index = list1.locationToIndex(mouseEvent.getPoint());
                    if (index >= 0) {
                        //Object o = list1.getModel().getElementAt(index);
                        Object selected = list1.getModel().getElementAt(index);
                        Cotas nova = new Cotas(modelFacade);
                        nova.setVisible(true);

                    }
                }
            }
        };
        list1.addMouseListener(mouseListener);


        // adicionar membro
        adicionarMembroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Adicionar nova = new Adicionar(modelFacade); //mudei o contrutor

            }
        });


        // remover membro
        removerMembroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int index = list1.getSelectedIndex();
                model1.remove(index);
                // TODO: remover no model
                int size = model1.getSize();

                if(size <= 0){
                    removerMembroButton.setEnabled(false);
                } else {
                    if(index == size){
                        index--;
                    }
                }

                list1.setSelectedIndex(index);
                list1.ensureIndexIsVisible(index);
            }
        });
    }

    private void fillJList(){
        this.model1.clear();

        Set<Integer> numeros = modelFacade.getAlunosNumero();
        for(int a : numeros) {
            this.model1.addElement(String.valueOf(a));
        }
    }

    public static void main(String[] args) {
        new GUI(FacadeModel.getInstance()).fillJList();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Atualizou");
       fillJList();
    }
}
