package src.story;

import java.util.Scanner;
import src.character.Character;
import src.character.Warrior;
import src.character.Assassin;

public class StoryManager {

    /**
     * Menjalankan alur cerita dan mengembalikan objek Boss sesuai pilihan pemain.
     * @param scanner Scanner dari Main untuk input
     * @return Character (Boss)
     */
    public static Character playStoryMode(Scanner scanner) {
        System.out.println("\n>>====================================<<");
        System.out.println("||             STORY MODE             ||");
        System.out.println(">>====================================<<");
        
        System.out.println("Sistem: Kerajaan Eldoria sedang diserang oleh kekuatan misterius.");
        System.out.println("Sistem: Asap mengepul dari kejauhan, dan jeritan terdengar di udara.");
        
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
            System.out.println("\nSistem: Kamu memasuki Hutan Terlarang yang gelap gulita...");
            System.out.println("Sistem: Tiba-tiba, pepohonan bergerak dan sesosok makhluk raksasa menghadang jalanmu!");
            System.out.println("Sistem: Bersiaplah menghadapi Forest Guardian!");
            
            bossEnemy = new Warrior("Forest Guardian (Raid Boss)");
            bossEnemy.setHp(bossEnemy.getHp() + 150);
            bossEnemy.setAttackPower(bossEnemy.getAttackPower() + 20);
            bossEnemy.setDefense(bossEnemy.getDefense() + 15);
            
        } else {
            System.out.println("\nSistem: Kamu melangkah menuju Kastil Kegelapan yang mencekam...");
            System.out.println("Sistem: Di depan gerbang kastil, seorang ksatria dengan aura mematikan telah menantimu!");
            System.out.println("Sistem: Bersiaplah menghadapi Dark Knight!");
            
            bossEnemy = new Assassin("Dark Knight (Raid Boss)");
            bossEnemy.setHp(bossEnemy.getHp() + 100);
            bossEnemy.setAttackPower(bossEnemy.getAttackPower() + 40);
            bossEnemy.setDefense(bossEnemy.getDefense() + 10);
        }

        System.out.println("\n========================================");
        return bossEnemy;
    }
}
