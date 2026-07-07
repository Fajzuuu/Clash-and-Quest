import java.util.Random;
import java.util.Scanner;
import src.character.Character;
import src.character.*;
import src.item.*;
import src.Battle.BattleSystem;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // --- Menu CLI ---
        System.out.println(">>========================================================================<<");
        System.out.println("||      ____ _           _        ___      ___                  _        ||");
        System.out.println("||     / ___| | __ _ ___| |__    ( _ )    / _ \\ _   _  ___  ___| |_      ||");
        System.out.println("||    | |   | |/ _` / __| '_ \\   / _ \\/\\ | | | | | | |/ _ \\/ __| __|     ||");
        System.out.println("||    | |___| | (_| \\__ \\ | | | | (_>  < | |_| | |_| |  __/\\__ \\ |_      ||");
        System.out.println("||     \\____|_|\\__,_|___/_| |_|  \\___/\\/  \\__\\_\\\\__,_|\\___||___/\\__|     ||");
        System.out.println("||                                                                        ||");
        System.out.println("||                   WELCOME TO THE BATTLE ARENA                         ||");
        System.out.println(">>========================================================================<<");
        System.out.print("Masukkan nama karakter Anda: ");
        String name = scanner.nextLine();

        System.out.println("\n===== MENU =====");
        System.out.println("1. New Game");
        System.out.println("2. Load Game");
        System.out.print("Pilihan : ");

        int menu = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Pilih Class: 1. Warrior | 2. Mage | 3. Archer | 4. Assassin | 5. Healer");
        System.out.print("Pilihan: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        Character player;
        if (choice == 1)
            player = new Warrior(name);
        else if (choice == 2)
            player = new Mage(name);
        else if (choice == 3)
            player = new Archer(name);
        else if (choice == 4)
            player = new Assassin(name);
        else
            player = new Healer(name);

        // Item awal (gratis di awal permainan) dengan harga sudah benar
        player.addItem(new Potion("Mega Potion", 40, 0));
        player.addItem(new Weapon("Belati Mistis", 15, 0));
        player.addItem(new Armor("Baju Zirah Baja", 10, 0));

        System.out.println("\n[INFO] Gold awal kamu: " + player.getGold() + " G");

        // [Anggota 3] Buka toko sebelum petualangan dimulai
        System.out.println("\nApakah kamu ingin mengunjungi toko sebelum berangkat?");
        System.out.println("1. Ya, buka toko");
        System.out.println("2. Tidak, langsung berangkat");
        System.out.print("Pilihan: ");
        int shopChoice = scanner.nextInt();
        scanner.nextLine();

        if (shopChoice == 1) {
            Shop shop = new Shop();
            shop.openShop(player, scanner);
        }

        // [Anggota 2]: Menjalankan Story Mode (sekarang menerima player untuk event
        // peti)
        Character storyBoss = src.story.StoryManager.playStoryMode(scanner, player);

        System.out.println("\n=== MASUK KE ARENA BATTLE SYSTEM ===");
        BattleSystem arena = new BattleSystem();

        // Minion masih digenerate secara acak
        Character enemy1 = generateRandomEnemy("Wave 1", false);

        // Memasukkan Boss dari Story Mode ke dalam Battle System
        arena.startBattle(player, enemy1, storyBoss);

        // [Anggota 3] Setelah arena selesai, tawarkan toko lagi jika masih hidup
        if (player.isAlive()) {
            System.out.println("\n[Pedagang]: Kamu baru saja memenangkan arena! Aku punya penawaran spesial.");
            System.out.println("1. Kunjungi Toko Lagi");
            System.out.println("2. Selesai");
            System.out.print("Pilihan: ");
            int postShop = scanner.nextInt();
            scanner.nextLine();

            if (postShop == 1) {
                Shop shop = new Shop();
                shop.openShop(player, scanner);
            }

            System.out.println("\nGold akhir " + player.getName() + ": " + player.getGold() + " G");
            player.showInventory();
        }

        scanner.close();
    }

    private static Character generateRandomEnemy(String title, boolean isBoss) {
        Random rand = new Random();

        String[] poolNames = { "Gorgon", "Viper", "Malaketh", "ShadowFang", "Xanthor", "Kaelthas", "Eldrin" };
        String chosenName = poolNames[rand.nextInt(poolNames.length)] + " (" + title + ")";

        int classRoll = rand.nextInt(5);
        Character enemy;

        switch (classRoll) {
            case 0:
                enemy = new Warrior(chosenName);
                break;
            case 1:
                enemy = new Mage(chosenName);
                break;
            case 2:
                enemy = new Archer(chosenName);
                break;
            case 3:
                enemy = new Assassin(chosenName);
                break;
            default:
                enemy = new Healer(chosenName);
                break;
        }

        if (isBoss) {
            enemy.setHp(enemy.getHp() + 70);
            enemy.setAttackPower(enemy.getAttackPower() + 15);
        }

        return enemy;
    }
}