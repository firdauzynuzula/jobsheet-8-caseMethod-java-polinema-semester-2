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
}
