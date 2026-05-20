public class Warrior extends Character {
    public Warrior(String name) {
        super(
            name, 
            CalculateByPercentage(BaseHp, 0.5), 
            CalculateByPercentage(BaseAttack, 0.25), 
            CalculateByPercentage(BaseDefense, 0.5));
    }
}