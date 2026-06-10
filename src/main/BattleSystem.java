import java.util.Random;
import java.util.Scanner;

public class BattleSystem {
    private final Scanner input = new Scanner(System.in);
    private final Random random = new Random();

    // --- TAMBAHAN ANGGOTA 3: Inisialisasi Item untuk Battle ---
    private Item potion = new Potion("Mega Potion", 40);
    private Item weaponUpgrade = new Weapon("Sharpened Edge / Enchanted Bow Strings", 15);
    private boolean potionUsed = false;
    private boolean weaponUsed = false;

    public void startBattle(Character player, Character enemy) {
        System.out.println("=== PERTARUNGAN DIMULAI ===");
        System.out.println(player.getName() + " VS " + enemy.getName());

        while (player.isAlive() && enemy.isAlive()) {
            System.out.println("\n--- Giliran " + player.getName() + " ---");
            System.out.println("HP Anda: " + player.getHp() + " | HP Musuh: " + enemy.getHp());
            System.out.println("1. Serang (Basic Attack)");
            System.out.println("2. Gunakan Special Ability");
            System.out.println("3. Bertahan (Gunakan Turn ini untuk observasi)");
            System.out.println("4. Gunakan Item (Sistem Item)"); // Opsi Baru
            System.out.print("Pilih aksi (1/2/3/4): ");
            
            String choice = input.nextLine();
            if (choice.equals("1")) {
                player.attack(enemy); 
            } else if (choice.equals("2")) {
                player.specialAbility(enemy);
            } else if (choice.equals("4")) {
                // --- INTEGRASI SISTEM ITEM ---
                System.out.println("\nPilih Item yang ingin digunakan:");
                System.out.println("1. " + (potionUsed ? "[HABIS] " : "") + potion.getName() + " (+40 HP)");
                System.out.println("2. " + (weaponUsed ? "[HABIS] " : "") + weaponUpgrade.getName() + " (+15 ATK)");
                System.out.print("Pilihan Item: ");
                String itemChoice = input.nextLine();
                
                if (itemChoice.equals("1") && !potionUsed) {
                    potion.use(player);
                    potionUsed = true;
                } else if (itemChoice.equals("2") && !weaponUsed) {
                    weaponUpgrade.use(player);
                    weaponUsed = true;
                } else {
                    System.out.println("Item tidak valid atau sudah habis digunakan! Giliran Anda terbuang.");
                }
            } else {
                System.out.println("Anda bersiap-siap memperkuat pertahanan...");
            }

            if (!enemy.isAlive()) {
                System.out.println("\n" + enemy.getName() + " kalah! Selamat, Anda menang!");
                break;
            }

            System.out.println("\n--- Giliran " + enemy.getName() + " ---");

            if (random.nextInt(100) < 25) {
                enemy.specialAbility(player);
            } else {
                enemy.attack(player);
            }

            if (!player.isAlive()) {
                System.out.println("\nAnda telah dikalahkan oleh " + enemy.getName() + "...");
                break;
            }
            
            System.out.println("-----------------------------------");
        }
    }
}