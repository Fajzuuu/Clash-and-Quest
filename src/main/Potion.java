public class Potion extends Item {
    private int healAmount;

    public Potion(String name, int healAmount) {
        super(name);
        this.healAmount = healAmount;
    }

    @Override
    public void use(Character target) {
        target.setHp(target.getHp() + healAmount);
        System.out.println( target.getName() + " menggunakan " + this.name + " dan memulihkan " + healAmount + " HP!");
    }
}