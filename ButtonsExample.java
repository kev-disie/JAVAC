import javax.swing.*;

import java.awt.event.*;

public class ButtonsExample {
     public static void main(String[] args){

        JFrame f = new JFrame("Buttons Example");

        final JTextField tf = new JTextField();

        tf.setBounds(50, 50, 150, 20);

        JButton b =new JButton("ClickHere");

        b.setBounds(50, 100, 100, 30);

        b.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e){
                tf.setText("Welcome to JavaTpoint");


            }
        });

        f.add(b);

        f.add(tf);

        
        f.setSize(400,400);

        f.setLayout(null);

        f.setVisible(true);


     }
    
}