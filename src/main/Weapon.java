public class Weapon extends Item {
    private int attackBonus;

    public Weapon(String name, int attackBonus) {
        super(name);
        this.attackBonus = attackBonus;
    }

    @Override
    public void use(Character target) {
        target.setAttackPower(target.getAttackPower() + attackBonus);
        System.out.println("⚔️ " + target.getName() + " melengkapi " + this.name + "! Attack Power permanen meningkat +" + attackBonus + "!");
    }
}