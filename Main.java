import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int pilihan;

        // objek mahasiswa, buku, dan peminjaman
        Mahasiswa11[] mahasiswaArray = new Mahasiswa11[3];
        mahasiswaArray[0] = new Mahasiswa11("12345", "Alice", "Informatika");
        mahasiswaArray[1] = new Mahasiswa11("67890", "Bob", "Sistem Informasi");
        mahasiswaArray[2] = new Mahasiswa11("54321", "Charlie", "Teknik Komputer");

        Buku[] bukuArray = new Buku[3];
        bukuArray[0] = new Buku("B001", "Algoritma dan Struktur Data", 2022);
        bukuArray[1] = new Buku("B002", "Basis Data", 2021);
        bukuArray[2] = new Buku("B003", "Pemrograman Berorientasi Objek", 2023);

        Peminjaman[] peminjamanArray = new Peminjaman[3];
        peminjamanArray[0] = new Peminjaman(mahasiswaArray[0], bukuArray[0], 8);
        peminjamanArray[1] = new Peminjaman(mahasiswaArray[1], bukuArray[1], 6);
        peminjamanArray[2] = new Peminjaman(mahasiswaArray[2], bukuArray[2], 5);

        System.out.println("=== SISTEM PEMINJAMAN RUANG BACA JTI ===");
        System.out.println("1. Tampilkan Mahasiswa");
        System.out.println("2. Tampilkan Buku");
        System.out.println("3. Tampilkan Peminjaman");
        System.out.println("4. Urutkan Berdasarkan denda");
        System.out.println("5. Cari Berdasarkan NIM");
        System.out.println("0. Keluar");

        do {
            System.out.print("Masukkan pilihan: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    // Tampilkan Mahasiswa
                    System.out.println("Daftar Mahasiswa:");
                    for (Mahasiswa11 mahasiswa : mahasiswaArray) {
                        mahasiswa.tampilMahasiswa();
                    }
                    break;
                case 2:
                    // Tampilkan Buku
                    System.out.println("Daftar Buku:");
                    for (Buku buku : bukuArray) {
                        buku.tampilBuku();
                    }
                    break;
                case 3:
                    // Tampilkan Peminjaman
                    System.out.println("Daftar Peminjaman:");
                    for (Peminjaman peminjaman : peminjamanArray) {
                        peminjaman.tampilPeminjaman();
                    }
                    break;
                case 4:
                    // Urutkan Berdasarkan denda
                    insertionSortPeminjamanByDenda(peminjamanArray);

                    System.out.println("Data peminjaman berdasarkan denda (terbesar ke terkecil):");
                    for (int i = 0; i < peminjamanArray.length; i++) {
                        System.out.println("Urutan " + (i + 1));
                        peminjamanArray[i].tampilPeminjaman();
                    }
                    break;
                case 5:
                    // Cari Berdasarkan NIM
                    System.out.print("Masukkan NIM yang dicari: ");
                    String nimCari = scanner.next();

                    Mahasiswa11 mahasiswaDitemukan = sequentialSearchMahasiswaByNim(mahasiswaArray, nimCari);

                    if (mahasiswaDitemukan != null) {
                        System.out.println("Mahasiswa ditemukan:");
                        mahasiswaDitemukan.tampilMahasiswa();
                    } else {
                        System.out.println("NIM tidak ditemukan.");
                    }

                    break;
                case 0:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 0);

        scanner.close();
    }

    static void insertionSortPeminjamanByDenda(Peminjaman[] peminjamanArray) {
        for (int i = 1; i < peminjamanArray.length; i++) {
            Peminjaman keyPeminjaman = peminjamanArray[i];
            int keyDenda = keyPeminjaman.hitungDenda();

            int j = i - 1;
            while (j >= 0 && peminjamanArray[j].hitungDenda() < keyDenda) {
                peminjamanArray[j + 1] = peminjamanArray[j];
                j--;
            }

            peminjamanArray[j + 1] = keyPeminjaman;
        }
    }

    static Mahasiswa11 sequentialSearchMahasiswaByNim(Mahasiswa11[] mahasiswaArray, String nimCari) {
        for (Mahasiswa11 mahasiswa : mahasiswaArray) {
            if (mahasiswa.getNim().equals(nimCari)) {
                return mahasiswa;
            }
        }
        return null;
    }
}
