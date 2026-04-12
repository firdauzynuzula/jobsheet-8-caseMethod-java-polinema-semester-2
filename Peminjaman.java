public class Peminjaman {
    Mahasiswa11 mahasiswa;
    Buku buku;
    int lamaPinjam;
    int batasPinjam = 5;
    int terlambat;
    int denda;

    Peminjaman(Mahasiswa11 mahasiswa, Buku buku, int lamaPinjam) {
        this(mahasiswa, buku, lamaPinjam, 5);
    }

    Peminjaman(Mahasiswa11 mahasiswa, Buku buku, int lamaPinjam, int batasPinjam) {
        this.mahasiswa = mahasiswa;
        this.buku = buku;
        this.lamaPinjam = lamaPinjam;
        this.batasPinjam = batasPinjam;
        hitungDenda();
    }

    void tampilPeminjaman() {
        System.out.println("Nama Mahasiswa: " + mahasiswa.nama
                + "|" + "Kode Buku: " + buku.kodeBuku
                + "|" + "Judul: " + buku.judul
                + "|" + "Lama Pinjam: " + lamaPinjam + " hari"
                + "|" + "Hari Terlambat: " + terlambat
                + "|" + "Denda: Rp" + denda);
    }
    
    int hitungDenda() {
        terlambat = Math.max(0, lamaPinjam - batasPinjam);
        denda = terlambat * 500;
        return denda;
    }
}
