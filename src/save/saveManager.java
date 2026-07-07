package src.save;

import src.character.Character;
import src.character.*;
import java.io.*;

public class saveManager {
    private static final String FILE_NAME = "savegame.txt";

    public static void saveGame(Character player) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));

            writer.write(player.getClass().getSimpleName());
            writer.newLine();

            writer.write(player.getName());
            writer.newLine();

            writer.write(String.valueOf(player.getHp()));
            writer.newLine();

            writer.write(String.valueOf(player.getAttackPower()));
            writer.newLine();

            writer.write(String.valueOf(player.getDefense()));
            writer.newLine();

            writer.close();

            System.out.println("\nGame berhasil disimpan!");

        } catch (IOException e) {
            System.out.println("Gagal menyimpan game.");
        }
    }

    public static Character loadGame() {

        try {

            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));

            String className = reader.readLine();
            String name = reader.readLine();
            int hp = Integer.parseInt(reader.readLine());
            int atk = Integer.parseInt(reader.readLine());
            int def = Integer.parseInt(reader.readLine());

            Character player;

            switch (className) {

                case "Warrior":
                    player = new Warrior(name);
                    break;

                case "Mage":
                    player = new Mage(name);
                    break;

                case "Assassin":
                    player = new Assassin(name);
                    break;

                case "Healer":
                    player = new Healer(name);
                    break;

                default:
                    player = new Archer(name);
                    break;
            }

            player.setHp(hp);
            player.setAttackPower(atk);
            player.setDefense(def);

            reader.close();

            System.out.println("\nSave berhasil dimuat!");

            return player;

        } catch (Exception e) {

            System.out.println("Save tidak ditemukan.");

            return null;

        }

    }
}
