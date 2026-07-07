package src.item;
import src.character.Character;

public class Potion implements Item {

    private String name;
    private int healAmount;
    private int price;

    public Potion(String name, int healAmount, int price) {
        this.name = name;
        this.healAmount = healAmount;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getHealAmount() {
        return healAmount;
    }

    @Override
    public String getDescription() {
        return "Heal +" + healAmount;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void use(Character player) {
        int before = player.getHp();
        player.setHp(player.getHp() + healAmount);
        System.out.println("[" + name + "] Memulihkan HP sebesar +" + healAmount + ". HP: " + before + " -> " + player.getHp());
    }
}