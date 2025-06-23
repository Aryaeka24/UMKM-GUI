import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm extends JFrame {
    public LoginForm() {
        setTitle("Login UMKM");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();
        JButton loginBtn = new JButton("Login");

        loginBtn.addActionListener(e -> {
            String user = userField.getText();
            String pass = new String(passField.getPassword());
            if (user.equals("admin") && pass.equals("123")) {
                dispose();
                new Dashboard();
            } else {
                JOptionPane.showMessageDialog(this, "Login gagal!");
            }
        });

        add(userLabel); add(userField);
        add(passLabel); add(passField);
        add(new JLabel()); add(loginBtn);

        setVisible(true);
        setLocationRelativeTo(null);
    }
}