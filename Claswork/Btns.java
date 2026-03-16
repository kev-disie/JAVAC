import javax.swing.*;

public class Btns {

 public static void main(String[] args){ 

   JFrame f = new JFrame();

    JButton b1 = new JButton("Click");

    JButton Exit = new JButton("Exit");

    JButton Reset = new JButton("Reset");

    JButton Submit = new JButton("Submit");



   b1.setBounds(100,50,100,40);
   
   Exit.setBounds(100,140,100,40);

   Reset.setBounds(220,120,100,40);

   Submit.setBounds(150,200,100,40);





        f.add(b1);
        
        f.add(Exit);

        f.add(Reset);

        f.add(Submit);


        f.setSize(400,500); 

        f.setLayout(null); 

        f.setVisible(true);
    
    
    
    }

  
}