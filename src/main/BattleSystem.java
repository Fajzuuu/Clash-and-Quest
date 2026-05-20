import java.util.Random;
import java.util.Scanner;

public class BattleSystem {
    private final Scanner input = new Scanner(System.in);
    private final Random random = new Random();

    public void startBattle(Character player, Character enemy) {
        System.out.println("=== PERTARUNGAN DIMULAI ===");
        System.out.println(player.getName() + " VS " + enemy.getName());

        while (player.isAlive() && enemy.isAlive()) {
            System.out.println("\n--- Giliran " + player.getName() + " ---");
            System.out.println("HP Anda: " + player.getHp() + " | HP Musuh: " + enemy.getHp());
            System.out.println("1. Serang (Basic Attack)");
            System.out.println("2. Gunakan Special Ability");
            System.out.println("3. Bertahan (Gunakan Turn ini untuk observasi)");
            System.out.print("Pilih aksi (1/2/3): ");
            
            String choice = input.nextLine();
            if (choice.equals("1")) {
                player.attack(enemy); 
            } else if (choice.equals("2")) {
                player.specialAbility(enemy);
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