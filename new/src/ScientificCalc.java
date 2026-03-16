import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Desktop.Action;
import java.awt.event.*;
import java.util.Arrays;

public class ScientificCalc {

    // int boardWidth = 360;
    // int boardHeigth = 540;

    Color customLightgrey = new Color(212, 212, 210);
    Color customDarkgrey = new Color(80, 80,80);
    Color customBlack = new Color(28, 28, 28);
    Color customOrange = new Color(255, 149, 0);


    String[] buttonValues = {
        "AC", "+/-", "%", "÷", 
        "7", "8", "9", "×", 
        "4", "5", "6", "-",
        "1", "2", "3", "+",
        "0", ".", "√", "="
    };
    String[] rightSymbols = {"÷", "×", "-", "+", "="};
    String[] topSymbols = {"AC", "+/-", "%"};


    JFrame frame = new JFrame("Scientific Calculator");
    JLabel displayLabel = new JLabel();
    JPanel displayPanel = new JPanel();
    JPanel buttonsPanel = new JPanel();

    String A = "0";
    String B = null;
    String operator = null;

    ScientificCalc(){
        frame.setVisible(true);
        frame.setSize(360,540 );
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());


        displayLabel.setBackground(customBlack);
        displayLabel.setForeground(Color.white);
        displayLabel.setFont(new Font("Arial", Font.PLAIN, 80));
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);
        displayLabel.setText("0");
        displayLabel.setOpaque(true);

        displayPanel.setLayout(new BorderLayout());
        displayPanel.add(displayLabel);
        frame.add(displayPanel);
        frame.add(displayPanel,BorderLayout.NORTH);

        buttonsPanel.setLayout(new GridLayout(5 ,4));
        buttonsPanel.setBackground(customBlack);
        frame.add(buttonsPanel);

        for (int i = 0; i < buttonValues.length ; i++){

            JButton button = new JButton();
            String buttonValue = buttonValues[i];
            button.setFont(new Font("Arial",Font.PLAIN,30));
            button.setText(buttonValue);
            button.setFocusable(false);
            // buttonsPanel.add(button);
            button.setBorder(new LineBorder(customBlack));

            if (Arrays.asList(topSymbols).contains(buttonValue)){
                button.setBackground(customLightgrey);
                button.setForeground(customBlack);
            }else if(Arrays.asList(rightSymbols).contains(buttonValue)){
                button.setBackground(customOrange);
                button.setForeground(Color.white);
            }else{
                button.setBackground(customDarkgrey);
                button.setForeground(Color.white);

            }

            buttonsPanel.add(button);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    JButton button = (JButton) e.getSource();
                    String buttonValue = button.getText();

                    if(Arrays.asList(rightSymbols).contains(buttonValue)){
                        if (buttonValue == "="){
                            if (A != null){
                                B = displayLabel.getText();
                                double numA = Double.parseDouble(A);
                                double numB = Double.parseDouble(B);

                                if (operator == "+"){
                                    displayLabel.setText(removeZeroDecimal(numA + numB));
                                } else if (operator == "-") {
                                    displayLabel.setText(removeZeroDecimal(numA - numB));
                                } else if (operator == "×" ) {
                                    displayLabel.setText(removeZeroDecimal(numA * numB));
                                } else if (operator == "÷") {
                                    displayLabel.setText(removeZeroDecimal(numA / numB));

                                }
                                clearAll();
                            }
                            
                        } else if ("+-×÷".contains(buttonValue)) {
                            if (operator == null){
                                A = displayLabel.getText();
                                displayLabel.setText("0");
                                B = "0";
                            }
                            operator =buttonValue;

                        }

                    }else if (Arrays.asList(topSymbols).contains(buttonValue)){
                        if (buttonValue == "AC"){
                            clearAll();
                            displayLabel.setText("0");
                        } else if (buttonValue == "+/-") {
                            double numDisplay = Double.parseDouble((displayLabel.getText()));
                            numDisplay *= -1;
                            displayLabel.setText(Double.toString(numDisplay));
                            displayLabel.setText(removeZeroDecimal(numDisplay));

                        } else if (buttonValue == "%") {

                            double numDisplay = Double.parseDouble((displayLabel.getText()));
                            numDisplay /= 100;
                            displayLabel.setText(Double.toString(numDisplay));
                            displayLabel.setText(removeZeroDecimal(numDisplay));


                        }

                    }else{
                        if (buttonValue == "."){
                            if(!displayLabel.getText().contains(buttonValue)){
                                displayLabel.setText(displayLabel.getText() + buttonValue);
                            }

                        }else if ("0123456789".contains(buttonValue)){
                            if (displayLabel.getText() == "0"){
                                displayLabel.setText(buttonValue);
                            }else{
                                displayLabel.setText(displayLabel.getText() + buttonValue);
                            }
                        }
                    }
                }
            });
        }

    }
    public static void main(String args[]){

        new ScientificCalc();

    }

    void clearAll(){
     A = "0";
     B = null;
     operator = null;
    }
    String removeZeroDecimal(double numDisplay){
        if (numDisplay % 1== 0){
            return Integer.toString((int)numDisplay);
        }

        return Double.toString(numDisplay);
    }
}
