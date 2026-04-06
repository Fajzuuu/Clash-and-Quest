import java.util.Random;
import java.util.Scanner;

public class BattleSystem {
    private final Scanner input = new Scanner(System.in);
    private final Random random = new Random();

    public void startBattle(Character player, Character enemy) {
        System.out.println("=== PERTARUNGAN DIMULAI ===");
        System.out.println(player.getName() + " VS " + enemy.getName());

        while (player.isAlive() && enemy.isAlive()) {
            // --- GILIRAN PLAYER ---
            System.out.println("\n--- Giliran " + player.getName() + " ---");
            System.out.println("HP Anda: " + player.getHp() + " | HP Musuh: " + enemy.getHp());
            System.out.println("1. Serang");
            System.out.println("2. Bertahan (Gunakan Turn ini untuk observasi)");
            System.out.print("Pilih aksi (1/2): ");
            
            String choice = input.nextLine();

            if (choice.equals("1")) {
                calculateAndAttack(player, enemy);
            } else {
                System.out.println("Anda bersiap-siap...");
            }

            if (!enemy.isAlive()) {
                System.out.println("\n" + enemy.getName() + " kalah! Selamat, Anda menang!");
                break;
            }

            // --- GILIRAN SISTEM (ENEMY) ---
            System.out.println("\n--- Giliran " + enemy.getName() + " ---");
            calculateAndAttack(enemy, player);

            if (!player.isAlive()) {
                System.out.println("\nAnda telah dikalahkan oleh " + enemy.getName() + "...");
                break;
            }
            
            System.out.println("-----------------------------------");
        }
    }

    private void calculateAndAttack(Character attacker, Character defender) {
        // Mekanisme: ATK awal - RNG - def target
        int rng = random.nextInt(attacker.getAttackPower() / 2); // RNG 0 - 50% ATK
        int damageDealt = attacker.getAttackPower() - rng - defender.getDefense();

        if (damageDealt < 0) damageDealt = 0;

        System.out.println(attacker.getName() + " meluncurkan serangan!");
        defender.takeDamage(damageDealt);
    }
}