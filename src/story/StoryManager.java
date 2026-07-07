package src.story;

import java.util.Scanner;
import src.character.Character;
import src.character.Warrior;
import src.character.Assassin;
import src.item.Armor;
import src.item.LootSystem;
import src.item.Potion;
import src.item.Weapon;

public class StoryManager {

    /**
     * Menjalankan alur cerita dan mengembalikan objek Boss sesuai pilihan pemain.
     * [Anggota 3] Ditambahkan: event peti harta di setiap jalur cerita.
     *
     * @param scanner Scanner dari Main untuk input
     * @param player  Karakter pemain (untuk menerima item dari peti)
     * @return Character (Boss)
     */
    public static Character playStoryMode(Scanner scanner, Character player) {
        System.out.println("\n>>====================================<<");
        System.out.println("||             STORY MODE             ||");
        System.out.println(">>====================================<<");
        
        System.out.println("Kerajaan Eldoria sedang diserang oleh kekuatan misterius.");
        System.out.println("Asap mengepul dari kejauhan, dan jeritan terdengar di udara.");
        
        System.out.println("\n[Penjaga Gerbang]: Hati-hati, Petualang! Monster di luar sana sangat kuat.");
        System.out.println("[Penjaga Gerbang]: Kamu harus memilih jalurmu dengan bijak untuk menghentikan invasi ini.");
        
        System.out.println("\nPilih jalur yang akan kamu tempuh:");
        System.out.println("1. Pergi ke Hutan Terlarang");
        System.out.println("2. Pergi ke Kastil Kegelapan");
        System.out.print("Pilihanmu (1/2): ");
        
        int choice = 1; 
        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
            scanner.nextLine(); 
        } else {
            scanner.nextLine();
        }

        Character bossEnemy;

        if (choice == 1) {
            System.out.println("\nKamu memasuki Hutan Terlarang yang gelap gulita...");
            System.out.println("Tiba-tiba, pepohonan bergerak dan sesosok makhluk raksasa menghadang jalanmu!");

            // [Anggota 3] Event peti harta di Hutan Terlarang
            System.out.println("\nDi balik semak belukar, kamu menemukan sesuatu yang berkilau...");
            LootSystem.openChest(player, new Armor("Zirah Hutan Kuno", 20, 0), scanner);

            System.out.println("\nBersiaplah menghadapi Forest Guardian!");
            
            bossEnemy = new Warrior("Forest Guardian (Raid Boss)");
            bossEnemy.setHp(bossEnemy.getHp() + 150);
            bossEnemy.setAttackPower(bossEnemy.getAttackPower() + 20);
            bossEnemy.setDefense(bossEnemy.getDefense() + 15);
            
        } else {
            System.out.println("\nKamu melangkah menuju Kastil Kegelapan yang mencekam...");
            System.out.println("Di lorong kastil, kamu menemukan ruangan tersembunyi...");

            // [Anggota 3] Event peti harta di Kastil Kegelapan
            LootSystem.openChest(player, new Weapon("Pedang Kegelapan", 30, 0), scanner);

            System.out.println("\nDi depan gerbang kastil, seorang ksatria dengan aura mematikan telah menantimu!");
            System.out.println("Bersiaplah menghadapi Dark Knight!");
            
            bossEnemy = new Assassin("Dark Knight (Raid Boss)");
            bossEnemy.setHp(bossEnemy.getHp() + 100);
            bossEnemy.setAttackPower(bossEnemy.getAttackPower() + 40);
            bossEnemy.setDefense(bossEnemy.getDefense() + 10);
        }

        System.out.println("\n========================================");
        return bossEnemy;
    }
}

