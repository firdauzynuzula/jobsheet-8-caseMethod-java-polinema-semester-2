# Penjelasan Detail Program (Buku.java sampai Main.java)

Dokumen ini menjelaskan struktur program secara berurutan mulai dari kelas data paling sederhana sampai alur utama aplikasi pada `main`.

## 1) Buku.java

Kelas `Buku` adalah model data untuk menyimpan informasi buku.

### Atribut

- `String kodeBuku`
	Menyimpan kode unik buku, contoh: `B001`.
- `String judul`
	Menyimpan judul buku, contoh: `Algoritma`.
- `int tahunTerbit`
	Menyimpan tahun terbit buku, contoh: `2020`.

Semua atribut ini bertipe default (tanpa `private/public`), artinya masih bisa diakses langsung oleh kelas lain dalam package yang sama.

### Constructor

```java
Buku(String kodeBuku, String judul, int tahunTerbit) {
		this.kodeBuku = kodeBuku;
		this.judul = judul;
		this.tahunTerbit = tahunTerbit;
}
```

Fungsi constructor:

- Menerima data awal saat objek dibuat.
- `this.kodeBuku = kodeBuku;` berarti atribut milik objek diisi dari parameter constructor.

Contoh pembuatan objek:

```java
Buku buku1 = new Buku("B001", "Algoritma", 2020);
```

### Method tampilBuku

```java
void tampilBuku() {
		System.out.println("Kode Buku: " + kodeBuku + "|" + "Judul: " + judul + "|" + "Tahun Terbit: " + tahunTerbit);
}
```

Method ini menampilkan data buku ke console dalam 1 baris.

Output kira-kira:

`Kode Buku: B001|Judul: Algoritma|Tahun Terbit: 2020`

## 2) Mahasiswa11.java

Kelas `Mahasiswa11` adalah model data mahasiswa, sekaligus menyediakan method pencarian berdasarkan NIM.

### Atribut

- `String nim`
	Nomor induk mahasiswa, dipakai sebagai kunci pencarian.
- `String nama`
	Nama mahasiswa.
- `String prodi`
	Program studi mahasiswa.

### Constructor

```java
Mahasiswa11(String nim, String nama, String prodi) {
		this.nim = nim;
		this.nama = nama;
		this.prodi = prodi;
}
```

Objek mahasiswa harus dibuat dengan 3 data tersebut.

### Method tampilMahasiswa

```java
void tampilMahasiswa() {
		System.out.println("NIM: " + nim + "|" + "Nama: " + nama + "|" + "Prodi: " + prodi);
}
```

Menampilkan satu data mahasiswa dalam format ringkas.

### Method getNim

```java
String getNim() {
		return nim;
}
```

Getter sederhana untuk mengambil nilai `nim`. Digunakan oleh method pencarian agar akses lebih terstruktur.

### Method static sequentialSearchByNim

```java
static Mahasiswa11 sequentialSearchByNim(Mahasiswa11[] mahasiswaArray, String nimCari) {
		for (Mahasiswa11 mahasiswa : mahasiswaArray) {
				if (mahasiswa.getNim().equals(nimCari)) {
						return mahasiswa;
				}
		}
		return null;
}
```

Penjelasan:

- `static` berarti method dipanggil lewat nama kelas, tidak perlu objek baru.
- `sequential search` (linear search) = cek elemen satu per satu dari awal sampai akhir.
- Perbandingan NIM pakai `equals(...)` karena bertipe `String`.
- Jika ketemu, langsung mengembalikan objek mahasiswa itu.
- Jika tidak ada yang cocok, hasilnya `null`.

Kompleksitas waktu:

- Terbaik: $O(1)$ (data ketemu di awal).
- Terburuk: $O(n)$ (data di akhir atau tidak ditemukan).

## 3) Peminjaman.java

