package src.item;
import src.character.Character;

public class Armor extends Item {
    private int defenseBonus;

    public Armor(String name, int defenseBonus) {
        super(name);
        this.defenseBonus = defenseBonus;
    }

    @Override
    public String getDescription() {
    return "(+" + defenseBonus + " DEF)";
    }
    public void use(src.character.Character target) {
        System.out.println(target.getName() + " menggunakan " + name + "!");
        
        int newDefense = target.getDefense() + defenseBonus;
        target.setDefense(newDefense);

        System.out.println("Defense meningkat menjadi: " + target.getDefense());
    }
}
