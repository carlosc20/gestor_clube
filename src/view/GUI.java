package view;

import model.FacadeModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;


public class GUI extends JFrame implements Observer {

    private JPanel panel1;
    private JButton adicionarMembroButton;
    private JList list1;
    private JButton removerMembroButton;

    private FacadeModel modelFacade;
    private DefaultListModel<String> model1;
    private ArrayList<Integer> listaAlunos;

    private Adicionar adicionarFrame;

    public GUI(){


        //frame
        super("Menu");
        this.setSize(600,600);
        this.add(panel1);
        this.setVisible(true);

        this.modelFacade = FacadeModel.getInstance();
        this.modelFacade.addObserver(this);

        // lista de membros
        this.model1 = new DefaultListModel<>();
        list1.setModel(model1);
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list1.setLayoutOrientation(JList.VERTICAL);



        // desbloqueia/bloqueia o botão de remover quando existem/não existem membros
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


        // janela editar membro, duplo click
        list1.addMouseListener( new MouseAdapter() {
            public void mouseClicked(MouseEvent mouseEvent) {
                JList list1 = (JList) mouseEvent.getSource();
                if (mouseEvent.getClickCount() == 2) {
                    // TODO: editar dados
                    int index = list1.locationToIndex(mouseEvent.getPoint());
                    if (index >= 0) {
                        //Object o = list1.getModel().getElementAt(index);
                        Object selected = list1.getModel().getElementAt(index);
                        Editar nova = new Editar(listaAlunos.get(index));
                        nova.setVisible(true);
                    }
                }
            }
        });


        // janela adicionar membro
        adicionarMembroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (adicionarFrame != null && adicionarFrame.isDisplayable()) { //se já existe, tras para a frente
                    adicionarFrame.toFront();
                } else {
                    adicionarFrame = new Adicionar();
                }

            }
        });


        // remover membro
        removerMembroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int index = list1.getSelectedIndex();
                /*
                model1.remove(index);

                int size = model1.getSize();

                if(size <= 0){
                    removerMembroButton.setEnabled(false);
                } else {
                    if(index == size){
                        index--;
                    }
                }
                */

                list1.setSelectedIndex(index);
                list1.ensureIndexIsVisible(index);

                try {
                    modelFacade.delAluno(listaAlunos.get(index));
                } catch (Exception f) {
                    System.out.println("Erro ao remover o aluno");
                }
            }
        });
    }

    private void fillJList(){
        this.model1.clear();

        Set<Integer> numeros = modelFacade.getAlunosNumero();
        listaAlunos = new ArrayList<>(numeros);
        if(numeros.size() < 1) {
            removerMembroButton.setEnabled(false);
        } else {
            for (int a : numeros) {
                this.model1.addElement(String.valueOf(a));
            }
        }
    }

    public static void main(String[] args) {
        new GUI().fillJList();
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
