import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class UMKMTable extends JFrame {
    public UMKMTable() {
        setTitle("Data UMKM");
        setSize(400, 300);
        String[] kolom = {"Nama", "Jenis Usaha", "Alamat"};
        DefaultTableModel model = new DefaultTableModel(kolom, 0);

        for (UMKM u : UMKMForm.daftarUMKM) {
            Object[] baris = {u.getNama(), u.getJenis(), u.getAlamat()};
            model.addRow(baris);
        }

        JTable tabel = new JTable(model);
        add(new JScrollPane(tabel), BorderLayout.CENTER);

        setVisible(true);
        setLocationRelativeTo(null);
    }
}