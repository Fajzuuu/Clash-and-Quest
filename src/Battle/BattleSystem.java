package src.Battle;

import java.util.Random;
import java.util.Scanner;
import src.character.Character;
import src.item.Item;

public class BattleSystem {
    private final Scanner input = new Scanner(System.in);
    private final Random random = new Random();

    public void startBattle(Character player, Character... enemies) {
        System.out.println("=== PERTARUNGAN ARENA DIMULAI ===");
        
        for (int i = 0; i < enemies.length; i++) {
            Character enemy = enemies[i];
            System.out.println("\n==================================================");
            System.out.println("WAVE " + (i + 1) + ": " + player.getName() + " VS " + enemy.getName() + " (" + enemy.getClassName() + ")");
            System.out.println("==================================================");

            while (player.isAlive() && enemy.isAlive()) {
                System.out.println("\n--- Giliran " + player.getName() + " (Lv. " + player.getLevel() + ") ---");
                System.out.println("HP Anda: " + player.getHp() + " | EXP Anda: " + player.getExp() + "/100 | HP Musuh: " + enemy.getHp()); 
                System.out.println("1. Serang (Basic Attack)");
                System.out.println("2. Gunakan Special Ability");
                System.out.println("3. Bertahan (Gunakan Turn ini untuk observasi)");
                System.out.println("4. Gunakan Item (Sistem Item)");
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

                    for (int k = 0; k < player.getInventory().size(); k++) {
                        Item item = player.getInventory().get(k);
                        System.out.println((k + 1) + ". " + item.getName());
                    }

                    System.out.print("Pilihan Item: ");
                    int itemChoice = Integer.parseInt(input.nextLine()) - 1;

                    if (itemChoice >= 0 && itemChoice < player.getInventory().size()) {
                        Item selectedItem = player.getInventory().get(itemChoice);
                        selectedItem.use(player);
                        player.getInventory().remove(itemChoice);
                    } else {
                        System.out.println("Pilihan tidak valid!");
                    }
                } else {
                    System.out.println("Anda bersiap-siap memperkuat pertahanan...");
                }

                if (!enemy.isAlive()) {
                    System.out.println("\n" + enemy.getName() + " kalah! Anda memenangkan Wave ini!");
                    System.out.println("-----------------------------------");
                    System.out.println("Mengkalkulasi Battle Rewards...");
                    player.gainExp(50);

                    // [Anggota 3] Reward Gold setelah menang
                    int goldReward = (i == enemies.length - 1) ? 200 : 100; // Boss beri 200, minion 100
                    System.out.println("Kamu mendapatkan +" + goldReward + " Gold!");
                    player.addGold(goldReward);

                    // [Anggota 3] Loot item dari musuh (acak)
                    src.item.Item drop = generateEnemyDrop(i == enemies.length - 1);
                    src.item.LootSystem.enemyDrop(player, drop);

                    System.out.println("-----------------------------------");
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

            if (!player.isAlive()) {
                System.out.println("\n=== GAME OVER: Anda Gagal Menyelesaikan Arena ===");
                return;
            }
        }
        
        System.out.println("\nSELAMAT! Anda berhasil mengalahkan seluruh musuh dan menjuarai Arena!");
    }

    /**
     * [Anggota 3] Menghasilkan drop item acak dari musuh.
     * Boss selalu menjatuhkan item, minion 50%.
     */
    private src.item.Item generateEnemyDrop(boolean isBoss) {
        if (!isBoss && random.nextInt(100) < 50) {
            return null; // 50% chance tidak drop
        }
        int roll = random.nextInt(3);
        switch (roll) {
            case 0: return new src.item.Potion("Ramuan Jatuhan",  40, 0);
            case 1: return new src.item.Weapon("Pedang Rampasan", 12, 0);
            default: return new src.item.Armor("Zirah Rampasan",  10, 0);
        }
    }
}