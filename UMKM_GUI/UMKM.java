public class UMKM {
    private String nama;
    private String jenis;
    private String alamat;

    public UMKM(String nama, String jenis, String alamat) {
        this.nama = nama;
        this.jenis = jenis;
        this.alamat = alamat;
    }

    public String getNama() { return nama; }
    public String getJenis() { return jenis; }
    public String getAlamat() { return alamat; }
}