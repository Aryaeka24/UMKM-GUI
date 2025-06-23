import java.awt.*;
import java.util.HashMap;
import javax.swing.*;

public class ReportFrame extends JFrame {
    public ReportFrame() {
        setTitle("Report UMKM");
        setSize(370, 300);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(33,80,162), 2),
            BorderFactory.createEmptyBorder(18, 18, 18, 18)));
        mainPanel.setBackground(new Color(250, 252, 255));

        JLabel title = new JLabel("Laporan Data UMKM");
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        title.setForeground(new Color(33,80,162));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(title);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 18)));

        int total = UMKMForm.daftarUMKM.size();
        HashMap<String, Integer> rekap = new HashMap<>();
        for (UMKM u : UMKMForm.daftarUMKM) {
            rekap.put(u.getJenis(), rekap.getOrDefault(u.getJenis(), 0) + 1);
        }

        // Card Total UMKM dengan icon
        JPanel cardTotal = new JPanel();
        cardTotal.setBackground(new Color(220, 230, 250));
        cardTotal.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(33,80,162), 1),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        cardTotal.setLayout(new BoxLayout(cardTotal, BoxLayout.X_AXIS));
        JLabel totalIcon = new JLabel(UIManager.getIcon("FileView.directoryIcon"));
        totalIcon.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
        cardTotal.add(totalIcon);
        JLabel totalLabel = new JLabel("Total UMKM: " + total);
        totalLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        totalLabel.setForeground(new Color(33,80,162));
        cardTotal.add(totalLabel);
        mainPanel.add(cardTotal);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 18)));

        // Card Jenis Usaha dengan icon
        JPanel cardJenis = new JPanel();
        cardJenis.setLayout(new BoxLayout(cardJenis, BoxLayout.Y_AXIS));
        cardJenis.setBackground(new Color(245,249,255));
        cardJenis.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(180,200,240), 1),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        JPanel jenisTitlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        jenisTitlePanel.setOpaque(false);
        JLabel jenisIcon = new JLabel(UIManager.getIcon("FileView.fileIcon"));
        jenisIcon.setBorder(BorderFactory.createEmptyBorder(0,0,0,8));
        jenisTitlePanel.add(jenisIcon);
        JLabel jenisTitle = new JLabel("Rekap per Jenis Usaha:");
        jenisTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        jenisTitle.setForeground(new Color(33,80,162));
        jenisTitlePanel.add(jenisTitle);
        cardJenis.add(jenisTitlePanel);
        for (String jenis : rekap.keySet()) {
            JLabel jenisLabel = new JLabel(jenis + ": " + rekap.get(jenis));
            jenisLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            cardJenis.add(jenisLabel);
        }
        mainPanel.add(cardJenis);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 18)));

        // Top 3 lokasi terbanyak
        HashMap<String, Integer> lokasiCount = new HashMap<>();
        for (UMKM u : UMKMForm.daftarUMKM) {
            String lokasi = u.getAlamat().trim();
            if (!lokasi.isEmpty()) {
                lokasiCount.put(lokasi, lokasiCount.getOrDefault(lokasi, 0) + 1);
            }
        }
        java.util.List<String> topLokasi = new java.util.ArrayList<>(lokasiCount.keySet());
        topLokasi.sort((a, b) -> lokasiCount.get(b) - lokasiCount.get(a));
        // Card Lokasi dengan icon
        JPanel cardLokasi = new JPanel();
        cardLokasi.setLayout(new BoxLayout(cardLokasi, BoxLayout.Y_AXIS));
        cardLokasi.setBackground(new Color(255, 249, 230));
        cardLokasi.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(255, 200, 80), 1),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        JPanel lokasiTitlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        lokasiTitlePanel.setOpaque(false);
        JLabel lokasiIcon = new JLabel(UIManager.getIcon("FileView.hardDriveIcon"));
        lokasiIcon.setBorder(BorderFactory.createEmptyBorder(0,0,0,8));
        lokasiTitlePanel.add(lokasiIcon);
        JLabel lokasiTitle = new JLabel("Top 3 Lokasi UMKM Terbanyak:");
        lokasiTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lokasiTitle.setForeground(new Color(200, 120, 33));
        lokasiTitlePanel.add(lokasiTitle);
        cardLokasi.add(lokasiTitlePanel);
        int max = Math.min(3, topLokasi.size());
        for (int i = 0; i < max; i++) {
            String lokasi = topLokasi.get(i);
            JLabel lokasiLabel = new JLabel((i+1)+". "+lokasi+" ("+lokasiCount.get(lokasi)+" UMKM)");
            lokasiLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            cardLokasi.add(lokasiLabel);
        }
        if (max == 0) {
            JLabel noneLabel = new JLabel("Belum ada data lokasi.");
            noneLabel.setFont(new Font("Segoe UI", Font.ITALIC, 12));
            cardLokasi.add(noneLabel);
        }
        mainPanel.add(cardLokasi);

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);
    }
} 