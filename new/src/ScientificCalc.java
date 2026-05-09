import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.Arrays;

public class ScientificCalc {

    // int boardWidth = 360;
    // int boardHeigth = 540;

    Color customSpringGreen = new Color(0,250,154);
    Color customSlate = new Color(47, 79,79);
    Color customBlack = new Color(28, 28, 28);
    Color customTeal = new Color(0, 128,128);
    Color customMidNightBlue = new Color(25,25,112);


    String[] buttonValues = {
        "AC", "+/-", "%", "÷", "x³",
        "7", "8", "9", "×", "log",
        "4", "5", "6", "-","tan",
        "1", "2", "3", "+","SINE",
        "0", ".", "√", "=", "COS"
    };
    String[] rightSymbols = {"÷", "×", "-", "+", "="};
    String[] topSymbols = {"AC", "+/-", "%"};
    String[] rightMostSymbols = {"x³","log","tan","SINE","COS"};


    JFrame frame = new JFrame("Scientific Calculator");
    JLabel displayLabel = new JLabel();
    JPanel displayPanel = new JPanel();
    JPanel buttonsPanel = new JPanel();

    String A = "0";
    String B = null;
//    String C = "0";
    String operator = null;

    ScientificCalc(){
        frame.setVisible(true);

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
                button.setBackground(customSpringGreen);
                button.setForeground(customBlack);
            }else if(Arrays.asList(rightSymbols).contains(buttonValue)){
                button.setBackground(customTeal);
                button.setForeground(Color.white);
            } else if (Arrays.asList(rightMostSymbols).contains(buttonValue)) {
                button.setBackground(customMidNightBlue);
                button.setForeground(Color.white);

            }else {
                button.setBackground(customSlate);
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
//                                double numC = Double.parseDouble(C);

                                if (operator == "+"){
                                    displayLabel.setText(removeZeroDecimal(numA + numB));
                                } else if (operator == "-") {
                                    displayLabel.setText(removeZeroDecimal(numA - numB));
                                } else if (operator == "×" ) {
                                    displayLabel.setText(removeZeroDecimal(numA * numB));
                                } else if (operator == "÷") {
                                    displayLabel.setText(removeZeroDecimal(numA / numB));

                                } else if (operator == "√") {
                                   if (numB == numA){
                                       displayLabel.setText(removeZeroDecimal((numA)));
                                   }
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

                    } else if (Arrays.asList(rightMostSymbols).contains(buttonValue)) {
                        if (buttonValue == "SINE"){
                            double sin = Math.sin(Math.toRadians());
                        }

                    } else{
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
        frame.setSize(360,540);
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
