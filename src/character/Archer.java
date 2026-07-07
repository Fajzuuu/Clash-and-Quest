package src.character;

public class Archer extends Character { 
    private double criticalChance;

    public Archer(String name) {
        super(
            name, 
            CalculateByPercentage(BaseHp, 0.25), 
            CalculateByPercentage(BaseAttack, 0.25),
            CalculateByPercentage(BaseDefense,0.1));
        this.criticalChance = 0.30; // Fitur Critical Hit 30%
    }

    public void displaySpecialStat() {
        System.out.println("Critical Chance: " + (criticalChance * 100) + "%");
    }

    @Override
    public void attack(Character target) {
        int damage = this.attackPower - target.getDefense();
        damage = Math.max(1, damage); 

        System.out.println(this.name + " menembakkan panah tajam ke arah " + target.getName() + "!");

        if (Math.random() < this.criticalChance) {
            System.out.println("CRITICAL HIT! Serangan mengenai titik lemah, damage x2!");
            damage *= 2;
        }

        target.takeDamage(damage);
    }

    @Override
    public void specialAbility(Character target) {
        System.out.println(this.name + " menggunakan skill [Rain of Arrows]!");
        int trueDamage = this.attackPower + 10; 
        System.out.println("Hujan panah mengabaikan pertahanan musuh!");
        target.takeDamage(trueDamage);
    }

    @Override
    public String getClassName() {
        return "Archer";
    }
}