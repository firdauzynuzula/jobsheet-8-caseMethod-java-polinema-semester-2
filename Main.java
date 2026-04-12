import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int pilihan;

        // objek mahasiswa, buku, dan peminjaman
        Mahasiswa11[] mahasiswaArray = new Mahasiswa11[3];
        mahasiswaArray[0] = new Mahasiswa11("22001", "Andi", "Teknik Informatika");
        mahasiswaArray[1] = new Mahasiswa11("22002", "Budi", "Teknik Informatika");
        mahasiswaArray[2] = new Mahasiswa11("22003", "Citra", "Sistem Informasi");

        Buku[] bukuArray = new Buku[4];
        bukuArray[0] = new Buku("B001", "Algoritma", 2020);
        bukuArray[1] = new Buku("B002", "Basis Data", 2019);
        bukuArray[2] = new Buku("B003", "Pemrograman", 2021);
        bukuArray[3] = new Buku("B004", "Fisika", 2024);

        Peminjaman[] peminjamanArray = new Peminjaman[5];
        peminjamanArray[0] = new Peminjaman(mahasiswaArray[0], bukuArray[0], 7);
        peminjamanArray[1] = new Peminjaman(mahasiswaArray[1], bukuArray[1], 3);
        peminjamanArray[2] = new Peminjaman(mahasiswaArray[2], bukuArray[2], 10);
        peminjamanArray[3] = new Peminjaman(mahasiswaArray[2], bukuArray[3], 6);
        peminjamanArray[4] = new Peminjaman(mahasiswaArray[0], bukuArray[1], 4);

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
                    Peminjaman.bubbleSortByDenda(peminjamanArray);

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

                    Mahasiswa11 mahasiswaDitemukan = Mahasiswa11.sequentialSearchByNim(mahasiswaArray, nimCari);

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
}
