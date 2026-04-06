import java.util.Random;

class Character {
    // 1. Atribut
    String name;
    int hp;
    int attackPower;
    int defense; // Sesuai instruksi gambar, atribut defense dibuat meskipun belum dipakai di kalkulasi damage saat ini

    // 2. Constructor untuk inisialisasi semua atribut
    public Character(String name, int hp, int attackPower, int defense) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
        this.defense = defense;
    }

    // 3. Method: attack dengan tambahan mekanik RNG (50% - 100%)
    public void attack(Character target) {
        Random rand = new Random();
        
        // Menghasilkan persentase acak antara 50 hingga 100
        // rand.nextInt(51) menghasilkan angka 0-50. Ditambah 50 menjadi 50-100.
        int rngPercentage = rand.nextInt(51) + 50; 
        
        // Menghitung damage aktual berdasarkan persentase RNG
        int actualDamage = (this.attackPower * rngPercentage) / 100;

        System.out.println(">> " + this.name + " menyerang " + target.name + "!");
        System.out.println("   [Sistem RNG] Efektivitas serangan: " + rngPercentage + "%");
        System.out.println("   " + target.name + " menerima " + actualDamage + " damage.");

        // Mengurangi HP target
        target.hp -= actualDamage;
        
        // Mencegah HP menjadi angka minus (opsional tapi praktik yang baik untuk RPG)
        if (target.hp < 0) {
            target.hp = 0;
        }
        System.out.println();
    }

    // 4. Method: showStatus
    public void showStatus() {
        System.out.println("=== STATUS ===");
        System.out.println("Name : " + this.name);
        System.out.println("HP   : " + this.hp);
        System.out.println("==============\n");
    }
}

public class Main {
    public static void main(String[] args) {
        // Di Main: buat 2 object Character
        Character hero = new Character("Arthur", 1000, 200, 50);
        Character monster = new Character("Goblin", 800, 150, 30);

        System.out.println("--- PERTANDINGAN DIMULAI ---\n");

        // Tampilkan status awal
        System.out.println("[Kondisi Awal]");
        hero.showStatus();
        monster.showStatus();

        // Panggil attack() dan showStatus()
        hero.attack(monster); // Hero menyerang Monster
        monster.showStatus(); // Lihat HP Monster setelah diserang
        
        monster.attack(hero); // Monster membalas
        hero.showStatus();    // Lihat HP Hero setelah diserang
    }
}