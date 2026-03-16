import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private JLabel historyLabel; // The "slight background" value
    private JLabel resultLabel;  // The main large value
    private String currentInput = "";
    private double firstValue = 0;
    private String operator = "";
    private boolean startNewNumber = true;

    public Calculator() {
        // --- Window Setup ---
        setTitle("Java Calculator");
        setSize(350, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(30, 30, 30));
        setLayout(new BorderLayout(10, 10));

        // --- 1. Display Panel (The Labels) ---
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new GridLayout(2, 1));
        displayPanel.setBackground(new Color(30, 30, 30));
        displayPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        historyLabel = new JLabel("", SwingConstants.RIGHT);
        historyLabel.setForeground(Color.GRAY); // The "background" look
        historyLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));

        resultLabel = new JLabel("0", SwingConstants.RIGHT);
        resultLabel.setForeground(Color.WHITE);
        resultLabel.setFont(new Font("SansSerif", Font.BOLD, 48));

        displayPanel.add(historyLabel);
        displayPanel.add(resultLabel);
        add(displayPanel, BorderLayout.NORTH);

        // --- 2. Button Panel ---
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 8, 8));
        buttonPanel.setBackground(new Color(30, 30, 30));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] buttons = {
            "C", "π", "/", "DEL",
            "7", "8", "9", "*",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", ".", "=", "" 
        };

        for (String text : buttons) {
            if (text.isEmpty()) {
                buttonPanel.add(new JLabel("")); // Spacer
                continue;
            }
            JButton btn = new JButton(text);
            btn.setFont(new Font("SansSerif", Font.BOLD, 18));
            btn.setFocusPainted(false);
            btn.setBackground(new Color(50, 50, 50));
            btn.setForeground(Color.WHITE);
            btn.addActionListener(this);
            buttonPanel.add(btn);
        }

        add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.matches("[0-9\\.]")) { // Numbers
            if (startNewNumber) {
                resultLabel.setText(command);
                startNewNumber = false;
            } else {
                resultLabel.setText(resultLabel.getText() + command);
            }
        } else if (command.equals("π")) {
            resultLabel.setText(String.valueOf(Math.PI).substring(0, 10));
            startNewNumber = false;
        } else if (command.equals("C")) {
            resultLabel.setText("0");
            historyLabel.setText("");
            firstValue = 0;
            operator = "";
            startNewNumber = true;
        } else if (command.equals("=")) {
            calculate();
            historyLabel.setText(historyLabel.getText() + " " + resultLabel.getText() + " =");
            startNewNumber = true;
        } else { // Operators (+, -, *, /)
            firstValue = Double.parseDouble(resultLabel.getText());
            operator = command;
            historyLabel.setText(resultLabel.getText() + " " + operator);
            startNewNumber = true;
        }
    }

    private void calculate() {
        double secondValue = Double.parseDouble(resultLabel.getText());
        double result = 0;

        switch (operator) {
            case "+": result = firstValue + secondValue; break;
            case "-": result = firstValue - secondValue; break;
            case "*": result = firstValue * secondValue; break;
            case "/": result = secondValue != 0 ? firstValue / secondValue : 0; break;
        }
        
        // Remove .0 if it's a whole number
        String finalResult = String.valueOf(result);
        if (finalResult.endsWith(".0")) {
            finalResult = finalResult.substring(0, finalResult.length() - 2);
        }
        resultLabel.setText(finalResult);
    }

    public static void main(String[] args) {
        new Calculator();
    }
}

