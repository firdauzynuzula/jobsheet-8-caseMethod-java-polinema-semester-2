public class Main {
    public static void main(String[] args) {
        Mahasiswa11 mahasiswa1 = new Mahasiswa11("12345", "Alice", "Informatika");
        Mahasiswa11 mahasiswa2 = new Mahasiswa11("67890", "Bob", "Sistem Informasi");
        mahasiswa1.tampilMahasiswa();
        mahasiswa2.tampilMahasiswa();


        Buku[] buku = new Buku[2];
        buku[0] = new Buku("B001", "Pemrograman Java", 2020);
        buku[1] = new Buku("B002", "Struktur Data", 2019);
        buku[0].tampilBuku();
        buku[1].tampilBuku();
    }
}