Kelas `Peminjaman` menyimpan relasi mahasiswa dan buku yang dipinjam, termasuk perhitungan denda dan pengurutan berdasarkan denda.

### Atribut

- `Mahasiswa11 mahasiswa`
	Referensi ke peminjam.
- `Buku buku`
	Referensi ke buku yang dipinjam.
- `int lamaPinjam`
	Lama peminjaman (hari).
- `int batasPinjam = 5`
	Batas pinjam default 5 hari.
- `int terlambat`
	Jumlah hari keterlambatan.
- `int denda`
	Nilai denda dalam rupiah.

### Constructor Overloading

Program memakai 2 constructor:

1. Constructor 3 parameter:

```java
Peminjaman(Mahasiswa11 mahasiswa, Buku buku, int lamaPinjam) {
		this(mahasiswa, buku, lamaPinjam, 5);
}
```

Artinya jika batas pinjam tidak diberikan, otomatis pakai 5 hari.

2. Constructor 4 parameter:

```java
Peminjaman(Mahasiswa11 mahasiswa, Buku buku, int lamaPinjam, int batasPinjam) {
		this.mahasiswa = mahasiswa;
		this.buku = buku;
		this.lamaPinjam = lamaPinjam;
		this.batasPinjam = batasPinjam;
		hitungDenda();
}
```

Constructor ini mengisi semua data dan langsung memanggil `hitungDenda()` supaya nilai `terlambat` dan `denda` langsung siap.

### Method hitungDenda

```java
int hitungDenda() {
		terlambat = Math.max(0, lamaPinjam - batasPinjam);
		denda = terlambat * 2000;
		return denda;
}
```

Rumus:

- $terlambat = \max(0, lamaPinjam - batasPinjam)$
- $denda = terlambat \times 2000$

Contoh:

- `lamaPinjam = 7`, `batasPinjam = 5`
- `terlambat = max(0, 7 - 5) = 2`
- `denda = 2 * 2000 = 4000`

`Math.max(0, ...)` mencegah nilai keterlambatan menjadi negatif.

### Method tampilPeminjaman

```java
void tampilPeminjaman() {
		System.out.println( mahasiswa.nama
						+ "|"  + buku.judul
						+ "|" + "Lama Pinjam: " + lamaPinjam + " hari"
						+ "|" + "Hari Terlambat: " + terlambat
						+ "|" + "Denda: Rp" + denda);
}
```

Menampilkan ringkasan peminjaman: nama mahasiswa, judul buku, lama pinjam, hari terlambat, dan denda.

### Method static bubbleSortByDenda

```java
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
```

Konsep:

- Bubble sort melakukan perbandingan berpasangan antar-elemen bersebelahan.
- Jika elemen kiri punya denda lebih kecil dari kanan, maka ditukar.
- Karena kondisi pakai `<`, hasil akhir urutan dari denda terbesar ke terkecil (descending).

Kompleksitas:

- Waktu rata-rata/terburuk: $O(n^2)$
- Ruang tambahan: $O(1)$

Catatan penting:

- Di dalam perbandingan, method `hitungDenda()` dipanggil lagi. Ini aman karena `hitungDenda()` deterministik untuk data yang sama, dan sekaligus menjaga nilai `denda` tetap sinkron.

## 4) Main.java

Kelas `Main` adalah pusat eksekusi program: inisialisasi data, menampilkan menu, menerima input user, dan menjalankan fitur sesuai pilihan.

### Import

```java
import java.util.Scanner;
```

Dipakai untuk membaca input dari keyboard.

### Method main

```java
public static void main(String[] args) {
		...
}
```

Ini entry point program Java.

### Inisialisasi Scanner dan variabel menu

```java
Scanner scanner = new Scanner(System.in);
int pilihan;
```

- `scanner` membaca angka dan teks dari user.
- `pilihan` menyimpan menu yang dipilih user.

### Inisialisasi data awal

1. Array mahasiswa:

