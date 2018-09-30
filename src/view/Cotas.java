package view;

import javax.swing.*;

public class Cotas extends JFrame {
    private JPanel panel1;


    public Cotas(Object value) {
        super("Cotas");
        this.add(panel1);
        this.setSize(200,200);
        this.setVisible(true);
        
        String str = (String) value;
        JLabel label = new JLabel();
        label.setText(str);

        this.add(label);
    }
}