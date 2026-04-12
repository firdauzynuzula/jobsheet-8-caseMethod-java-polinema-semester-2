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
        System.out.println( mahasiswa.nama
                + "|"  + buku.judul
                + "|" + "Lama Pinjam: " + lamaPinjam + " hari"
                + "|" + "Hari Terlambat: " + terlambat
                + "|" + "Denda: Rp" + denda);
    }
    
    int hitungDenda() {
        terlambat = Math.max(0, lamaPinjam - batasPinjam);
        denda = terlambat * 2000;
        return denda;
    }

    static void bubbleSortByDenda(Peminjaman[] peminjamanArray) {
        for (int i = 0; i < peminjamanArray.length - 1; i++) {
            for (int j = 0; j < peminjamanArray.length - 1 - i; j++) {
                if (peminjamanArray[j].hitungDenda() < peminjamanArray[j + 1].hitungDenda()) {
                    Peminjaman temp = peminjamanArray[j];
                    peminjamanArray[j] = peminjamanArray[j + 1];
                    peminjamanArray[j + 1] = temp;
                }
            }
        }
    }
}
