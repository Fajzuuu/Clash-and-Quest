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
            System.out.println("4. Gunakan Item (Sistem Item)"); // Opsi Baru
            System.out.print("Pilih aksi (1/2/3/4): ");
            
            String choice = input.nextLine();
            if (choice.equals("1")) {
                player.attack(enemy); 
            } else if (choice.equals("2")) {
                player.specialAbility(enemy);
            } else if (choice.equals("4")) {
                System.out.println("\nPilih Item yang ingin digunakan:");
                if (player.getInventory().isEmpty()) {
                    System.out.println("Inventory kosong!");
                    continue;
                }

                for (int i = 0; i < player.getInventory().size(); i++) {
                    Item item = player.getInventory().get(i);
                    System.out.println((i + 1) + ". " + item.getName());
                }

                System.out.print("Pilihan Item: ");
                int itemChoice = Integer.parseInt(input.nextLine()) - 1;

                if (itemChoice >= 0 && itemChoice < player.getInventory().size()) {
                    Item selectedItem = player.getInventory().get(itemChoice);
                    selectedItem.use(player);

                    // karena quantity = 1 → langsung hapus
                    player.getInventory().remove(itemChoice);
                } else {
                    System.out.println("Pilihan tidak valid!");
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