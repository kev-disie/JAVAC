import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame f=new JFrame();

        JButton b1 = new JButton("Click"); //

        JButton b2 = new JButton("Exit");


        b1.setBounds(50,100,100,40); //x-axis,y-axis .width ,height
        f.add(b1); //adding button in frame

        b2.setBounds(50,100,100,40);

        f.add(b2);

        f.setSize(400,500); //x-axis400 500-y-axis

        f.setLayout(null); // using no layout manager

        f.setVisible(true); //making the frame visible

    }
}