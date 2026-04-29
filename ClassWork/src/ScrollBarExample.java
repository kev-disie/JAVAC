import javax.swing.*;
import java.awt.event.*;
class   ScrollBarExample {
    ScrollBarExample() {
        JFrame f = new JFrame("Scroll Bar Example");
        final JLabel label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setSize(400, 100);
        final JScrollBar s = new JScrollBar();
        s.setBounds(100, 100, 50, 100);
        f.add(s);
        f.add(label);
        f.setLayout(null);
        s.addAdjustmentListener(new AdjustmentListener(){
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                label.setText("Vertical ScrollBar value is:"+ s.getValue());
            }
        });


    }
    public static void main(String args[]){
        new ScrollBarExample();
    }

}