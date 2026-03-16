import javax.swing.*;
import java.awt.*; 
// import java.awt.color.*;
// import java.awt.font.*;
import java.awt.event.*;

public class LoginForm {

    public static void main(String[] args){
        JFrame frame = new JFrame("Login Form");
        JPanel panel = new JPanel();
        JTextField usernamField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");

       
        JLabel dsiplayJLabel = new JLabel();
        ImageIcon image = new ImageIcon("find it.png");
        frame.setIconImage(image.getImage());


        Font btnFont = new Font("Arial",Font.PLAIN ,12);
        Font usr = new Font("Arial",Font.BOLD ,12);
        Font pass = new Font("Arial",Font.BOLD,12 );

        usernamField.setFont(usr);
        loginButton.setFont(btnFont); 
        passwordField.setFont(pass);
      


    Color customSienna = new Color( 160, 82,45);
    Color customBlack = new Color(28, 28, 28);
    Color customIvory = new Color(255, 255, 240);
    // Color customWhite = new Color(white);

    dsiplayJLabel.setBackground(customBlack);
    panel.setBackground(customSienna);
    // usernamField.setFont(new Font("Serif",Font.PLAIN ,30));
    loginButton.setBackground(customIvory);
    usernamField.setBorder(null);
    passwordField.setBorder(null);

    // loginButton.setIconImage(image.getImage());


    

        panel.add(new JLabel("User Name:"));
        panel.add(usernamField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public  void actionPerformed(ActionEvent e){

                 String username = usernamField.getText();
            String password = new String(passwordField.getPassword());

                if (username.equals("admin") && password.equals("password")){
                    JOptionPane.showMessageDialog(frame,"Login Succesful");
               }else{
                JOptionPane.showMessageDialog(frame,"Invalid Username or Password");
               }

            }

            
            
        } );

        frame.add(panel);
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
           
        


    }
}




