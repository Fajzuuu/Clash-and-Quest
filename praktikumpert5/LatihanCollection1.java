import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class LatihanCollection1 {
    public static void main(String[] args) {
        Set<String> daftarBuku = new TreeSet<>();

        //data buku
        daftarBuku.add("Dilan 1990");
        daftarBuku.add("Laskar Pelangi");
        daftarBuku.add("Mahaguru");
        daftarBuku.add("Mengejar Matahari");
        daftarBuku.add("Dilan 1991");
        daftarBuku.add("Milea");
        daftarBuku.add("Perahu Kertas");
        daftarBuku.add("Laskar Pelangi"); // Dupikat
        daftarBuku.add("Perahu Kertas"); // Duplikat

        System.out.println("Daftar Buku:");
        
        int no = 1;
        Iterator<String> it = daftarBuku.iterator();
        while (it.hasNext()) {
            System.out.println(no + ". " + it.next());
            no++;
        }
    }
}