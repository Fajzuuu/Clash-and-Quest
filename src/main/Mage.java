public class Mage extends Character {
    public Mage(String name) {
        super(
            name, 
            CalculateByPercentage(BaseHp, 0.1), 
            CalculateByPercentage(BaseAttack, 0.5), 
            CalculateByPercentage(BaseDefense, 0.1));
    }
}