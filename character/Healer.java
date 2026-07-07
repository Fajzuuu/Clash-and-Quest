public class Healer extends Character {
    public Healer(String name) {
        super(
            name, 
            CalculateByPercentage(BaseHp, 0.40),
            CalculateByPercentage(BaseAttack, -0.20),
            CalculateByPercentage(BaseDefense, 0.15)); 
    }

    @Override
    public void attack(Character target) {
        System.out.println(this.name + " memukulkan tongkat sucinya ke " + target.getName() + "!");
        int damageDealt = this.attackPower - target.getDefense();
        damageDealt = Math.max(1, damageDealt);
        target.takeDamage(damageDealt);
    }

    @Override
    public void specialAbility(Character target) {
        System.out.println(this.name + " merapalkan mantra suci [Holy Healing]! ✨💖");
        int healAmount = 35; 
        this.setHp(this.getHp() + healAmount);
        System.out.println("Memulihkan HP diri sendiri sebesar +" + healAmount + " poin! HP sekarang: " + this.getHp());
    }

    @Override
    public String getClassName() {
        return "Healer";
    }
}