import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // --- Tambahan Menu CLI ---
        System.out.println(">>=======================================================================<<");
        System.out.println("||      ____ _           _        ___      ___                  _        ||");
        System.out.println("||     / ___| | __ _ ___| |__    ( _ )    / _ \\ _   _  ___  ___| |_      ||");
        System.out.println("||    | |   | |/ _` / __| '_ \\   / _ \\/\\ | | | | | | |/ _ \\/ __| __|     ||");
        System.out.println("||    | |___| | (_| \\__ \\ | | | | (_>  < | |_| | |_| |  __/\\__ \\ |_      ||");
        System.out.println("||     \\____|_|\\__,_|___/_| |_|  \\___/\\/  \\__\\_\\\\__,_|\\___||___/\\__|     ||");
        System.out.println("||                                                                       ||");
        System.out.println("||                   WELCOME TO THE BATTLE ARENA                         ||");
        System.out.println(">>=======================================================================<<");
        System.out.print("Masukkan nama karakter Anda: ");
        String name = scanner.nextLine();
        System.out.println("Pilih Class: 1. Warrior | 2. Mage | 3. Archer");
        System.out.print("Pilihan: ");
        int choice = scanner.nextInt();

        Character player;
        if (choice == 1) player = new Warrior(name);
        else if (choice == 2) player = new Mage(name);
        else player = new Archer(name);

        // 1. Membuat object karakter (Struktur Asli Kamu)
        Warrior arthur = new Warrior("Arthur (Warrior)");
        Mage merlin = new Mage("Merlin (Mage)");
        Archer sparrow = new Archer("Sparrow (Archer)");

        // 2. Menampilkan status awal
        System.out.println("\n=== STATUS AWAL ===");
        System.out.println(arthur.getName() + " | HP: " + arthur.getHp() + " | Atk: " + arthur.getAttackPower() + " | Def: " + arthur.getDefense());
        System.out.println(merlin.getName() + " | HP: " + merlin.getHp() + " | Atk: " + merlin.getAttackPower() + " | Def: " + merlin.getDefense());
        System.out.println(sparrow.getName() + " | HP: " + sparrow.getHp() + " | Atk: " + sparrow.getAttackPower() + " | Def: " + sparrow.getDefense());
        System.out.println();

        // 3. Test serangan manual (Override Test)
        System.out.println("=== TEST CUSTOM ATTACK (OVERRIDE) ===");
        sparrow.attack(arthur); 
        arthur.attack(sparrow);
        System.out.println();

        // 4. Masukkan ke dalam BattleSystem
        System.out.println("=== MASUK KE ARENA BATTLE SYSTEM ===");
        BattleSystem arena = new BattleSystem();
        
        // Bertarung menggunakan karakter yang dipilih user (player) melawan Merlin
        arena.startBattle(player, merlin);

        scanner.close();
    }
}