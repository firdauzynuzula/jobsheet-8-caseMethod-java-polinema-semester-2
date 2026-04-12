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
        System.out.println("Peminjaman Buku:");
        System.out.println("Nama Mahasiswa: " + mahasiswa.nama);
        buku.tampilBuku();
        System.out.println("Lama Pinjam: " + lamaPinjam + " hari");
        System.out.println("Batas Pinjam: " + batasPinjam + " hari");
        System.out.println("Hari Terlambat: " + terlambat);
        System.out.println("Denda: Rp" + denda);
    }
    
    int hitungDenda() {
        terlambat = Math.max(0, lamaPinjam - batasPinjam);
        denda = terlambat * 500;
        return denda;
    }
}
