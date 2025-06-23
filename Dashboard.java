import java.awt.*;
import javax.swing.*;

public class Dashboard extends JFrame {
    public Dashboard() {
        setTitle("Dashboard UMKM");
        setSize(500, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menuData = new JMenu("Data UMKM");
        JMenuItem tambahMenu = new JMenuItem("Tambah UMKM");
        JMenuItem lihatMenu = new JMenuItem("Lihat Data UMKM");
        menuData.add(tambahMenu);
        menuData.add(lihatMenu);
        menuBar.add(menuData);

        JMenu menuReport = new JMenu("Report");
        JMenuItem reportMenu = new JMenuItem("Lihat Report");
        menuReport.add(reportMenu);
        menuBar.add(menuReport);

        JMenu menuLogout = new JMenu("Logout");
        JMenuItem logoutMenu = new JMenuItem("Logout");
        menuLogout.add(logoutMenu);
        menuBar.add(menuLogout);

        setJMenuBar(menuBar);

        // Panel utama modern
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(245, 249, 255));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        JLabel iconLabel = new JLabel();
        iconLabel.setIcon(UIManager.getIcon("OptionPane.informationIcon"));
        iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(iconLabel);

        JLabel welcomeLabel = new JLabel("Selamat Datang di Aplikasi UMKM!");
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        welcomeLabel.setForeground(new Color(33, 80, 162));
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(welcomeLabel);

        JLabel infoLabel = new JLabel("Kelola data UMKM, lihat report, dan nikmati fitur modern.");
        infoLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        infoLabel.setForeground(new Color(80, 80, 80));
        infoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(infoLabel);

        JLabel authorLabel = new JLabel("by Modern Java GUI");
        authorLabel.setFont(new Font("Segoe UI", Font.ITALIC, 13));
        authorLabel.setForeground(new Color(120, 120, 120));
        authorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(authorLabel);

        add(mainPanel, BorderLayout.CENTER);

        // Event menu
        tambahMenu.addActionListener(e -> new UMKMForm());
        lihatMenu.addActionListener(e -> new UMKMTable());
        reportMenu.addActionListener(e -> new ReportFrame());
        logoutMenu.addActionListener(e -> {
            dispose();
            new LoginForm();
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}