```java
Mahasiswa11[] mahasiswaArray = new Mahasiswa11[3];
```

Diisi 3 mahasiswa:

- 22001 Andi
- 22002 Budi
- 22003 Citra

2. Array buku:

```java
Buku[] bukuArray = new Buku[4];
```

Diisi 4 buku:

- B001 Algoritma
- B002 Basis Data
- B003 Pemrograman
- B004 Fisika

3. Array peminjaman:

```java
Peminjaman[] peminjamanArray = new Peminjaman[5];
```

Diisi 5 transaksi dengan kombinasi mahasiswa-buku-lama pinjam.

### Tampilan menu

Program menampilkan opsi:

- 1 Tampilkan Mahasiswa
- 2 Tampilkan Buku
- 3 Tampilkan Peminjaman
- 4 Urutkan berdasarkan denda
- 5 Cari berdasarkan NIM
- 0 Keluar

### Loop utama (do-while)

```java
do {
		...
} while (pilihan != 0);
```

Makna:

- Program minimal menjalankan 1 kali siklus menu.
- Selama user tidak memilih `0`, menu akan terus diulang.

### Switch-case per fitur

#### Case 1: Tampilkan Mahasiswa

Loop semua elemen `mahasiswaArray`, lalu panggil `tampilMahasiswa()`.

#### Case 2: Tampilkan Buku

Loop semua elemen `bukuArray`, lalu panggil `tampilBuku()`.

#### Case 3: Tampilkan Peminjaman

Loop semua elemen `peminjamanArray`, lalu panggil `tampilPeminjaman()`.

#### Case 4: Urutkan Berdasarkan Denda

Langkah:

1. Panggil `Peminjaman.bubbleSortByDenda(peminjamanArray)`.
2. Array `peminjamanArray` berubah urutan (in-place) dari denda terbesar ke terkecil.
3. Cetak hasil urutan dengan label `Urutan 1`, `Urutan 2`, dst.

#### Case 5: Cari Berdasarkan NIM

Langkah:

1. Input NIM dari user.
2. Panggil `Mahasiswa11.sequentialSearchByNim(mahasiswaArray, nimCari)`.
3. Jika hasil tidak `null`, cetak data mahasiswa.
4. Jika `null`, tampilkan pesan NIM tidak ditemukan.

#### Case 0: Keluar

Program mencetak pesan keluar, lalu loop berhenti.

#### Default

Jika input di luar menu valid, tampilkan pesan kesalahan dan minta input ulang.

### Menutup scanner

```java
scanner.close();
```

Menutup resource input setelah loop selesai.

## 5) Alur Data Antar Kelas

Ringkasnya, hubungan antar kelas seperti ini:

1. `Main` membuat objek `Mahasiswa11` dan `Buku`.
2. `Main` membuat objek `Peminjaman` yang berisi referensi ke `Mahasiswa11` dan `Buku`.
3. `Peminjaman` menghitung `denda` dari `lamaPinjam` dan `batasPinjam`.
4. `Main` memanggil method:
	 - tampil data (`tampilMahasiswa`, `tampilBuku`, `tampilPeminjaman`)
	 - urut data (`bubbleSortByDenda`)
	 - cari data (`sequentialSearchByNim`)

Jadi desain program ini adalah kombinasi:

- Pemodelan objek (OOP dasar: class, object, constructor, method).
- Struktur data array.
- Algoritma pencarian linear search.
- Algoritma pengurutan bubble sort.

 # Kesimpulan

Program ini merupakan contoh sederhana dari aplikasi perpustakaan yang mengelola data mahasiswa, buku, dan peminjaman. Dengan menggunakan konsep OOP, program ini memisahkan tanggung jawab ke dalam kelas-kelas yang berbeda, sehingga lebih terstruktur dan mudah dipahami. Fitur pencarian dan pengurutan memberikan nilai tambah untuk mengelola data dengan lebih efektif.