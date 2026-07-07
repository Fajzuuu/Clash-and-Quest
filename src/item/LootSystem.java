package src.item;

import java.util.Scanner;
import src.character.Character;

/**
 * [Anggota 3] Loot System
 * Menangani penemuan item dari peti harta, hasil loot musuh,
 * atau hadiah di dalam cerita (story event).
 */
public class LootSystem {

    /**
     * Menampilkan peti harta dengan satu item dan memberi pilihan pemain
     * untuk mengambil atau meninggalkan item tersebut.
     *
     * @param player    Karakter pemain
     * @param lootItem  Item yang bisa diambil dari peti
     * @param scanner   Scanner untuk input
     */
    public static void openChest(Character player, Item lootItem, Scanner scanner) {
        System.out.println("\n>>============================================<<");
        System.out.println("||         ** KAMU MENEMUKAN SEBUAH PETI! **  ||");
        System.out.println(">>============================================<<");
        System.out.println("  Di dalam peti terdapat: " + lootItem.getName());
        System.out.println("  (" + lootItem.getDescription() + ")");
        System.out.println("----------------------------------------------");
        System.out.println("1. Ambil " + lootItem.getName());
        System.out.println("2. Tinggalkan");
        System.out.print("Pilihanmu (1/2): ");

        String input = scanner.nextLine().trim();

        if (input.equals("1")) {
            player.addItem(lootItem);
            System.out.println(">> " + lootItem.getName() + " berhasil diambil dan disimpan ke inventory!");
        } else {
            System.out.println(">> Kamu meninggalkan peti itu dan melanjutkan perjalanan.");
        }
    }

    /**
     * Memberikan reward item langsung ke inventory tanpa pilihan
     * (dipakai untuk reward setelah pertarungan atau event cerita).
     *
     * @param player    Karakter pemain
     * @param reward    Item hadiah
     */
    public static void giveReward(Character player, Item reward) {
        System.out.println("\n[REWARD] Kamu mendapatkan item: " + reward.getName()
                + " (" + reward.getDescription() + ")!");
        player.addItem(reward);
    }

    /**
     * Menampilkan event loot musuh setelah pertarungan selesai.
     * Ada kemungkinan item ditemukan (acak/boss pasti dapat).
     *
     * @param player    Karakter pemain
     * @param lootItem  Item loot dari musuh (null jika tidak ada)
     */
    public static void enemyDrop(Character player, Item lootItem) {
        if (lootItem == null) {
            System.out.println("[LOOT] Musuh tidak menjatuhkan item.");
            return;
        }
        System.out.println("\n[LOOT] Musuh menjatuhkan: " + lootItem.getName()
                + " (" + lootItem.getDescription() + ")!");
        player.addItem(lootItem);
    }
}
