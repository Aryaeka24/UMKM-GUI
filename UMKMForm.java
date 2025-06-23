import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class UMKMForm extends JFrame {
    public static ArrayList<UMKM> daftarUMKM = new ArrayList<>();

    public UMKMForm() {
        setTitle("Form Tambah UMKM");
        setSize(350, 260);
        setLayout(new BorderLayout());
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(33,80,162), 2),
            BorderFactory.createEmptyBorder(18, 18, 18, 18)));
        formPanel.setBackground(new Color(250, 252, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Tambah Data UMKM");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titleLabel.setForeground(new Color(33,80,162));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        formPanel.add(titleLabel, gbc);
        gbc.gridwidth = 1;

        gbc.gridy = 1; gbc.gridx = 0;
        JLabel namaLabel = new JLabel("Nama:");
        namaLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        formPanel.add(namaLabel, gbc);
        gbc.gridx = 1;
        JTextField namaField = new JTextField();
        formPanel.add(namaField, gbc);

        gbc.gridy = 2; gbc.gridx = 0;
        JLabel jenisLabel = new JLabel("Jenis Usaha:");
        jenisLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        formPanel.add(jenisLabel, gbc);
        gbc.gridx = 1;
        JTextField jenisField = new JTextField();
        formPanel.add(jenisField, gbc);

        gbc.gridy = 3; gbc.gridx = 0;
        JLabel alamatLabel = new JLabel("Alamat:");
        alamatLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        formPanel.add(alamatLabel, gbc);
        gbc.gridx = 1;
        JTextField alamatField = new JTextField();
        formPanel.add(alamatField, gbc);

        gbc.gridy = 4; gbc.gridx = 0; gbc.gridwidth = 2;
        JButton simpanBtn = new JButton("Simpan", UIManager.getIcon("FileView.floppyDriveIcon"));
        simpanBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        simpanBtn.setBackground(new Color(33,80,162));
        simpanBtn.setForeground(Color.WHITE);
        simpanBtn.setFocusPainted(false);
        simpanBtn.addActionListener(e -> {
            String nama = namaField.getText();
            String jenis = jenisField.getText();
            String alamat = alamatField.getText();
            if (nama.isEmpty() || jenis.isEmpty() || alamat.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            daftarUMKM.add(new UMKM(nama, jenis, alamat));
            JOptionPane.showMessageDialog(this, "Data UMKM ditambahkan!");
            dispose();
        });
        formPanel.add(simpanBtn, gbc);

        add(formPanel, BorderLayout.CENTER);

        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}