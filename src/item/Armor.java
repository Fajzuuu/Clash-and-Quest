package src.item;

import src.character.Character;

public class Armor implements Item {

    private String name;
    private int defenseBonus;
    private int price;

    public Armor(String name, int defenseBonus) {
        this.name = name;
        this.defenseBonus = defenseBonus;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return "Defense +" + defenseBonus;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void use(Character player) {
        player.setDefense(player.getDefense() + defenseBonus);
    }
}
