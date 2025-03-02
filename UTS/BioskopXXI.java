// Nama: Dyah Ayu Nurshella Ramhan
// NIM: 2309106092
//Mata Kuliah: Pemrograman Berorientasi Objek
// Deskripsi: Program ini merupakan simulasi sistem pemesanan tiket bioskop sederhana. Program ini memiliki dua jenis pengguna, yaitu pengguna biasa dan admin. Pengguna biasa dapat melihat daftar film yang tersedia, melihat jadwal tayang, membeli tiket, dan melihat tiket yang telah dibeli. Sedangkan admin dapat menambahkan film baru, menambahkan jadwal tayang, melihat semua pembelian tiket, dan kembali ke menu pengguna biasa. Program ini menggunakan konsep OOP (Object-Oriented Programming) dengan menerapkan enkapsulasi, inheritance, dan polymorphism.


//Username Admin: adminXXI
//Password Admin: XXI

// Import library
import java.util.*;

// Kelas Film merepresentasikan entitas film
class Film {
    // Enkapsulasi: atribut di-private
    private String judul;
    private String genre;
    private int durasi; // Durasi dalam menit

    // Konstruktor
    public Film(String judul, String genre, int durasi) {
        this.judul = judul;
        this.genre = genre;
        this.durasi = durasi;
    }

    // Getter
    public String getJudul() {
        return judul;
    }

    public String getGenre() {
        return genre;
    }

    public int getDurasi() {
        return durasi;
    }

    // Method untuk menampilkan informasi film
    public void displayInfo() {
        System.out.println("Judul: " + judul);
        System.out.println("Genre: " + genre);
        System.out.println("Durasi: " + durasi + " menit");
        System.out.println("-----------------------------");
    }
}

// Kelas JadwalTayang merepresentasikan jadwal tayang film
class JadwalTayang {
    private Film film;
    private String waktuTayang;
    private double hargaTiket;

    // Konstruktor
    public JadwalTayang(Film film, String waktuTayang, double hargaTiket) {
        this.film = film;
        this.waktuTayang = waktuTayang;
        this.hargaTiket = hargaTiket;
    }

    // Getter
    public Film getFilm() {
        return film;
    }

    public String getWaktuTayang() {
        return waktuTayang;
    }

    public double getHargaTiket() {
        return hargaTiket;
    }

    // Method untuk menampilkan informasi jadwal tayang
    public void displayInfo() {
        System.out.println("Film: " + film.getJudul());
        System.out.println("Waktu Tayang: " + waktuTayang);
        System.out.println("Harga Tiket: Rp" + hargaTiket);
        System.out.println("-----------------------------");
    }
}

// Kelas Bioskop untuk mengelola film dan jadwal tayang
class Bioskop {
    private ArrayList<Film> daftarFilm;
    private ArrayList<JadwalTayang> daftarJadwal;

    // konstruktor
    public Bioskop() {
        daftarFilm = new ArrayList<>();
        daftarJadwal = new ArrayList<>();
    }

    // Menambahkan film ke daftar film
    public void tambahFilm(Film film) {
        daftarFilm.add(film);
        System.out.println("Film '" + film.getJudul() + "' berhasil ditambahkan!");
    }

    // Menambahkan jadwal tayang ke daftar jadwal
    public void tambahJadwalTayang(JadwalTayang jadwal) {
        daftarJadwal.add(jadwal);
        System.out.println("Jadwal tayang untuk film '" + jadwal.getFilm().getJudul() + "' berhasil ditambahkan!");
    }

    // Menampilkan semua film yang tersedia
    public void displaySemuaFilm() {
        if (daftarFilm.isEmpty()) {
            System.out.println("Tidak ada film dalam daftar.");
        } else {
            System.out.println("\n=== Daftar Film ===");
            for (Film film : daftarFilm) {
                film.displayInfo();
            }
        }
    }

