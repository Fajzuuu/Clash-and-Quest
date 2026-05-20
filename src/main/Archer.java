public class Archer extends Character {
    private double criticalChance;

    public Archer(String name) {
        super(
            name, 
            CalculateByPercentage(BaseHp, 0.25), 
            CalculateByPercentage(BaseAttack, 0.25),
            CalculateByPercentage(BaseDefense,0.1));
        this.criticalChance = 0.35;
    }

    public void displaySpecialStat() {
        System.out.println("Critical Chance: " + (criticalChance * 100) + "%");
    }
}