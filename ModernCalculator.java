import javax.swing.*;
import java.awt.*;

public class ModernCalculator extends JFrame {
    public ModernCalculator() {
        setTitle("Java Calculator");
        setSize(350, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 1. Create the Display Panel
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new GridLayout(2, 1));
        displayPanel.setBackground(new Color(30, 30, 30)); // Dark background

        // The "Slight Background" value (History)
        JLabel historyLabel = new JLabel("4102 - 3 =", SwingConstants.RIGHT);
        historyLabel.setForeground(Color.GRAY);
        historyLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));

        // The Main Result
        JLabel resultLabel = new JLabel("4099", SwingConstants.RIGHT);
        resultLabel.setForeground(Color.WHITE);
        resultLabel.setFont(new Font("SansSerif", Font.BOLD, 40));

        displayPanel.add(historyLabel);
        displayPanel.add(resultLabel);
        add(displayPanel, BorderLayout.NORTH);

        // 2. Create the Button Panel (Grid)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));
        // Add buttons here (e.g., buttonPanel.add(new JButton("7")))
        
        add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ModernCalculator();
    }
}