    // Menampilkan semua jadwal tayang
    public void displaySemuaJadwal() {
        if (daftarJadwal.isEmpty()) {  // Memperbaiki kesalahan variabel
            System.out.println("Tidak ada jadwal tayang.");
        } else {
            System.out.println("\n=== Jadwal Tayang ===");
            for (JadwalTayang jadwal : daftarJadwal) {  // Memperbaiki kesalahan variabel
                jadwal.displayInfo();
            }
        }
    }

    // Getter untuk daftar film
    public ArrayList<Film> getDaftarFilm() {
        return daftarFilm;
    }
}

// Kelas User merepresentasikan pengguna
class User {
    private String username;
    private String password;
    private boolean isAdmin;
    private ArrayList<String> tiketDibeli;

    // Konstruktor
    public User(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.tiketDibeli = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void beliTiket(String tiket) {
        tiketDibeli.add(tiket);
    }

    public void displayTiketDibeli() {
        if (tiketDibeli.isEmpty()) {
            System.out.println("Belum ada tiket yang dibeli.");
        } else {
            System.out.println("Tiket yang telah dibeli:");
            for (String tiket : tiketDibeli) {
                System.out.println("- " + tiket);
            }
        }
    }
}

public class BioskopXXI {
    private static HashMap<String, User> users = new HashMap<>();
    private static Bioskop bioskop = new Bioskop();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        users.put("adminXXI", new User("admin", "XXI", true));
        
        // Panggil method untuk mengisi data awal
        isiDataAwal(); 

