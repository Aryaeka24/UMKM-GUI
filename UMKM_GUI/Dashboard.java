import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {
    public Dashboard() {
        setTitle("Dashboard UMKM");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton tambahBtn = new JButton("Tambah UMKM");
        JButton lihatBtn = new JButton("Lihat Data UMKM");

        tambahBtn.addActionListener(e -> new UMKMForm());
        lihatBtn.addActionListener(e -> new UMKMTable());

        add(tambahBtn);
        add(lihatBtn);

        setVisible(true);
        setLocationRelativeTo(null);
    }
}