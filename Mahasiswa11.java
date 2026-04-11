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
        System.out.println("NIM: " + nim);
        System.out.println("Nama: " + nama);
        System.out.println("Prodi: " + prodi);
    }   
}
