public class Peminjaman {
    Mahasiswa11 mahasiswa;
    Buku buku;

    Peminjaman(Mahasiswa11 mahasiswa, Buku buku) {
        this.mahasiswa = mahasiswa;
        this.buku = buku;
    }

    void tampilPeminjaman() {
        System.out.println("Peminjaman Buku:");
        mahasiswa.tampilMahasiswa();
        buku.tampilBuku();
    }
    
    int hitungDenda(int hariTerlambat) {
        if (hariTerlambat > 0) {
            return  (hariTerlambat * 500);
        } else {
            return 0;
        }
    }
}
