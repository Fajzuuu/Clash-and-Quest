import java.util.Random;
import java.util.Scanner;
import src.character.Character;
import src.character.*;
import src.item.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // --- Menu CLI ---
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

        System.out.println("===== MENU =====");
        System.out.println("1. New Game");
        System.out.println("2. Load Game");
        System.out.print("Pilihan : ");

        int menu = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Pilih Class: 1. Warrior | 2. Mage | 3. Archer | 4. Assassin | 5. Healer");
        System.out.print("Pilihan: ");
        int choice = scanner.nextInt();

        Character player;
        if (choice == 1) player = new Warrior(name);
        else if (choice == 2) player = new Mage(name);
        else if (choice == 3) player = new Archer(name);
        else if (choice == 4) player = new Assassin(name); 
        else player = new Healer(name);

        player.addItem(new Potion("Mega Potion", 40));
        player.addItem(new Weapon("Belati Mistis", 15));
        player.addItem(new Armor("Baju Zirah Baja", 10));

        System.out.println("\n=== MASUK KE ARENA BATTLE SYSTEM ===");
        BattleSystem arena = new BattleSystem();
        
        Character enemy1 = generateRandomEnemy("Wave 1", false);
        Character bossEnemy = generateRandomEnemy("Wave 2: Raid Boss", true);

        arena.startBattle(player, enemy1, bossEnemy);

        scanner.close();
    }

    private static Character generateRandomEnemy(String title, boolean isBoss) {
        Random rand = new Random();
        
        String[] poolNames = {"Gorgon", "Viper", "Malaketh", "ShadowFang", "Xanthor", "Kaelthas", "Eldrin"};
        String chosenName = poolNames[rand.nextInt(poolNames.length)] + " (" + title + ")";
        
        int classRoll = rand.nextInt(5);
        Character enemy;
        
        switch (classRoll) {
            case 0: enemy = new Warrior(chosenName); break;
            case 1: enemy = new Mage(chosenName); break;
            case 2: enemy = new Archer(chosenName); break;
            case 3: enemy = new Assassin(chosenName); break;
            default: enemy = new Healer(chosenName); break;
        }
        
        if (isBoss) {
            enemy.setHp(enemy.getHp() + 70);       
            enemy.setAttackPower(enemy.getAttackPower() + 15);
        }
        
        return enemy;
    }
}