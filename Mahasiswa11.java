public class Mahasiswa11 {
    String nim;
    String nama;
    String prodi;

    Mahasiswa11(String nim, String nama, String prodi) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
    }


    void tampilMahasiswa() {
        System.out.println("NIM: " + nim + "|" + "Nama: " + nama + "|" + "Prodi: " + prodi);
    }

    String getNim() {
        return nim;
    }

    static Mahasiswa11 sequentialSearchByNim(Mahasiswa11[] mahasiswaArray, String nimCari) {
        for (Mahasiswa11 mahasiswa : mahasiswaArray) {
            if (mahasiswa.getNim().equals(nimCari)) {
                return mahasiswa;
            }
        }
        return null;
    }
}