        while (true) {
            System.out.println("\n===== Selamat Datang di Bioskop XXI Samarinda Square ======");
            System.out.println("|                      1. Registrasi                      |");
            System.out.println("|                      2. Login                           |");
            System.out.println("|                      3. Keluar                          |");
            System.out.println("===========================================================");
            System.out.print("Pilih opsi: ");
            int opsi = scanner.nextInt();
            scanner.nextLine();

            switch (opsi) {
                case 1:
                    registrasi();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("Terima kasih telah menggunakan sistem ini.");
                    return;
                default:
                    System.out.println("Opsi tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void registrasi() {
        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();
        if (users.containsKey(username)) {
            System.out.println("Username sudah terdaftar!");
            return;
        }
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();
        users.put(username, new User(username, password, false));
        System.out.println("Registrasi berhasil! Silakan login.");
    }

    private static void login() {
        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        User user = users.get(username);
        if (user != null && user.checkPassword(password)) {
            System.out.println("Login berhasil! Selamat datang, " + username);
            if (user.isAdmin()) {
                menuAdmin(user);
            } else {
                menuUser(user);
            }
        } else {
            System.out.println("Username atau password salah!");
        }
    }

    private static void inputFilm() {
        System.out.print("Masukkan judul film: ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan genre film: ");
        String genre = scanner.nextLine();
        System.out.print("Masukkan durasi film (menit): ");
        int durasi = scanner.nextInt();
        scanner.nextLine();

        Film film = new Film(judul, genre, durasi);
        bioskop.tambahFilm(film);
    }

    private static void tambahJadwal() {
        System.out.print("Masukkan judul film yang ingin dijadwalkan: ");
        String judul = scanner.nextLine();
        
        Film filmDitemukan = null;
        for (Film film : bioskop.getDaftarFilm()) {
            if (film.getJudul().equalsIgnoreCase(judul)) {
                filmDitemukan = film;
                break;
            }
        }

        if (filmDitemukan == null) {
            System.out.println("Film tidak ditemukan!");
            return;
        }

        System.out.print("Masukkan waktu tayang (HH:MM): ");
        String waktuTayang = scanner.nextLine();
        System.out.print("Masukkan harga tiket: ");
        double hargaTiket = scanner.nextDouble();
        scanner.nextLine();

        JadwalTayang jadwal = new JadwalTayang(filmDitemukan, waktuTayang, hargaTiket);
        bioskop.tambahJadwalTayang(jadwal);
    }

    private static void isiDataAwal() {
        // Menambahkan beberapa film
        Film film1 = new Film("Avengers: Endgame", "Action", 180);
        Film film2 = new Film("Inception", "Sci-Fi", 148);
        Film film3 = new Film("The Shawshank Redemption", "Drama", 142);
        Film film4 = new Film("The Dark Knight", "Action", 152);
        Film film5 = new Film("Interstellar", "Sci-Fi", 169);
        Film film6 = new Film("The Godfather", "Crime", 175);
        Film film7 = new Film("Jumanji", "Action comedy", 150);
        
        bioskop.tambahFilm(film1);
        bioskop.tambahFilm(film2);
        bioskop.tambahFilm(film3);
        bioskop.tambahFilm(film4);
        bioskop.tambahFilm(film5);
        bioskop.tambahFilm(film6);
        bioskop.tambahFilm(film7);

        // Menambahkan jadwal tayang
        bioskop.tambahJadwalTayang(new JadwalTayang(film1, "18:00", 50000));
        bioskop.tambahJadwalTayang(new JadwalTayang(film2, "20:00", 45000));
        bioskop.tambahJadwalTayang(new JadwalTayang(film3, "22:00", 40000));
        bioskop.tambahJadwalTayang(new JadwalTayang(film4, "19:00", 55000));
        bioskop.tambahJadwalTayang(new JadwalTayang(film5, "21:00", 48000));
        bioskop.tambahJadwalTayang(new JadwalTayang(film6, "23:00", 60000));
        bioskop.tambahJadwalTayang(new JadwalTayang(film7, "17:00", 45000));

        System.out.println("Data film dan jadwal tayang berhasil ditambahkan!");
    }

    private static void menuUser(User user) {
        while (true) {
            System.out.println("\n=========== Menu Pengguna ============");
            System.out.println("(   1. Tampilkan Semua Film           )");
            System.out.println("(   2. Tampilkan Semua Jadwal Tayang  )");
            System.out.println("(   3. Beli Tiket                     )");
            System.out.println("(   4. Lihat Tiket Saya               )");
            System.out.println("(   5. Logout                         )");
            System.out.println("=======================================");
            System.out.print("Pilih opsi: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    bioskop.displaySemuaFilm();
                    break;
                case 2:
                    bioskop.displaySemuaJadwal();
                    break;
                case 3:
                    beliTiket(user);
                    break;
                case 4:
                    user.displayTiketDibeli();
                    break;
                case 5:
                    System.out.println("Logout berhasil!");
                    return;
                default:
                    System.out.println("Opsi tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void menuAdmin(User user) {
        while (true) {
            System.out.println("\n============ Menu Admin ============");
            System.out.println("      1. Input Film Baru              ");
            System.out.println("      2. Tambah Jadwal Tayang         ");
            System.out.println("      3. Lihat Semua Pembelian Tiket  ");
            System.out.println("      4. Kembali ke Menu User         ");
            System.out.println("      5. Logout                       ");
            System.out.println("=====================================");
            System.out.print("Pilih opsi: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    inputFilm();
                    break;
                case 2:
                    tambahJadwal();
                    break;
                case 3:
                    lihatSemuaPembelian();
                    break;
                case 4:
                    menuUser(user);
                    return;
                case 5:
                    System.out.println("Logout berhasil!");
                    return;
                default:
                    System.out.println("Opsi tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void beliTiket(User user) {
        System.out.print("Masukkan judul film: ");
        String judulFilm = scanner.nextLine();
        System.out.print("Masukkan waktu tayang (HH:MM): ");
        String waktuTayang = scanner.nextLine();
        String tiket = "Film: " + judulFilm + " | Waktu: " + waktuTayang;
        user.beliTiket(tiket);
        System.out.println("Tiket berhasil dibeli!");
    }

    private static void lihatSemuaPembelian() {
        System.out.println("\n=== Semua Pembelian Tiket ===");
        for (User user : users.values()) {
            if (!user.isAdmin()) {
                System.out.println("User: " + user.getUsername());
                user.displayTiketDibeli();
                System.out.println("-----------------------------");
            }
        }
    }
}
