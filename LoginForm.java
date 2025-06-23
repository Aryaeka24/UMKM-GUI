import java.awt.*;
import javax.swing.*;

public class LoginForm extends JFrame {
    public LoginForm() {
        setTitle("Login UMKM");
        setSize(340, 260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(33,80,162), 2),
            BorderFactory.createEmptyBorder(18, 18, 18, 18)));
        formPanel.setBackground(new Color(250, 252, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Login Aplikasi UMKM");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titleLabel.setForeground(new Color(33,80,162));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        formPanel.add(titleLabel, gbc);
        gbc.gridwidth = 1;

        gbc.gridy = 1; gbc.gridx = 0;
        JLabel userLabel = new JLabel("Username:");
        userLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        formPanel.add(userLabel, gbc);
        gbc.gridx = 1;
        JTextField userField = new JTextField();
        formPanel.add(userField, gbc);

        gbc.gridy = 2; gbc.gridx = 0;
        JLabel passLabel = new JLabel("Password:");
        passLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        formPanel.add(passLabel, gbc);
        gbc.gridx = 1;
        JPasswordField passField = new JPasswordField();
        formPanel.add(passField, gbc);

        gbc.gridy = 3; gbc.gridx = 0; gbc.gridwidth = 2;
        JButton loginBtn = new JButton("Login", UIManager.getIcon("FileView.computerIcon"));
        loginBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        loginBtn.setBackground(new Color(33,80,162));
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setFocusPainted(false);
        formPanel.add(loginBtn, gbc);

        add(formPanel, BorderLayout.CENTER);

        JLabel infoLabel = new JLabel("Username: admin | Password: 123");
        infoLabel.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        infoLabel.setForeground(new Color(120, 120, 120));
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(infoLabel, BorderLayout.SOUTH);

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

        setLocationRelativeTo(null);
        setVisible(true);
    }
}