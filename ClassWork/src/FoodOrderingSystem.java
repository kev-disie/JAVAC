import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FoodOrderingSystem implements ActionListener, ItemListener {

    JFrame frame;

    JLabel titleLabel, nameLabel, phoneLabel, totalBillLabel, amountPaidLabel;
    JLabel pizzaStockLabel, burgerStockLabel, teaStockLabel;

    JTextField nameField, phoneField, totalBillField, amountPaidField;

    JCheckBox pizzaCheckBox, burgerCheckBox, teaCheckBox;

    JComboBox<Integer> pizzaComboBox, burgerComboBox, teaComboBox;

    JButton calculateButton, payButton, resetButton, exitButton;

    JTextArea messageArea;
    JScrollPane scrollPane;

    int pizzaPrice = 500;
    int burgerPrice = 300;
    int teaPrice = 50;

    int pizzaStock = 10;
    int burgerStock = 8;
    int teaStock = 20;

    int currentPizzaQty = 0;
    int currentBurgerQty = 0;
    int currentTeaQty = 0;
    int currentTotalBill = 0;

    public FoodOrderingSystem() {
        frame = new JFrame("Food Ordering System");
        frame.setSize(760, 720);
        frame.setLayout(null);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        titleLabel = new JLabel("FOOD ORDERING SYSTEM");
        titleLabel.setBounds(250, 20, 250, 30);
        frame.add(titleLabel);

        nameLabel = new JLabel("Customer Name:");
        nameLabel.setBounds(50, 70, 120, 25);
        frame.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(180, 70, 200, 25);
        frame.add(nameField);

        phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setBounds(50, 110, 120, 25);
        frame.add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(180, 110, 200, 25);
        frame.add(phoneField);

        pizzaCheckBox = new JCheckBox("Pizza @ Ksh 500");
        pizzaCheckBox.setBounds(50, 170, 150, 25);
        pizzaCheckBox.addItemListener(this);
        frame.add(pizzaCheckBox);

        pizzaStockLabel = new JLabel("Available: " + pizzaStock);
        pizzaStockLabel.setBounds(220, 170, 100, 25);
        frame.add(pizzaStockLabel);

        pizzaComboBox = new JComboBox<>();
        pizzaComboBox.setBounds(360, 170, 80, 25);
        pizzaComboBox.setVisible(false);
        frame.add(pizzaComboBox);

        burgerCheckBox = new JCheckBox("Burger @ Ksh 300");
        burgerCheckBox.setBounds(50, 220, 160, 25);
        burgerCheckBox.addItemListener(this);
        frame.add(burgerCheckBox);

        burgerStockLabel = new JLabel("Available: " + burgerStock);
        burgerStockLabel.setBounds(220, 220, 100, 25);
        frame.add(burgerStockLabel);

        burgerComboBox = new JComboBox<>();
        burgerComboBox.setBounds(360, 220, 80, 25);
        burgerComboBox.setVisible(false);
        frame.add(burgerComboBox);

        teaCheckBox = new JCheckBox("Tea @ Ksh 50");
        teaCheckBox.setBounds(50, 270, 150, 25);
        teaCheckBox.addItemListener(this);
        frame.add(teaCheckBox);

        teaStockLabel = new JLabel("Available: " + teaStock);
        teaStockLabel.setBounds(220, 270, 100, 25);
        frame.add(teaStockLabel);

        teaComboBox = new JComboBox<>();
        teaComboBox.setBounds(360, 270, 80, 25);
        teaComboBox.setVisible(false);
        frame.add(teaComboBox);

        updateComboBox(pizzaComboBox, pizzaStock);
        updateComboBox(burgerComboBox, burgerStock);
        updateComboBox(teaComboBox, teaStock);

        totalBillLabel = new JLabel("Total Bill:");
        totalBillLabel.setBounds(50, 390, 100, 25);

        frame.add(totalBillLabel);

        totalBillField = new JTextField();
        totalBillField.setBounds(190, 390, 200, 25);
        totalBillField.setBackground(Color.white);

        totalBillField.setEditable(false);
        frame.add(totalBillField);

        amountPaidLabel = new JLabel("Amount Paid:");
        amountPaidLabel.setBounds(50, 430, 100, 25);
        frame.add(amountPaidLabel);

        amountPaidField = new JTextField();
        amountPaidField.setBounds(190, 430, 200, 25);
        frame.add(amountPaidField);

        calculateButton = new JButton("Calculate Total");
        calculateButton.setBounds(50, 350, 140, 35);
        calculateButton.addActionListener(this);
        frame.add(calculateButton);

        payButton = new JButton("Pay / Confirm");
        payButton.setBounds(210, 490, 130, 35);
        payButton.addActionListener(this);
        frame.add(payButton);

        resetButton = new JButton("Reset");
        resetButton.setBounds(360, 490, 100, 35);
        resetButton.addActionListener(this);
        frame.add(resetButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(480, 490, 100, 35);
        exitButton.addActionListener(this);
        frame.add(exitButton);

        messageArea = new JTextArea();
        messageArea.setEditable(false);
        scrollPane = new JScrollPane(messageArea);
        scrollPane.setBounds(50, 550, 620, 150);
        frame.add(scrollPane);

        frame.setVisible(true);
    }

    public void updateComboBox(JComboBox<Integer> comboBox, int stock) {
        comboBox.removeAllItems();
        for (int i = 1; i <= stock; i++) {
            comboBox.addItem(i);
        }
    }

    public void updateStockLabels() {
        pizzaStockLabel.setText("Available: " + pizzaStock);
        burgerStockLabel.setText("Available: " + burgerStock);
        teaStockLabel.setText("Available: " + teaStock);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == pizzaCheckBox) {
            if (pizzaStock > 0) {
                pizzaComboBox.setVisible(pizzaCheckBox.isSelected());
            } else {
                pizzaCheckBox.setSelected(false);
                JOptionPane.showMessageDialog(frame, "Pizza is out of stock.");
            }
        }

        if (e.getSource() == burgerCheckBox) {
            if (burgerStock > 0) {
                burgerComboBox.setVisible(burgerCheckBox.isSelected());
            } else {
                burgerCheckBox.setSelected(false);
                JOptionPane.showMessageDialog(frame, "Burger is out of stock.");
            }
        }

        if (e.getSource() == teaCheckBox) {
            if (teaStock > 0) {
                teaComboBox.setVisible(teaCheckBox.isSelected());
            } else {
                teaCheckBox.setSelected(false);
                JOptionPane.showMessageDialog(frame, "Tea is out of stock.");
            }
        }
    }

    private boolean readOrderDetails() {
        if (!pizzaCheckBox.isSelected() && !burgerCheckBox.isSelected() && !teaCheckBox.isSelected()) {
            JOptionPane.showMessageDialog(frame, "Please select at least one food item.");
            return false;
        }

        currentPizzaQty = 0;
        currentBurgerQty = 0;
        currentTeaQty = 0;

        if (pizzaCheckBox.isSelected()) {
            if (pizzaComboBox.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(frame, "Please select valid pizza quantity.");
                return false;
            }
            currentPizzaQty = (Integer) pizzaComboBox.getSelectedItem();
        }

        if (burgerCheckBox.isSelected()) {
            if (burgerComboBox.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(frame, "Please select valid burger quantity.");
                return false;
            }
            currentBurgerQty = (Integer) burgerComboBox.getSelectedItem();
        }

        if (teaCheckBox.isSelected()) {
            if (teaComboBox.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(frame, "Please select valid tea quantity.");
                return false;
            }
            currentTeaQty = (Integer) teaComboBox.getSelectedItem();
        }

        if (currentPizzaQty > pizzaStock) {
            JOptionPane.showMessageDialog(frame, "Not enough Pizza in stock.");
            return false;
        }

        if (currentBurgerQty > burgerStock) {
            JOptionPane.showMessageDialog(frame, "Not enough Burger in stock.");
            return false;
        }

        if (currentTeaQty > teaStock) {
            JOptionPane.showMessageDialog(frame, "Not enough Tea in stock.");
            return false;
        }

        int pizzaTotal = currentPizzaQty * pizzaPrice;
        int burgerTotal = currentBurgerQty * burgerPrice;
        int teaTotal = currentTeaQty * teaPrice;

        currentTotalBill = pizzaTotal + burgerTotal + teaTotal;
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == calculateButton) {
            String customerName = nameField.getText().trim();
            String phoneNumber = phoneField.getText().trim();

            if (customerName.isEmpty() || phoneNumber.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter customer name and phone number.");
                return;
            }

            if (readOrderDetails()) {
                totalBillField.setText(String.valueOf(currentTotalBill));
                JOptionPane.showMessageDialog(frame, "Total bill calculated successfully.");
            }
        }

        if (e.getSource() == payButton) {
            String customerName = nameField.getText().trim();
            String phoneNumber = phoneField.getText().trim();
            String amountPaidText = amountPaidField.getText().trim();

            if (customerName.isEmpty() || phoneNumber.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter customer name and phone number.");
                return;
            }

            if (totalBillField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please click Calculate Total first.");
                return;
            }

            if (amountPaidText.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter amount paid.");
                return;
            }

            int amountPaid;
            try {
                amountPaid = Integer.parseInt(amountPaidText);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid amount.");
                return;
            }

            if (amountPaid < currentTotalBill) {
                JOptionPane.showMessageDialog(frame, "Insufficient payment. Total bill is Ksh " + currentTotalBill);
                return;
            }

            int pizzaTotal = currentPizzaQty * pizzaPrice;
            int burgerTotal = currentBurgerQty * burgerPrice;
            int teaTotal = currentTeaQty * teaPrice;
            int balance = amountPaid - currentTotalBill;

            pizzaStock -= currentPizzaQty;
            burgerStock -= currentBurgerQty;
            teaStock -= currentTeaQty;

            updateStockLabels();
            updateComboBox(pizzaComboBox, pizzaStock);
            updateComboBox(burgerComboBox, burgerStock);
            updateComboBox(teaComboBox, teaStock);

            if (pizzaStock == 0) {
                pizzaCheckBox.setSelected(false);
                pizzaCheckBox.setEnabled(false);
                pizzaComboBox.setVisible(false);
            }

            if (burgerStock == 0) {
                burgerCheckBox.setSelected(false);
                burgerCheckBox.setEnabled(false);
                burgerComboBox.setVisible(false);
            }

            if (teaStock == 0) {
                teaCheckBox.setSelected(false);
                teaCheckBox.setEnabled(false);
                teaComboBox.setVisible(false);
            }

            messageArea.setText("");
            messageArea.append("===== PAYMENT SUCCESSFUL - ORDER RECEIPT =====\n");
            messageArea.append("Customer Name: " + customerName + "\n");
            messageArea.append("Phone Number: " + phoneNumber + "\n");
            messageArea.append("----------------------------------------------\n");
            messageArea.append("Items Ordered:\n");

            if (currentPizzaQty > 0) {
                messageArea.append("Pizza x " + currentPizzaQty + " = Ksh " + pizzaTotal + "\n");
            }

            if (currentBurgerQty > 0) {
                messageArea.append("Burger x " + currentBurgerQty + " = Ksh " + burgerTotal + "\n");
            }

            if (currentTeaQty > 0) {
                messageArea.append("Tea x " + currentTeaQty + " = Ksh " + teaTotal + "\n");
            }

            messageArea.append("----------------------------------------------\n");
            messageArea.append("Total Bill: Ksh " + currentTotalBill + "\n");
            messageArea.append("Amount Paid: Ksh " + amountPaid + "\n");
            messageArea.append("Balance: Ksh " + balance + "\n");
            messageArea.append("----------------------------------------------\n");
//            messageArea.append("Remaining Stock:\n");
//            messageArea.append("Pizza = " + pizzaStock + "\n");
//            messageArea.append("Burger = " + burgerStock + "\n");
//            messageArea.append("Tea = " + teaStock + "\n");
//            messageArea.append("==============================================\n");

            totalBillField.setText("");
            amountPaidField.setText("");
            currentPizzaQty = 0;
            currentBurgerQty = 0;
            currentTeaQty = 0;
            currentTotalBill = 0;

            if (pizzaCheckBox.isEnabled()) pizzaCheckBox.setSelected(false);
            if (burgerCheckBox.isEnabled()) burgerCheckBox.setSelected(false);
            if (teaCheckBox.isEnabled()) teaCheckBox.setSelected(false);

            pizzaComboBox.setVisible(false);
            burgerComboBox.setVisible(false);
            teaComboBox.setVisible(false);
        }

        if (e.getSource() == resetButton) {
            nameField.setText("");
            phoneField.setText("");
            totalBillField.setText("");
            amountPaidField.setText("");

            currentPizzaQty = 0;
            currentBurgerQty = 0;
            currentTeaQty = 0;
            currentTotalBill = 0;

            if (pizzaCheckBox.isEnabled()) pizzaCheckBox.setSelected(false);
            if (burgerCheckBox.isEnabled()) burgerCheckBox.setSelected(false);
            if (teaCheckBox.isEnabled()) teaCheckBox.setSelected(false);

            pizzaComboBox.setVisible(false);
            burgerComboBox.setVisible(false);
            teaComboBox.setVisible(false);

            messageArea.setText("");
        }

        if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new FoodOrderingSystem();
    }
}
