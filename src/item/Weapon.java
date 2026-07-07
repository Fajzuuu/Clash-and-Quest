package src.item;
import src.character.Character;

public class Weapon implements Item {

    private String name;
    private int attackBonus;
    private int price;

    public Weapon(String name, int attackBonus, int price) {
        this.name = name;
        this.attackBonus = attackBonus;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    @Override
    public String getDescription() {
        return "Attack +" + attackBonus;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void use(Character player) {
        player.setAttackPower(player.getAttackPower() + attackBonus);
        System.out.println("[" + name + "] Dipasang! Attack +" + attackBonus + ". Total Attack: " + player.getAttackPower());
    }
}