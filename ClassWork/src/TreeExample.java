import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

import static java.awt.Color.blue;
import static java.awt.Color.red;

//import static java.awt.Color.blue;
//import static java.awt.Color.red;

public class TreeExample{
   JFrame f;
   TreeExample(){
       f = new JFrame();
       DefaultMutableTreeNode style = new DefaultMutableTreeNode("style");
       DefaultMutableTreeNode color = new DefaultMutableTreeNode("color");
       DefaultMutableTreeNode black = new DefaultMutableTreeNode("black");
       DefaultMutableTreeNode green = new DefaultMutableTreeNode("green");
       color.add((MutableTreeNode) red);
       color.add((MutableTreeNode) blue);
        color.add(black);
       color.add(green);
       JTree jt = new JTree(style);
       f.add(jt);
       f.setSize(200,200);
       f.setVisible(true);

   }

   public static void main(String[] args){
       new TreeExample();
   }
}