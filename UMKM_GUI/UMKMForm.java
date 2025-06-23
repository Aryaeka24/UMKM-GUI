import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UMKMForm extends JFrame {
    public static ArrayList<UMKM> daftarUMKM = new ArrayList<>();

    public UMKMForm() {
        setTitle("Form Tambah UMKM");
        setSize(300, 200);
        setLayout(new GridLayout(4, 2));

        JTextField namaField = new JTextField();
        JTextField jenisField = new JTextField();
        JTextField alamatField = new JTextField();
        JButton simpanBtn = new JButton("Simpan");

        simpanBtn.addActionListener(e -> {
            String nama = namaField.getText();
            String jenis = jenisField.getText();
            String alamat = alamatField.getText();

            daftarUMKM.add(new UMKM(nama, jenis, alamat));
            JOptionPane.showMessageDialog(this, "Data UMKM ditambahkan!");
            dispose();
        });

        add(new JLabel("Nama:")); add(namaField);
        add(new JLabel("Jenis Usaha:")); add(jenisField);
        add(new JLabel("Alamat:")); add(alamatField);
        add(new JLabel()); add(simpanBtn);

        setVisible(true);
        setLocationRelativeTo(null);
    }
}