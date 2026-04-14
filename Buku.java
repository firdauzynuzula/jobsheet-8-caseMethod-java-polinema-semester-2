public class Buku {
    String kodeBuku;
    String judul;
    int tahunTerbit;

    Buku(String kodeBuku, String judul, int tahunTerbit) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
    }

    void tampilBuku() {
        System.out.println("Kode Buku: " + kodeBuku + "|" + "Judul: " + judul + "|" + "Tahun Terbit: " + tahunTerbit);
    }

    static void tampilBukuBelumDipinjam(Buku[] bukuArray, Peminjaman[] peminjamanArray) {
        System.out.println("Daftar buku yang belum pernah dipinjam:");

        int jumlahBukuBelumDipinjam = 0;
        for (Buku buku : bukuArray) {
            if (buku == null) {
                continue;
            }

            boolean sudahDipinjam = false;
            for (Peminjaman peminjaman : peminjamanArray) {
                if (peminjaman != null
                        && peminjaman.buku != null
                        && peminjaman.buku.kodeBuku.equals(buku.kodeBuku)) {
                    sudahDipinjam = true;
                    break;
                }
            }

            if (sudahDipinjam) {
                continue;
            }

            buku.tampilBuku();
            jumlahBukuBelumDipinjam++;
        }

        if (jumlahBukuBelumDipinjam == 0) {
            System.out.println("Semua buku sudah pernah dipinjam.");
        }
    }
}
