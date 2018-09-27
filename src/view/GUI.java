package view;

import model.ModelFacade;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Observable;
import java.util.Observer;


public class GUI extends JFrame implements Observer {

    private JPanel panel1;
    private JButton adicionarMembroButton;
    private JList list1;
    private JButton removeMembroButton;
    private ModelFacade model;



    public GUI(ModelFacade modelFacade){

        super("Menu");
        this.setSize(600,600);
        this.add(panel1);
        this.setVisible(true);

        model = modelFacade;

        DefaultListModel<String> model1 = new DefaultListModel<>();
        list1.setModel(model1);
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list1.setLayoutOrientation(JList.VERTICAL);
        list1.setVisibleRowCount(4);


        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()) {

                    if(list1.getSelectedIndex() == -1){
                        removeMembroButton.setEnabled(false);
                    } else {
                        removeMembroButton.setEnabled(true);
                    }
                }
            }
        });



        adicionarMembroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model1.addElement("Ola");

                model.addMembro("",0);

            }
        });

        removeMembroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int index = list1.getSelectedIndex();
                model1.remove(index);
                // TODO: remover no model
                int size = model1.getSize();

                if(size <= 0){
                    removeMembroButton.setEnabled(false);
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



    public static void main(String[] args) {
        new GUI(null);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
