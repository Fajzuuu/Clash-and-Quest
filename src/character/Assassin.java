package src.character;

public class Assassin extends Character {
    public Assassin(String name) {
        super(
            name, 
            CalculateByPercentage(BaseHp, 0.10), 
            CalculateByPercentage(BaseAttack, 0.60), 
            CalculateByPercentage(BaseDefense, -0.30)); 
    }

    @Override
    public void attack(Character target) {
        System.out.println(this.name + " menyelinap dari bayangan dan menusuk " + target.getName() + "!");
        int damageDealt = this.attackPower - target.getDefense();
        damageDealt = Math.max(1, damageDealt);
        target.takeDamage(damageDealt);
    }

    @Override
    public void specialAbility(Character target) {
        System.out.println(this.name + " menggunakan skill ekstrim [Shadow Strike]! 🗡️⚡");
        // Serangan burst damage tinggi mengabaikan sebagian defense
        int burstDamage = (int) (this.attackPower * 1.6) - (int)(target.getDefense() * 0.3);
        burstDamage = Math.max(20, burstDamage);
        target.takeDamage(burstDamage);
    }

    @Override
    public String getClassName() {
        return "Assassin";
    }
}