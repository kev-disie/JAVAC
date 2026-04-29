import javax.swing.*;
import java.awt.event.*;
import java.util.function.DoubleConsumer;

public class Notepad implements ActionListener{
    JFrame f;
    JMenuBar menuBar;
    final JPopupMenu popupMenu = new JPopupMenu("Edit");
    JMenu File,Edit,Search,View,Document,Help;
    JMenuItem cut,copy,selectAll,paste;
    JTextArea textArea;
    Notepad(){
        f = new JFrame();
        cut = new JMenuItem("cut");
        copy = new JMenuItem("copy");
        paste = new JMenuItem("paste");
        selectAll = new JMenuItem("selectAll");



        File = new JMenu("File");
        Edit = new JMenu("Edit");
        Help = new JMenu("Help");
        Search = new JMenu("Search");
        View = new JMenu("View");
        Document = new JMenu("Documents");


//        Edit.add(cut);
//        Edit.add(copy);
//        Edit.add(paste);
//        Edit.add(selectAll);
        popupMenu.add(cut);
        popupMenu.add(copy);
        popupMenu.add(paste);
        popupMenu.add(selectAll);
        f.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                popupMenu.show(f,e.getX(),e.getY());
            }
        });

        menuBar = new JMenuBar();

        textArea = new JTextArea();
        textArea.setBounds(5,5,360,320);
        menuBar.add(File);
        menuBar.add(Edit);
        menuBar.add(Help);
        menuBar.add(Search);
        menuBar.add(View);
        menuBar.add(Document);

        f.add(popupMenu);
        f.add(menuBar);
        f.add(textArea);
        f.setJMenuBar(menuBar);
        f.setLayout(null);
        f.setSize(400,400);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==cut){
            textArea.cut();
        }
        if(e.getSource()==paste){
            textArea.paste();
        }
        if (e.getSource()==copy){
            textArea.copy();
        }
        if(e.getSource()==selectAll){
            textArea.selectAll();
        }
    }
    public static void main (String[]args){
        new Notepad();
    }
}