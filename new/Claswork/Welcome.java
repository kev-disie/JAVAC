import javax.swing.*;
                                    //Welcome to JAva 

                                    // I love Java 

                                    //Reset //Click
import java.awt.event.*;

public class Welcome {

    public  static void main(String[] args){

        JFrame f = new JFrame("Welcome");

         JTextField tf1 =  new JTextField();

         JTextField tf2 = new JTextField();

         tf1.setBounds(100, 100, 150, 30);

         tf2.setBounds(100, 150, 150,30);

         JButton Reset = new JButton("Reset");

         JButton Click = new JButton("Click");

         Click.setBounds(230, 250, 100, 30);

          Reset.setBounds(100, 250, 100,30);

          Click.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e){
            tf1.setText("Welkie to JAVA");

            tf2.setText("I love JAVA");

         }

            
         });


         Reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){

            tf1.setText(null);

            tf2.setText(null);


            }
            
           
         });

        f.add(tf1);

        f.add(tf2);

         
         f.add(Click);

         f.add(Reset);

         f.setSize(400, 400);

         f.setLayout(null);

         f.setVisible(true);







    }
}