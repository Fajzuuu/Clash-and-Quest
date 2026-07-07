package src.item;

import java.util.ArrayList;
import java.util.Scanner;
import src.character.Character;

/**
 * [Anggota 3] Shop System
 * Mengelola toko item: menampilkan daftar item, transaksi pembelian,
 * dan pengurangan gold pemain.
 */
public class Shop {

    private ArrayList<Item> catalog = new ArrayList<>();

    public Shop() {
        // Isi katalog toko dengan item yang tersedia beserta harga
        catalog.add(new Potion("Health Potion",   30,  50));
        catalog.add(new Potion("Mega Potion",      60, 100));
        catalog.add(new Potion("Elixir of Life",  120, 200));
        catalog.add(new Weapon("Pedang Besi",      10,  80));
        catalog.add(new Weapon("Golok Berapi",     25, 150));
        catalog.add(new Weapon("Tongkat Mistis",   20, 130));
        catalog.add(new Armor("Rompi Kulit",        8,  70));
        catalog.add(new Armor("Baju Rantai",       18, 140));
        catalog.add(new Armor("Zirah Mithril",     35, 250));
    }

    /**
     * Menampilkan dan menjalankan sesi belanja interaktif.
     * Pemain bisa membeli beberapa item sekaligus hingga memilih Keluar.
     */
    public void openShop(Character player, Scanner scanner) {
        System.out.println("\n>>========================================<<");
        System.out.println("||             ===== SHOP =====           ||");
        System.out.println(">>========================================<<");

        boolean shopping = true;

        while (shopping) {
            System.out.println("\nGold kamu saat ini: " + player.getGold() + " G");
            System.out.println("------------------------------------------");
            System.out.println("No | Item                 | Efek          | Harga");
            System.out.println("---|----------------------|---------------|------");

            for (int i = 0; i < catalog.size(); i++) {
                Item item = catalog.get(i);
                System.out.printf("%-3d| %-20s | %-13s | %d G%n",
                        (i + 1), item.getName(), item.getDescription(), item.getPrice());
            }

            System.out.println("------------------------------------------");
            System.out.println((catalog.size() + 1) + ". Keluar dari Toko");
            System.out.print("Pilih item yang ingin dibeli: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Masukkan angka.");
                continue;
            }

            if (choice == catalog.size() + 1) {
                System.out.println("Terima kasih sudah berkunjung! Sampai jumpa lagi.");
                shopping = false;

            } else if (choice >= 1 && choice <= catalog.size()) {
                Item selected = catalog.get(choice - 1);
                int price = selected.getPrice();

                System.out.println("Kamu memilih: " + selected.getName()
                        + " | Harga: " + price + " G");

                if (player.spendGold(price)) {
                    // Buat instance baru agar tiap item di inventory independen
                    Item boughtItem = createCopy(selected);
                    player.addItem(boughtItem);
                    System.out.println(">> Pembelian berhasil! "
                            + selected.getName() + " ditambahkan ke inventory.");
                    System.out.println("   Sisa Gold: " + player.getGold() + " G");
                }
                // Jika gagal (gold kurang), spendGold() sudah mencetak pesan

            } else {
                System.out.println("Pilihan tidak valid! Masukkan angka 1-" + (catalog.size() + 1) + ".");
            }
        }
    }

    /**
     * Membuat salinan item baru dari item katalog (agar tidak share referensi).
     */
    private Item createCopy(Item item) {
        if (item instanceof Potion) {
            return new Potion(item.getName(),
                    ((Potion) item).getHealAmount(),
                    item.getPrice());
        } else if (item instanceof Weapon) {
            return new Weapon(item.getName(),
                    ((Weapon) item).getAttackBonus(),
                    item.getPrice());
        } else if (item instanceof Armor) {
            return new Armor(item.getName(),
                    ((Armor) item).getDefenseBonus(),
                    item.getPrice());
        }
        return item;
    }
}
