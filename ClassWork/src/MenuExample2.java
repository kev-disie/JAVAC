import javax.swing.*;
import java.awt.event.*;
public class MenuExample2 implements ActionListener{
    JFrame f;
    JMenuBar mb;
    JMenu file,edit,help;
    JMenuItem cut,copy,paste,selectAll;
    JTextArea ta;
    MenuExample2(){
        f = new JFrame();
        cut = new JMenuItem("Cut");
        copy = new JMenuItem("copy");
        paste = new JMenuItem("paste");
        selectAll = new JMenuItem("selectAll");
//        cut.addActionListener(this);
//        copy.addActionListener(this);
//        paste.addActionListener(this);
//        selectAll.addActionListener(this);
        file = new JMenu("file");
        edit = new JMenu("edit");
        help = new JMenu("Help");
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        mb = new JMenuBar();

        ta = new JTextArea();
        ta.setBounds(5,5,360,320);
        mb.add(file);mb.add(edit);mb.add(help);
        f.add(mb);
        f.add(ta);
        f.setJMenuBar(mb);
        f.setLayout(null);
        f.setSize(400,400);
        f.setVisible(true);

    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cut){
            ta.cut();
        }

        if (e.getSource() == paste){
            ta.paste();
        }

        if (e.getSource() == copy){
            ta.copy();
        }

        if (e.getSource() == selectAll){
            ta.selectAll();
        }

    }
    public static void main(String[]args){
        new MenuExample2();
    }
}