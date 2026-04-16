import java.util.Set;
import java.util.TreeSet;

public class LatihanCollection2 {
    public static void main(String[] args) {
        Set<String> daftarBuku = new TreeSet<>();
        daftarBuku.add("Dilan 1990");
        daftarBuku.add("Dilan 1991");
        daftarBuku.add("Laskar Pelangi");
        daftarBuku.add("Mahaguru");
        daftarBuku.add("Mengejar Matahari");
        daftarBuku.add("Milea");
        daftarBuku.add("Perahu Kertas");

        System.out.println("Daftar Buku secara Urut:");
        int i = 1;
        for (String b : daftarBuku) {
            System.out.println(i + ". " + b);
            i++;
        }

        System.out.println("\nBuku Mahaguru ada"); 
        if (daftarBuku.contains("Mahaguru")) {
            daftarBuku.remove("Mahaguru");
        }

        System.out.println("\nDaftar Buku setelah Mahaguru dipinjam:");
        int j = 1;
        for (String buku : daftarBuku) {
            System.out.println(j + ". " + buku);
            j++;
        }
    }
}