import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class UMKMTable extends JFrame {
    public UMKMTable() {
        setTitle("Data UMKM");
        setSize(520, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(33,80,162), 2),
            BorderFactory.createEmptyBorder(12, 12, 12, 12)));
        panel.setBackground(new Color(250, 252, 255));

        JLabel title = new JLabel("Data UMKM");
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        title.setForeground(new Color(33,80,162));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(title, BorderLayout.NORTH);

        // Filter
        JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        filterPanel.setBackground(new Color(250, 252, 255));
        JLabel filterLabel = new JLabel("Cari:");
        JTextField filterField = new JTextField(18);
        filterPanel.add(filterLabel);
        filterPanel.add(filterField);
        panel.add(filterPanel, BorderLayout.BEFORE_FIRST_LINE);

        String[] kolom = {"Nama", "Jenis Usaha", "Alamat", "Edit", "Hapus"};
        DefaultTableModel model = new DefaultTableModel(kolom, 0) {
            public boolean isCellEditable(int row, int col) {
                return col == 3 || col == 4;
            }
        };

        for (UMKM u : UMKMForm.daftarUMKM) {
            Object[] baris = {u.getNama(), u.getJenis(), u.getAlamat(), "Edit", "Hapus"};
            model.addRow(baris);
        }

        JTable tabel = new JTable(model);
        tabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tabel.setRowHeight(28);
        tabel.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        tabel.setSelectionBackground(new Color(220, 230, 250));
        tabel.setSelectionForeground(Color.BLACK);

        // Zebra striping
        tabel.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (!isSelected) {
                    c.setBackground(row % 2 == 0 ? new Color(245,249,255) : Color.WHITE);
                }
                return c;
            }
        });

        // Tombol edit/hapus
        tabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = tabel.rowAtPoint(e.getPoint());
                int col = tabel.columnAtPoint(e.getPoint());
                if (col == 3) { // Edit
                    UMKM u = UMKMForm.daftarUMKM.get(row);
                    JTextField namaField = new JTextField(u.getNama());
                    JTextField jenisField = new JTextField(u.getJenis());
                    JTextField alamatField = new JTextField(u.getAlamat());
                    JPanel panelEdit = new JPanel(new GridLayout(3,2));
                    panelEdit.add(new JLabel("Nama:")); panelEdit.add(namaField);
                    panelEdit.add(new JLabel("Jenis Usaha:")); panelEdit.add(jenisField);
                    panelEdit.add(new JLabel("Alamat:")); panelEdit.add(alamatField);
                    int result = JOptionPane.showConfirmDialog(UMKMTable.this, panelEdit, "Edit UMKM", JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.OK_OPTION) {
                        if (namaField.getText().isEmpty() || jenisField.getText().isEmpty() || alamatField.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(UMKMTable.this, "Semua field harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        UMKM newU = new UMKM(namaField.getText(), jenisField.getText(), alamatField.getText());
                        UMKMForm.daftarUMKM.set(row, newU);
                        model.setValueAt(newU.getNama(), row, 0);
                        model.setValueAt(newU.getJenis(), row, 1);
                        model.setValueAt(newU.getAlamat(), row, 2);
                    }
                } else if (col == 4) { // Hapus
                    int confirm = JOptionPane.showConfirmDialog(UMKMTable.this, "Yakin hapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        UMKMForm.daftarUMKM.remove(row);
                        model.removeRow(row);
                    }
                }
            }
        });

        // Filter pencarian
        filterField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String text = filterField.getText().toLowerCase();
                model.setRowCount(0);
                for (UMKM u : UMKMForm.daftarUMKM) {
                    if (u.getNama().toLowerCase().contains(text) ||
                        u.getJenis().toLowerCase().contains(text) ||
                        u.getAlamat().toLowerCase().contains(text)) {
                        model.addRow(new Object[]{u.getNama(), u.getJenis(), u.getAlamat(), "Edit", "Hapus"});
                    }
                }
            }
        });

        JScrollPane scroll = new JScrollPane(tabel);
        panel.add(scroll, BorderLayout.CENTER);
        add(panel, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}